package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.DriveSplitArcade;
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
	private final static double DFT_SENSITIVITY = 0.15;

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
	
	/**
	 * The below was based on (ie, copied from) very similar code in the WPILib
	 * RobotDrive class on 1/18/2017
	 * 
	 * Drive the motors at "outputMagnitude" and "curve". Both outputMagnitude
	 * and curve are -1.0 to +1.0 values, where 0.0 represents stopped and not
	 * turning. {@literal curve < 0 will turn left
	 * and curve > 0} will turn right.
	 *
	 * <p>
	 * The algorithm for steering provides a constant turn radius for any normal
	 * speed range, both forward and backward. Increasing sensitivity causes
	 * sharper turns for fixed values of curve.
	 *
	 * <p>
	 * This function will most likely be used in an autonomous routine.
	 *
	 * @param outputMagnitude
	 *            The speed setting for the outside wheel in a turn, forward or
	 *            backwards, +1 to -1.
	 * @param curve
	 *            The rate of turn, constant for different forward speeds. Set
	 *            {@literal
	 *                        curve < 0 for left turn or curve > 0 for right turn.}
	 *            Set curve = e^(-r/w) to get a turn radius r for wheelbase w of
	 *            your robot. Conversely, turn radius r = -ln(curve)*w for a
	 *            given value of curve and wheelbase w.
	 */
	public void driveCurve(double outputMagnitude, double curve) {
		driveCurve(outputMagnitude, curve, DFT_SENSITIVITY);

	}

	public void driveCurve(double outputMagnitude, double curve, double sensitivity) {
		double leftOutput;
		double rightOutput;

		SmartDashboard.putNumber("Curve", curve);
		SmartDashboard.putNumber("Magnitude", outputMagnitude);
		
		if (Math.abs(outputMagnitude) < 0.10) {
			leftOutput = -curve * 0.5;
			rightOutput = curve * 0.5;
		} else if (curve < 0) {
			double value = Math.log(-curve);
			double ratio = (value - sensitivity) / (value + sensitivity);
			if (ratio == 0) {
				ratio = .0000000001;
			}
			leftOutput = outputMagnitude / ratio;
			rightOutput = outputMagnitude;
		} else if (curve > 0) {
			double value = Math.log(curve);
			double ratio = (value - sensitivity) / (value + sensitivity);
			if (ratio == 0) {
				ratio = .0000000001;
			}
			leftOutput = outputMagnitude;
			rightOutput = outputMagnitude / ratio;
		} else {
			leftOutput = outputMagnitude;
			rightOutput = outputMagnitude;
		}

		wheelSpeed(leftOutput, rightOutput);
	}


	public void initDefaultCommand() {
		//setDefaultCommand(new DriveTank());
		setDefaultCommand(new DriveSplitArcade());
	}
}

