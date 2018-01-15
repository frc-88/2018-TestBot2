package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.DriveTank;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends Subsystem {
	private Spark leftSpark;
	private Spark rightSpark;
	private Victor rightVictor;
	private Victor leftVictor;
	private AHRS navX;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public Drive () {
		leftSpark = new Spark(RobotMap.leftSpark);
		rightSpark = new Spark(RobotMap.rightSpark);
		leftVictor = new Victor(RobotMap.leftVictor);
		rightVictor = new Victor(RobotMap.rightVictor);
		
		navX = new AHRS(SPI.Port.kMXP);
	}
	
	public void wheelSpeed(double left, double right){
		leftSpark.set(-left);
		leftVictor.set(-left);

		
		rightSpark.set(right);
		rightVictor.set(right);
		
		SmartDashboard.putNumber("left", left);
		SmartDashboard.putNumber("right", right);
		SmartDashboard.putNumber("Yaw", navX.getYaw());
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveTank());
	}
}

