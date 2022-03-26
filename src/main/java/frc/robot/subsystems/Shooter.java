// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private TalonSRX motorShoot = new TalonSRX(Constants.shooterMotor);
  private Encoder shooterEncoder = new Encoder(Constants.shooterEncoderA, Constants.shooterEncoderB);
  private double throttle = 0.8;
  private boolean upToSpeed = false;

  public Shooter() {

    motorShoot.setInverted(true);

    shooterEncoder.reset();
    shooterEncoder.setDistancePerPulse(1/2048.0);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Encoder", shooterEncoder.getDistance());
    SmartDashboard.putNumber("Shooter Speed", shooterEncoder.getRate());
    SmartDashboard.putNumber("Shooter Throttle", throttle);
    SmartDashboard.putNumber("Shooter Percentage", throttle);
    upToSpeed=false;

    switch(fixerTo5(throttle)){
      case 60:
        if(shooterEncoder.getRate() > 78){
          upToSpeed = true;
        }

      case 65:
        if(shooterEncoder.getRate() > 88){
          upToSpeed = true;
        }
      
      case 70:
        if(shooterEncoder.getRate() > 97){
          upToSpeed = true;
        }
      case 75:
        if(shooterEncoder.getRate() > 106){
          upToSpeed = true;
        }
      case 80:
        if(shooterEncoder.getRate() > 118){
          upToSpeed = true;
        }
      case 85:
        if(shooterEncoder.getRate() > 122){
          upToSpeed = true;
        }
      case 90:
        if(shooterEncoder.getRate() > 129){
          upToSpeed = true;
        }
      case 95:
        if(shooterEncoder.getRate() > 137){
          upToSpeed = true;
        }
      case 100:
        if(shooterEncoder.getRate() > 145){
          upToSpeed = true;
        }

        
    }
    SmartDashboard.putBoolean("Ready to Shoot", upToSpeed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public double getRPMRate(){
    return shooterEncoder.getRate();
  }

  // Placeholder functions for OneRevolution
  public void spinForward(){
    motorShoot.set(ControlMode.PercentOutput, 0.90);
  }
  
  public void spinBackward(){
    motorShoot.set(ControlMode.PercentOutput, -0.90);
  }

  public void stopSpin(){
    motorShoot.set(ControlMode.PercentOutput, 0.0);
  }

  public void spinThrottle(){
    motorShoot.set(ControlMode.PercentOutput, throttle);
  }

  public void setThrottle(double newThrottle){
    if(newThrottle >= -1.0 && newThrottle <=1.05){
      throttle = newThrottle;
    }
  }
  public double getThrottle(){
    return throttle;
  }

  public void spinAmount(double power){
    motorShoot.set(ControlMode.PercentOutput, power);
  }

  public double getDistance(){
    return shooterEncoder.getDistance();
  }


public int fixerTo5(double number){
  double fixed = number * 100;
  if((int)fixed % 5 ==0){
    return (int)fixed;
  }
  else{
    return (int)(fixed+1);
  }
}
}
