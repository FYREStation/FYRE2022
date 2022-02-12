/*
	[ Main.java ]
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
	private final Joystick manipulatorControl = new Joystick(0);
	public static XboxController driverControl = new XboxController(1);

	//-> Series of declared Joystick buttons for controlling purposes. 
	private final JoystickButton J1 = new JoystickButton(manipulatorControl, 1); // whileHeld: m_intake (spin intake in)
	private final JoystickButton J2 = new JoystickButton(manipulatorControl, 2); // whileHeld: m_intake (spin intake out)

	//-> Series of defined subsystems. 
	private final Shooter m_shooter = new Shooter();
	private final Climber m_climber = new Climber();
	private static DriveTrain m_drivetrain = new DriveTrain();
	// private final Intake m_intake = new Intake();
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	//-> Chosen autonomous command, passed to getAutonomousCommand(). 
	private final Autonomous m_autoCommand = new Autonomous(m_drivetrain);

	//-> The container for the robot. Contains subsystems, OI devices, and commands.
	public RobotContainer() {
		m_drivetrain.setDefaultCommand(new Driving(m_drivetrain));
    	configureButtonBindings();
	}

	//-> Method container for mapping button inputs to commands. 
	private void configureButtonBindings() {
		J1.whileHeld(new ElevatorPower(m_climber, "Hook"));
		J2.whenPressed(new ControlShot(m_shooter));
	}

	//-> Passes autonomous command to Robot class. 
	public Command getAutonomousCommand() {
		return m_autoCommand;
	}
}
