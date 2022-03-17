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

public class Shooter extends SubsystemBase {
	//-> Creates motor + encoder for shooting and counting shooter revolutions. 
	private TalonSRX motorShooter = new TalonSRX(Constants.shooterMotor);
	private Encoder shooterEncoder = new Encoder(Constants.shooterEncoderA, Constants.shooterEncoderB);
  
  	public Shooter() {
    	shooterEncoder.reset();
    	shooterEncoder.setDistancePerPulse(2048.0);
  	}

  	@Override
  	public void periodic() {
    	SmartDashboard.putNumber("Shooter Encoder", shooterEncoder.getDistance());
  	}

  	//-> Placeholder functions for OneRevolution
 	public void spinForward(){
    	motorShooter.set(ControlMode.PercentOutput, -0.8);
  	}

  	public void spinBackward(){
    	motorShooter.set(ControlMode.PercentOutput, 0.8);
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
