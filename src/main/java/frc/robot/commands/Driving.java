/*
    [ commands / Driving.java ]
	Established framework for 
	driving system of the robot. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ]
// // [ Files ]
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class Driving extends CommandBase {
	private DriveTrain drive_train;
	private double y_left, x_right;

	public Driving(DriveTrain m_drivetrain) {
		drive_train = m_drivetrain;
		addRequirements(drive_train);
    }

	@Override
	public void initialize() {} 

	@Override
	public void execute() {
		//-> Grabs orientation of XboxController joysticks. 
	 	y_left = -RobotContainer.driverControl.getLeftY();
		x_right = RobotContainer.driverControl.getRightX();

		//-> Passes joystick orientation into arcade_drive and moves robot accordingly. 
		drive_train.arcadeDrive(Constants.throttle * deadband(x_right) , Constants.throttle * deadband(y_left)); //-> Unused arcade drive alternative.
		//System.out.println(-y_left * Constants.throttle + " = left joystick movement // " + x_right * Constants.throttle + " = right joystick movement");
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public void end(boolean interrupted) {}

	//-> Sets values to 0 if it falls in specific threshold. 
	public double deadband(double value) {
		if (value < 0.2 && value > -0.2) {
			return 0.0;
		}
		return value;
	}
}