package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.Robot;
import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.SharpIR;
import org.usfirst.frc.team88.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Kyle Hackett
 * 
 * Intake Haiku v2.
 * 
 * The green wheels spin fast
 * The cube is now ours to use
 * And now we will win
 *
 */
public class Intake extends Subsystem {
	final double MAXSPEED = .75;
	final double LOWERSPEED = .50;
	private Talon rightSide; 
	private Talon leftSide; 
	private SharpIR distanceSensor;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public Intake () {

		rightSide = new Talon(RobotMap.rightSide);
		leftSide = new Talon(RobotMap.leftSide);
		distanceSensor = new SharpIR(RobotMap.sharpIR);

	}

	public void intakeWheelSpeed (double speed) {

		if (Robot.oi.getDriverZ() > 0){
			rightSide.set(speed * LOWERSPEED);
			leftSide.set(speed * MAXSPEED);
		}
		else  { 
			rightSide.set(speed * MAXSPEED);
			leftSide.set(speed * MAXSPEED);
		}

	}

	public double cubeDistance(){
		double distance = distanceSensor.getDistance();

		return distance;
	}


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new IntakeCommand());
	}



}

