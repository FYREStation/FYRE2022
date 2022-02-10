package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;

public class Driving extends CommandBase {
	private DriveTrain drive_train;
	private double move_speed, rot_speed;
	private double x_left, y_left, x_right, y_right;

	public Driving(DriveTrain m_drivetrain) {
		drive_train = m_drivetrain;

		addRequirements(drive_train);
    }

	@Override
	public void initialize() {
		
	} 

	@Override
	public void execute() {
		x_left = RobotContainer.driverControl.getLeftX();
	 	y_left = RobotContainer.driverControl.getLeftY();
		x_right = RobotContainer.driverControl.getRightX();
		y_right = RobotContainer.driverControl.getRightY();

		if (Constants.isTank) {
			move_speed = y_left;	
		} else {
			move_speed = x_right;
		}
		rot_speed = -x_right;
	
		deadband(rot_speed); 
		deadband(move_speed);
	
		double leftPower = -(rot_speed - move_speed);
		double rightPower = -(rot_speed + move_speed);

		drive_train.tankDrive(Constants.throttle * leftPower, Constants.throttle * rightPower);
		
		// System.out.println(move_speed + " : " + rot_speed);
		// drive_train.arcadeDrive(Constants.throttle * x_right * Math.abs(x_right), Constants.throttle * y_left * Math.abs(y_left));
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public void end(boolean interrupted) {

	}

	public double deadband(double value) {
		if (value < 0.2 && value > -0.2) {
			return 0.0;
		}
		return value;
	}
}