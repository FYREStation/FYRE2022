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
import frc.robot.commands.AutoSequence.BootUpShot;
import frc.robot.commands.AutoSequence.SpinAngle;
import frc.robot.commands.AutoSequence.SpitOut;
import frc.robot.commands.AutoSequence.StraightAuto;
import frc.robot.subsystems.*;
// // [ Classes ] 
import edu.wpi.first.wpilibj.XboxController;

import javax.sound.sampled.Control;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/* import edu.wpi.first.wpilibj.GenericHID;
   import com.fasterxml.jackson.databind.util.ArrayIterator;
   import edu.wpi.first.util.sendable.Sendable;
   import edu.wpi.first.wpilibj.simulation.JoystickSim;
   import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; */ 

// [ Functions ] 
public class RobotContainer {
	public final static Joystick manipulatorControl = new Joystick(0);
	public final static XboxController driverControl = new XboxController(1);

	//-> Series of declared Joystick buttons for controlling purposes. 
	private final JoystickButton J1 = new JoystickButton(manipulatorControl, 1);
	private final JoystickButton J2 = new JoystickButton(manipulatorControl, 2); 
	private final JoystickButton J3 = new JoystickButton(manipulatorControl, 3);  
	private final JoystickButton J4 = new JoystickButton(manipulatorControl, 4);  
	private final JoystickButton J5 = new JoystickButton(manipulatorControl, 5);
	private final JoystickButton J6 = new JoystickButton(manipulatorControl, 6);
	private final JoystickButton J7 = new JoystickButton(manipulatorControl, 7);
	private final JoystickButton J8 = new JoystickButton(manipulatorControl, 8);
	private final JoystickButton J9 = new JoystickButton(manipulatorControl, 9);
	private final JoystickButton J10 = new JoystickButton(manipulatorControl, 10);
	private final JoystickButton J11 = new JoystickButton(manipulatorControl, 11);
  	private final JoystickButton J12 = new JoystickButton(manipulatorControl, 12);

	private final JoystickButton X5 = new JoystickButton(driverControl, 5);
	private final JoystickButton X6 = new JoystickButton(driverControl, 6);

	//-> Series of defined subsystems. 
	private final Vision m_vision = new Vision();
	private final Shooter m_shooter = new Shooter();
	private final Climber m_climber = new Climber();
	private final Intake m_intake = new Intake();
	private static DriveTrain m_drivetrain = new DriveTrain();
	// private final Intake m_intake = new Intake();
	SendableChooser<SequentialCommandGroup> m_chooser = new SendableChooser<>();

	//-> Chosen autonomous command, passed to getAutonomousCommand(). 
	//private final Autonomous m_autoCommand = new Autonomous(m_drivetrain);
	//private final StraightAuto m_autoCommand = new StraightAuto(m_drivetrain);
	//private final PathWeaverTest1 m_autoCommand = new PathWeaverTest1(m_drivetrain);
	
	private final StraightAuto stepOneLeft = new StraightAuto(m_drivetrain);
	private final SpitOut stepTwoLeft = new SpitOut(m_shooter);
	private final BootUpShot stepThreeLeft = new BootUpShot(m_shooter, m_intake);
	private final SpinAngle stepFourLeft = new SpinAngle(m_drivetrain, "left");

	private final StraightAuto stepOneRight = new StraightAuto(m_drivetrain);
	private final SpitOut stepTwoRight = new SpitOut(m_shooter);
	private final BootUpShot stepThreeRight = new BootUpShot(m_shooter, m_intake);
	private final SpinAngle stepFourRight = new SpinAngle(m_drivetrain, "right");

	private final StraightAuto stepOneStraight = new StraightAuto(m_drivetrain);
	private final SpitOut stepTwoStraight = new SpitOut(m_shooter);
	private final BootUpShot stepThreeStraight = new BootUpShot(m_shooter, m_intake);
	private final SpinAngle stepFourStraight = new SpinAngle(m_drivetrain, "straight");

	private final SequentialCommandGroup m_Left = new SequentialCommandGroup(stepOneLeft, stepTwoLeft, stepThreeLeft, stepFourLeft);
	private final SequentialCommandGroup m_Right = new SequentialCommandGroup(stepOneRight, stepTwoRight, stepThreeRight, stepFourRight);
	private final SequentialCommandGroup m_Straight = new SequentialCommandGroup(stepOneStraight, stepTwoStraight, stepThreeStraight, stepFourStraight);

	//-> The container for the robot. Contains subsystems, OI devices, and commands.
	public RobotContainer() {
		m_drivetrain.setDefaultCommand(new Driving(m_drivetrain));
		m_chooser.setDefaultOption("Robot Starts Left", m_Left);
		m_chooser.addOption("Robot Starts Right", m_Right);
		m_chooser.addOption("Robot Starts Straight", m_Straight);

		SmartDashboard.putString("Autonomous Selector:", "");
		SmartDashboard.putNumber("Delay For Auto", 0.0);
		SmartDashboard.putData(m_chooser);
    	configureButtonBindings();
	}

	//-> Method container for mapping button inputs to commands. 
	private void configureButtonBindings() {
    	J12.whileHeld(new ElevatorPower(m_climber, "Elevator Negative"));
		J11.whileHeld(new ElevatorPower(m_climber, "Elevator Positive"));
		
    	J10.whileHeld(new ElevatorPower(m_climber, "Articulate Negative"));
		J9.whileHeld(new ElevatorPower(m_climber, "Articulate Positive"));
		
    	J8.whileHeld(new ElevatorPower(m_climber, "Hook Negative"));
		J7.whileHeld(new ElevatorPower(m_climber, "Hook Positive"));
		
		J5.whileHeld(new IntoIntake(m_intake, "Intake_Backward"));
		J3.whileHeld(new IntoIntake(m_intake, "Intake_Forward"));

		//J2.whileHeld(new VisionProcessing(m_vision));
		J6.whenPressed(new ShooterPower(m_shooter, "Shooter Increment"));

		J4.whenPressed(new ShooterPower(m_shooter, "Shooter Decrement"));
		
		//J1.whileHeld(new ControlShot(m_shooter, "Shooter_Throttle"));
		J1.whileHeld(new PIDControlledShots(m_shooter, m_intake));
		J2.whileHeld(new ControlShot(m_shooter, "Shooter_Backward"));

		X5.whenPressed(new DrivingPower("Negative"));
		X6.whenPressed(new DrivingPower("Positive"));
		
	}

	//-> Passes autonomous command to Robot class. 
	public Command getAutonomousCommand() {
		return m_chooser.getSelected();
	}
}

