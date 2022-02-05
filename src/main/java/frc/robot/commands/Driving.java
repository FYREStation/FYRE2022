/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;


public class Driving extends CommandBase {

	private DriveTrain drive_train;
	private double move_Speed;
	private double rotate_Speed;
	private double XJoyStick;
	private double YJoyStick;
	private double XRightJoyStick;
	private double YRightJoyStick;

    public Driving(DriveTrain m_drivetrain, double d, double e, double f, double g) {
        drive_train = m_drivetrain;
		XJoyStick = d;
		YJoyStick = e;
		XRightJoyStick = f;
		YRightJoyStick = g;
		
		addRequirements(drive_train);
    }

    // Called just before this Command runs the first time
	@Override
	public void initialize() {
	} 

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
			double yValue;
			double xValue;
			//System.out.println(Constants.throttle * move_Speed.getAsDouble() + "and " + Constants.throttle *  rotate_Speed.getAsDouble());
			if(Constants.isTank){
				xValue=XRightJoyStick;	
			}else{
				xValue=XJoyStick;
			}

			yValue = YJoyStick;
	
			if(yValue < 0.2 && yValue > -0.2){
				yValue = 0.0;
			} 
			if(xValue < 0.2 && xValue > -0.2){
				xValue = 0.0;
			} 
			

			double leftPower = yValue - xValue;
			double rightPower = yValue + xValue;
			leftPower = -leftPower;
			rightPower = -rightPower;
			drive_train.tankDrive(Constants.throttle * leftPower, Constants.throttle * rightPower);
			
			
			
			//drive_train.arcadeDrive(Constants.throttle * move_Speed.getAsDouble(), Constants.throttle * YJoyStick.getAsDouble());
		
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