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
	private DriveTrain mDriveTrain;
	private double yLeft, xRight;

	public Driving(DriveTrain subsystem) {
		mDriveTrain = subsystem;
		addRequirements(subsystem);
    }

	@Override
	public void initialize() {} 

	@Override
	public void execute() {
		//-> Grabs orientation of XboxController joysticks. 
		yLeft = -RobotContainer.driverControl.getLeftY();
		xRight = RobotContainer.driverControl.getRightX();

		//-> Passes joystick orientation into arcadeDrive and moves robot accordingly. 
		mDriveTrain.arcadeDrive(Constants.throttle * deadband(xRight) , Constants.throttle * deadband(yLeft));
		//System.out.println(-yLeft * Constants.throttle + " = left joystick movement // " + xRight * Constants.throttle + " = right joystick movement"); //-> Printout statement for throttle speed. 
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