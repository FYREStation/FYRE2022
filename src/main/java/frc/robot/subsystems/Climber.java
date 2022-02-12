// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Climber extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  VictorSPX hookMotor = new VictorSPX(Constants.climberMotorThree);
  Spark elevatorMotor = new Spark(Constants.climberMotorFour);
  VictorSPX articulateMotorOne = new VictorSPX(Constants.climberMotorOne);
  VictorSPX articulateMotorTwo = new VictorSPX(Constants.climberMotorTwo);

  double hookPower = 0.0;
  double articulatePower = 0.0;
  double elevatorPower = 0.0;

  public Climber() {
    //TODO actually put values into the reverse motors
    
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
    elevatorMotor.set(elevatorPower);
  }
  public void spinArticulate (){
    articulateMotorOne.set(ControlMode.PercentOutput, articulatePower);
    articulateMotorTwo.set(ControlMode.PercentOutput, articulatePower);
  }
  public void spinHook(){
    hookMotor.set(ControlMode.PercentOutput, hookPower);
  }
  public void stopElevator(){
    elevatorMotor.set(0.0);
  }

  public void stopHook(){
    hookMotor.set(ControlMode.PercentOutput, 0.0);
  }

  public void stopArticulate(){
    articulateMotorOne.set(ControlMode.PercentOutput, 0.0);
    articulateMotorTwo.set(ControlMode.PercentOutput, 0.0);
  }
  

  public void stopEverything(){
    hookPower = 0.0;
    elevatorPower = 0.0;
    articulatePower = 0.0;
    stopElevator();
    stopHook();
    stopArticulate();
  }
}