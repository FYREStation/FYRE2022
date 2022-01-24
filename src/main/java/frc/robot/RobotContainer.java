// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.simulation.JoystickSim;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.commands.ControlIntake;
import frc.robot.subsystems.Intake;

import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
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
  private final XboxController driverControl = new XboxController(1);

  // Declared four joystick buttons for intake purposes. 
  private final JoystickButton J1 = new JoystickButton(manipulatorControl, 11); // whileHeld: m_intake (spin intake in)
  private final JoystickButton J2 = new JoystickButton(manipulatorControl, 12); // whileHeld: m_intake (spin intake out)
  private final JoystickButton J3 = new JoystickButton(manipulatorControl, 5);  
  private final JoystickButton J4 = new JoystickButton(manipulatorControl, 3);  

  // Moving axis for intake and outake control (will be utilized for intake spinning!)
  private final double intakeAxis = manipulatorControl.getRawAxis(3);

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final Intake m_intake = new Intake();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    J1.whileHeld(new ControlIntake(m_intake));
    J2.whileHeld(new ControlIntake(m_intake));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
