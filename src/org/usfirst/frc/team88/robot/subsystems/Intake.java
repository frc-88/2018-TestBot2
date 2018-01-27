package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.Robot;
import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Kyle Hackett
 * 
 * Intake Haiku v1.
 * 
 * Oh this sick intake
 * This is an awesome Haikau
 * It pulls cubes cool-ly
 */
public class Intake extends Subsystem {
	final double MAXSPEED = .75;
	final double SECONDSPEED = .50;
	private Talon rightSide; 
	private Talon leftSide; 
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public Intake () {

		rightSide = new Talon(RobotMap.rightSide);
		leftSide = new Talon(RobotMap.leftSide);

	}

	public void intakeWheelSpeed (double speed) {

		if (Robot.oi.getDriverZ() > 0){
			rightSide.set(speed * SECONDSPEED);
			leftSide.set(speed * MAXSPEED);
		}
		else  { 
			rightSide.set(speed * MAXSPEED);
			leftSide.set(speed * MAXSPEED);
		}

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new IntakeCommand());


	}
}

