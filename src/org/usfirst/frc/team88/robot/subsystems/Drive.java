package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.DriveTank;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	private Spark leftSpark;
	private Spark rightSpark;
	private Victor rightVictor;
	private Victor leftVictor;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public Drive () {
		leftSpark = new Spark(RobotMap.leftSpark);
		rightSpark = new Spark(RobotMap.rightSpark);
		leftVictor = new Victor(RobotMap.leftVictor);
		rightVictor = new Victor(RobotMap.rightVictor);
	}
	
	public void wheelSpeed(double left, double right){
		leftSpark.set(-left);
		leftVictor.set(-left);

		
		rightSpark.set(right);
		rightVictor.set(right);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveTank());
	}
}

