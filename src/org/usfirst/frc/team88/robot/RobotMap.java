package org.usfirst.frc.team88.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// Drive
	public static int leftSpark = 4;
	public static int rightSpark = 3;
	public static int leftVictor = 2;
	public static int rightVictor = 1;
	
	// Intake 
	public static int leftSide = 5;
	public static int rightSide = 6;
	     //Analog Input
	public static int sharpIR_RIGHT = 0;
	public static int sharpIR_LEFT = 1;
		//Pneumatics
	public static int intakeSolenoidIn;
	public static int intakeSolenoidOut;
	
	
}
