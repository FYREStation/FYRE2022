// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ElevatorPower extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Climber m_Climber;
  String sectionPower;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ElevatorPower(Climber subsystem,String section) {
    m_Climber = subsystem;
    sectionPower = section;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (sectionPower) {
      case "Hook Positive":
        m_Climber.setHookPower(0.6);
        m_Climber.spinHook();
        break;
      case "Hook Negative":
        m_Climber.setHookPower(-0.6);
        m_Climber.spinHook();
        break;
      case "Articulate Positive":
        m_Climber.setArticulatePower(0.6);
        m_Climber.spinArticulate();
        break;
     
      case "Articulate Negative":
        m_Climber.setArticulatePower(0.6);
        m_Climber.spinArticulate();
        break;
      case "Elevator Positive":
        m_Climber.setElevatorPower(0.6);
        m_Climber.spinElevator();
        break;
      case "Elevator Negative":
        m_Climber.setElevatorPower(-0.6);
        m_Climber.spinArticulate();
        break;
      default:
        m_Climber.stopEverything();
        break;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Climber.stopEverything();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
