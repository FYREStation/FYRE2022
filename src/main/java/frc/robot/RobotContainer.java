/*
	[ RobotContainer.java ]
	The bulk of all robot code and 
	initialization is contained here. 

*/ 

/* -> This class is where the bulk of the robot should be declared. Since command-based 
is a "declarative paradigm", very little robot logic should be handled in the Robot periodic 
methods, other than scheduler calls. Button mapping, subsystems, and commands should be 
instead declared here. */ 

// [ Package ] 
package frc.robot;

// [ Imports ] 
// // [ Files ] 
import frc.robot.commands.*;
import frc.robot.subsystems.*;
// // [ Classes ] 
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/* import edu.wpi.first.wpilibj.GenericHID;
   import com.fasterxml.jackson.databind.util.ArrayIterator;
   import edu.wpi.first.util.sendable.Sendable;
   import edu.wpi.first.wpilibj.simulation.JoystickSim;
   import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; */ 

// [ Functions ] 
public class RobotContainer {
	public static final Joystick manipulatorControl = new Joystick(0);
	public static final XboxController driverControl = new XboxController(1);

	//-> Series of declared Joystick buttons for controlling purposes. 
	private final JoystickButton J1 = new JoystickButton(manipulatorControl, 1);
	private final JoystickButton J2 = new JoystickButton(manipulatorControl, 2); 
	private final JoystickButton J3 = new JoystickButton(manipulatorControl, 3);  
	//private final JoystickButton J4 = new JoystickButton(manipulatorControl, 4);  
	private final JoystickButton J5 = new JoystickButton(manipulatorControl, 5);
	//private final JoystickButton J6 = new JoystickButton(manipulatorControl, 6);
	private final JoystickButton J7 = new JoystickButton(manipulatorControl, 7);
	private final JoystickButton J8 = new JoystickButton(manipulatorControl, 8);
	private final JoystickButton J9 = new JoystickButton(manipulatorControl, 9);
	private final JoystickButton J10 = new JoystickButton(manipulatorControl, 10);
	private final JoystickButton J11 = new JoystickButton(manipulatorControl, 11);
  	private final JoystickButton J12 = new JoystickButton(manipulatorControl, 12);

	//-> Series of defined subsystems. 
	// private final Vision mVision = new Vision();
	private final Shooter mShooter = new Shooter();
	private final Climber mClimber = new Climber();
	private final Intake mIntake = new Intake();
	private static DriveTrain mDriveTrain = new DriveTrain();
	SendableChooser<Command> mChooser = new SendableChooser<>();

	//-> Chosen autonomous command, passed to getAutonomousCommand(). 
	private final Autonomous mAutoCommand = new Autonomous(mDriveTrain);

	//-> The container for the robot. Contains subsystems, OI devices, and commands.
	public RobotContainer() {
		mDriveTrain.setDefaultCommand(new Driving(mDriveTrain));
		// m_intake_spin.setDefaultCommand(new ThrottleAdjust());
    	configureButtonBindings();
	}

	//-> Method container for mapping button inputs to commands. 
	private void configureButtonBindings() {
    	J12.whileHeld(new ElevatorPower(mClimber, "ElevatorPositive"));
		J11.whileHeld(new ElevatorPower(mClimber, "ElevatorNegative"));
		
    	J10.whileHeld(new ElevatorPower(mClimber, "ArticulateNegative"));
		J9.whileHeld(new ElevatorPower(mClimber, "ArticulatePositive"));
		
    	J8.whileHeld(new ElevatorPower(mClimber, "HookPositive"));
		J7.whileHeld(new ElevatorPower(mClimber, "HookNegative"));
		
		J5.whileHeld(new IntoIntake(mIntake, "IntakeForward"));
		J3.whileHeld(new IntoIntake(mIntake, "IntakeBackward"));

		J2.whileHeld(new OneShot(mShooter, mIntake));
		J1.whileHeld(new ControlShot(mShooter, "ShooterBackward")); 
		// J1.whileHeld(new OneShot(mShooter, mIntake));
	}

	//-> Passes autonomous command to Robot class. 
	public Command getAutonomousCommand() {
		return mAutoCommand;
	}
}

