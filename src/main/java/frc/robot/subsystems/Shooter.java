// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  // Placeholder functions for OneRevolution
  public void spinForward(){
    //TO DO: Add actual motors
  }
  
  public void stopSpin(){
    //TO DO: Add actual motors
  }

  // Storage functions added for ControlStorage
  public void spinStorageForward(){
    //TO DO: Add actual motors
  }

  public void spinStorageBackward(){
    //TO DO: Add actual motors
  }

  // Spin functions added for ControlSpin
  public void shootShot(){
    //TO DO: Add actual motors
  }
}
