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
  private double throttle = 0.0;
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
    SmartDashboard.putNumber("Shooter Throttle", RobotContainer.manipulatorControl.getRawAxis(3) * -1);
    SmartDashboard.putNumber("Shooter Percentage", RobotContainer.manipulatorControl.getRawAxis(3) * -1);

    switch((int)(throttle*100)){
      case 60:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }
      case 65:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }
      
      case 70:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }
      case 75:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }
      case 80:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }
      case 85:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }
      case 90:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }
      case 95:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }
      case 100:
        if(shooterEncoder.getRate() > 9){
          upToSpeed = true;
        }else{
          upToSpeed = false;
        }

        
    }
    SmartDashboard.putBoolean("Ready to Shoot", upToSpeed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
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
    //throttle = RobotContainer.manipulatorControl.getRawAxis(3) * -1;
    motorShoot.set(ControlMode.PercentOutput, throttle);
  }

  public void setThrottle(double newThrottle){
    if(newThrottle >= 0.0 && newThrottle <=1.0)
      throttle = newThrottle;
  }
public double getThrottle(){
  return throttle;
}
  public void spinAmount(double power){
    throttle = power;
    motorShoot.set(ControlMode.PercentOutput, power);
  }

  public double getDistance(){
    return shooterEncoder.getDistance();
  }
}
