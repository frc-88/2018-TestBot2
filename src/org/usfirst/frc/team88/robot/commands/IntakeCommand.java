package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Distances;
import org.usfirst.frc.team88.robot.Robot;
import org.usfirst.frc.team88.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeCommand extends Command {

	final int BAD_SENSOR_DISTANCE = 100;
	private int COUNT = 0;
	private boolean badLeftSensor = false;
	private boolean badRightSensor = false;

	public IntakeCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		Robot.intake.UpdateDashboard();
		Robot.intake.intakeWheelSpeed(Robot.oi.applyPoly(Robot.oi.getDriverZ()));
		

		// Disconnected Sensor 
		Distances distance = Robot.intake.cubeDistance();

		SmartDashboard.putBoolean("Right Sensor Disconnected", badRightSensor);
		SmartDashboard.putBoolean("Left Sensor Disconnected", badLeftSensor);
		
		//Left
		if ((distance.left > 20 )&& (distance.left < 22) ){

			COUNT++;
			if (COUNT == BAD_SENSOR_DISTANCE){

				badLeftSensor = true;

			}

		}
		else{
			COUNT = 0;
			badLeftSensor = false;
		}
		
		//RIGHT
		if ((distance.right > 20 )&& (distance.right < 22) ){

			COUNT++;
			if (COUNT == BAD_SENSOR_DISTANCE){

				badRightSensor = true;
						

			}

		}
		else{
			COUNT = 0;
			badRightSensor = false;
			
		}

	}

	
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.intake.intakeWheelSpeed(0.0);
	}
}
