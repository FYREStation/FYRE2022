/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;
//import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;

public class Driving extends CommandBase {
	private DriveTrain drive_train;
	private double move_speed, rot_speed;
	private double x_left, y_left, x_right, y_right;

	private double XRightJoyStick, YRightJoyStick;
	//private double y_right = RobotContainer.driverControl.getRightY();

	public Driving(DriveTrain m_drivetrain) {
		drive_train = m_drivetrain;

		addRequirements(drive_train);
    }

    // Called just before this Command runs the first time
	@Override
	public void initialize() {
		
	} 

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		x_left = RobotContainer.driverControl.getLeftX();
	 	y_left = RobotContainer.driverControl.getLeftY();
		x_right = RobotContainer.driverControl.getRightX();
		y_right = RobotContainer.driverControl.getRightY();

		//System.out.println(Constants.throttle * move_Speed.getAsDouble() + "and " + Constants.throttle *  rotate_Speed.getAsDouble());
		if (Constants.isTank) {
			move_speed = y_left;	
		} else {
			move_speed = x_right;
		}

		rot_speed = -x_right;
	
		if (rot_speed < 0.2 && rot_speed > -0.2) {
			rot_speed = 0.0;
		} 

		if (move_speed < 0.2 && move_speed > -0.2) {
			move_speed = 0.0;
		}
	
		double leftPower = rot_speed - move_speed;
		double rightPower = rot_speed + move_speed;

		leftPower = -leftPower;
		rightPower = -rightPower;

		drive_train.tankDrive(Constants.throttle * leftPower, Constants.throttle * rightPower);
		
		// System.out.println(move_speed + " : " + rot_speed);
		// drive_train.arcadeDrive(Constants.throttle * x_right * Math.abs(x_right), Constants.throttle * y_left * Math.abs(y_left));
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
}