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
	private double move_speed, rot_speed;

	private double y_left, x_right;
	// private double x_left, y_right //-> Unused variables.

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

		/* x_left = RobotContainer.driverControl.getLeftX();
		   y_right = RobotContainer.driverControl.getRightY(); */ //-> Possible axes for edited controller settings. 

		//-> Checks if robot is in Tank mode; sets new movement variables accordingly. 
		if (Constants.isTank) {
			move_speed = -y_left;	
		} else {
			move_speed = y_left;
		}
		rot_speed = -x_right;
	
		rot_speed = deadband(rot_speed); 
		move_speed = deadband(move_speed);
	
		//-> Creates new power variables and applies them to tankDrive method, thus moving robot. 
		double leftPower = -(rot_speed - move_speed);
		double rightPower = -(rot_speed + move_speed);

		// drive_train.tankDrive(Constants.throttle * leftPower, Constants.throttle * rightPower);
		drive_train.arcadeDrive(Constants.throttle * x_right , Constants.throttle * -y_left); //-> Unused arcade drive alternative.
		System.out.println(-y_left * Constants.throttle + " = left joystick movement // " + x_right * Constants.throttle + " = right joystick movement");
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