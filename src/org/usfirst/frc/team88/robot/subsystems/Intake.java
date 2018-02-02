package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.Distances;
import org.usfirst.frc.team88.robot.Robot;
import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.SharpIR;
import org.usfirst.frc.team88.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private SharpIR distanceSensorRight;
	private SharpIR distanceSensorLeft;
	private boolean haveCube = false;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public Intake () {

		rightSide = new Talon(RobotMap.rightSide);
		leftSide = new Talon(RobotMap.leftSide);
		distanceSensorRight = new SharpIR(RobotMap.sharpIR_RIGHT);
		distanceSensorLeft = new SharpIR(RobotMap.sharpIR_LEFT);

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

	public Distances cubeDistance(){
		Distances distance = new Distances(distanceSensorLeft.getDistance(), distanceSensorRight.getDistance());
		
		
		//TODO Change the distances to allow for different positions of cube as well as the actual distance
		if((distance.left < 5)&&(distance.right < 5)){
			haveCube = true;
		}
		else {
			haveCube = false;
		}
		SmartDashboard.putBoolean("Intake/Has Cube", haveCube);
		return distance ;
		
	}
	
	public void UpdateDashboard(){
		
		SmartDashboard.putNumber("Intake/IR Sensor Distance Left", distanceSensorLeft.getDistance() );
		SmartDashboard.putNumber("Intake/IR Sensor Distance Right", distanceSensorRight.getDistance());
		SmartDashboard.putNumber("Intake/IR Sensor Voltage Left", distanceSensorLeft.getVoltage());
		SmartDashboard.putNumber("Intake/IR Sensor Voltage Right", distanceSensorRight.getVoltage());
		
		
		
		
	}


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new IntakeCommand());
	}



}

