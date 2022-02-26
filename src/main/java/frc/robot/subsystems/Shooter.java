// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private TalonSRX motorShoot = new TalonSRX(Constants.shooterMotor);
  private Encoder shooterEncoder = new Encoder(Constants.shooterEncoderA, Constants.shooterEncoderB);
  
  public Shooter() {
    shooterEncoder.reset();
    shooterEncoder.setDistancePerPulse(2048.0);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Encoder", shooterEncoder.getDistance());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  // Placeholder functions for OneRevolution
  public void spinForward(){
    motorShoot.set(ControlMode.PercentOutput, 1.0);
  }

  public void spinBackward(){
    motorShoot.set(ControlMode.PercentOutput, -1.0);
  }
  
  public void stopSpin(){
    motorShoot.set(ControlMode.PercentOutput, 0.0);
  }

  public double getDistance(){
    return shooterEncoder.getDistance();
  }
}
