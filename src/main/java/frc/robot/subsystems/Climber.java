// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

public class Climber extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  VictorSPX hookMotor = new VictorSPX(Constants.climberMotorTwo);
  VictorSPX elevatorMotor = new VictorSPX(Constants.climberMotorThree);
  VictorSPX articulateMotorOne = new VictorSPX(Constants.climberMotorOne);
  VictorSPX articulateMotorTwo = new VictorSPX(Constants.climberMotorFour);

  double hookPower = 0;
  double articulatePower = 0;
  double elevatorPower = 0;

  public Climber() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void setArticulatePower(double power){
    articulatePower = power;
  }

  public void setHookPower(double power){
    hookPower = power;
  }

  public void setElevatorPower(double power){
    elevatorPower = power;
  }
  public void spinElevator(){
    elevatorMotor.set(ControlMode.PercentOutput, 1.0);
  }

  public void stopElevator(){
    elevatorMotor.set(ControlMode.PercentOutput, 0.0);
  }
}
