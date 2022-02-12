/*
	[ subsystem / Shooter.java ]
	Container for shooter commands
	and utilities.  

*/ 

// [ Package ] 
package frc.robot.subsystems;

// [ Imports ] 
// // [ Files ] 
import frc.robot.Constants;
// // [ Classes ] 
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.cscore.UsbCamera;

// [ Functions ]
public class Shooter extends SubsystemBase {
	//-> Defines shooter motor and shoot encoder for rotation calculation. 
	private Spark motorShoot = new Spark(Constants.shooterMotor);
	private Encoder shooterEncoder = new Encoder(Constants.shooterEncoderA, Constants.shooterEncoderB);

	public Shooter() {
		shooterEncoder.reset();
		shooterEncoder.setDistancePerPulse(2048.0);
	}

	@Override
	//-> Puts encoder distance on the SmartDashboard for testing purpose. 
	public void periodic() {
		SmartDashboard.putNumber("Shooter Encoder", shooterEncoder.getDistance());
	}

	@Override
	public void simulationPeriodic() {}

	//-> Placeholder functions for OneRevolution.java. 
	public void spinForward(){
		motorShoot.set(0.6);
	}

	public void stopSpin(){
		motorShoot.set(0.0);
	}

	//-> Grabs encoder distance for use in commands. 
	public double getDistance(){
		return shooterEncoder.getDistance();
	}
}
