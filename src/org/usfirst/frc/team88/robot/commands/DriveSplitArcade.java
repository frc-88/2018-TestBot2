package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveSplitArcade extends Command {
	public final static double SENSITIVITY = 0.25;

	public DriveSplitArcade() {
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double magnitude, curve;

		// below for rocket league style
		// magnitude = Robot.oi.applySquare(Robot.oi.getDriverZ());
		magnitude = Robot.oi.applyPoly(Robot.oi.getDriverLeftY());
		curve = Robot.oi.applyPoly(Robot.oi.getDriverRightX());

		Robot.drive.driveCurve(magnitude, curve, SENSITIVITY);
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
		Robot.drive.wheelSpeed(0, 0);
	}
}
