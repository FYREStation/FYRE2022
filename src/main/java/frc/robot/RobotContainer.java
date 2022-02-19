// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.fasterxml.jackson.databind.util.ArrayIterator;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.simulation.JoystickSim;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // Controllers for individual tasks. 
  private final Joystick manipulatorControl = new Joystick(0);
  public static XboxController driverControl = new XboxController(1);

  // Declared four joystick buttons for intake purposes. 
  private final JoystickButton J1 = new JoystickButton(manipulatorControl, 1); // whileHeld: m_intake (spin intake in)
  private final JoystickButton J2 = new JoystickButton(manipulatorControl, 2); // whileHeld: m_intake (spin intake out)
  private final JoystickButton J3 = new JoystickButton(manipulatorControl, 3);  // whileHeld: m_storage (spin storage flywheels in)
  private final JoystickButton J4 = new JoystickButton(manipulatorControl, 4);  // whileHeld: m_storage (spin storage flywheels out)
  private final JoystickButton J5 = new JoystickButton(manipulatorControl, 5);
  private final JoystickButton J6 = new JoystickButton(manipulatorControl, 6);
  private final JoystickButton J7 = new JoystickButton(manipulatorControl, 7);
  private final JoystickButton J8 = new JoystickButton(manipulatorControl, 8);
  private final JoystickButton J9 = new JoystickButton(manipulatorControl, 9);
  private final JoystickButton J10 = new JoystickButton(manipulatorControl, 10);
  private final JoystickButton J11 = new JoystickButton(manipulatorControl, 11);
  private final JoystickButton J12 = new JoystickButton(manipulatorControl, 12);
  // Moving axis for intake and outake control (will be utilized for intake spinning!)
  // private final double intakeAxis = manipulatorControl.getRawAxis(3);

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final Intake m_intake = new Intake();
  private final Vision m_vision = new Vision();
  private final Shooter m_shooter = new Shooter();
  private final Climber m_climber = new Climber();
  private static DriveTrain m_drivetrain = new DriveTrain();
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  private final Autonomous m_autoCommand = new Autonomous(m_drivetrain);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new Driving(m_drivetrain));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    J12.whileHeld(new ElevatorPower(m_climber, "Elevator Positive"));
    J11.whileHeld(new ElevatorPower(m_climber, "Elevator Negative"));
    J10.whileHeld(new ElevatorPower(m_climber, "Articulate Positive"));
    J9.whileHeld(new ElevatorPower(m_climber, "Articulate Negative"));
    J8.whileHeld(new ElevatorPower(m_climber, "Hook Positive"));
    J7.whileHeld(new ElevatorPower(m_climber, "Hook Negative"));
    J1.whenPressed(new ControlShot(m_shooter));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    new VisionProcessing(m_vision);
    return m_autoCommand;
  }
}
