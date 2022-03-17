/*
	[ subsystems / Shooter.java ]
	Container for all shooter commands 
	and utilities. 

*/ 

// [ Package ] 
package frc.robot.subsystems;

// [ Imports ] 
// // [ Files ] 
import frc.robot.Constants;
// // [ Classes ] 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Shooter extends SubsystemBase {
	//-> Creates motor + encoder for shooting and counting shooter revolutions. 
	private TalonSRX motorShooter = new TalonSRX(Constants.shooterMotor);
	private Encoder shooterEncoder = new Encoder(Constants.shooterEncoderA, Constants.shooterEncoderB);
	private static double throttle_power;
    private static double shooter_power;
  	public Shooter() {
    	shooterEncoder.reset();
    	shooterEncoder.setDistancePerPulse(2048.0);
  	}

  	@Override
  	public void periodic() {
    	SmartDashboard.putNumber("Shooter Encoder", shooterEncoder.getDistance());
		throttle_power =  RobotContainer.manipulatorControl.getRawAxis(3) * 2;
		if (throttle_power <= 1) {
			shooter_power = throttle_power - 1;
		} else if (throttle_power > 1) {
			shooter_power = (throttle_power - 1) * -1;
		}
  	}

  	//-> Placeholder functions for OneRevolution
 	public void spinForward(){
    	motorShooter.set(ControlMode.PercentOutput, -0.8);
  	}

  	public void spinBackward(){
    	motorShooter.set(ControlMode.PercentOutput, 0.8);
  	}
  
	public void spin_with_throttle(){
		motorShooter.set(ControlMode.PercentOutput, shooter_power);
	}
	
  	public void stopSpin(){
    	motorShooter.set(ControlMode.PercentOutput, 0.0);
  	}

 	 public double getDistance(){
    	return shooterEncoder.getDistance();
  	}

  	@Override
  	public void simulationPeriodic() {}
}
