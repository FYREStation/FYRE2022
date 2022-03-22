/*
	[ Climber.java ]
	Container for universal variables
	utilized by commands / subsystems alike. 

*/ 

// [ Package ] 
package frc.robot.subsystems;

// [ Imports ] 
// // [ Files ] 
import frc.robot.Constants;
// // [ Classes ] 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.hal.DigitalGlitchFilterJNI;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
/* import com.fasterxml.jackson.annotation.JsonCreator.Mode;
   import com.revrobotics.CANSparkMaxLowLevel.MotorType; */
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

// [ Functions ]
public class Climber extends SubsystemBase {
	//-> Defines a series of motors used in climber mechanism. 
	VictorSPX hookMotor = new VictorSPX(Constants.chainMotor);
	TalonSRX elevatorMotor = new TalonSRX(Constants.motorElevator);
	CANSparkMax articulateMotorOne = new CANSparkMax(Constants.motorOneArticulate, MotorType.kBrushed);
	CANSparkMax articulateMotorTwo = new CANSparkMax(Constants.motorTwoArticulate, MotorType.kBrushed);
	DigitalInput elevatorLimitSwitch = new DigitalInput(Constants.climberLimit);

	//-> Power variables. 
	double hookPower, articulatePower, elevatorPower = 0;

	public Climber() {
		// TODO: make sure to set reverse motors
	}

	@Override
	public void periodic() {}

	@Override
	public void simulationPeriodic() {}

	//-> Sets motor power to passed-in parameter. 
	public void setArticulatePower(double power){
		articulatePower = power;
	}

	public void setHookPower(double power){
		hookPower = power;
	}

	public void setElevatorPower(double power){
		elevatorPower = power;
	}

	//-> Rotates motors by their designated power variables. 
	public void spinElevator(){
		elevatorMotor.set(ControlMode.PercentOutput, elevatorPower);
	}

	public void spinArticulate (){
		articulateMotorOne.set(articulatePower);
		articulateMotorTwo.set(articulatePower);
	}

	public boolean getElevatorLimit(){
		return elevatorLimitSwitch.get();
	}

	public void spinHook(){
		hookMotor.set(ControlMode.PercentOutput, hookPower);
	}

	//-> Pauses all motors. 
	public void stopElevator(){
		elevatorMotor.set(ControlMode.PercentOutput, 0.0);
	}

	public void stopHook(){
		hookMotor.set(ControlMode.PercentOutput, 0.0);
	}

	public void stopArticulate(){
		articulateMotorOne.set(0.0);
		articulateMotorTwo.set(0.0);
	}

	//-> Kill switch for all motors + variables. 
	public void stopEverything(){
		hookPower = 0.0;
		elevatorPower = 0.0;
		articulatePower = 0.0;
		
		stopElevator();
		stopHook();
		stopArticulate();
	}
}