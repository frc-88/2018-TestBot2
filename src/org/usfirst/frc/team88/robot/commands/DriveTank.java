package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTank extends Command {

    public DriveTank() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double left, right;
    	
    	right = Robot.oi.applyPoly(Robot.oi.getDriverRightY());
    	left = Robot.oi.applyPoly(Robot.oi.getDriverLeftY());
    	
    	SmartDashboard.putNumber("left", left);
    	SmartDashboard.putNumber("right", right);
    	
    	Robot.drive.wheelSpeed(left, right);
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
    	Robot.drive.wheelSpeed(0,0);
    }
}

//GITHUB PULL TEST - KH
