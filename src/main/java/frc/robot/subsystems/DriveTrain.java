/*
	[ subsystems / DriveTrain.java ]
	Container for all driving commands 
	and utilities. 

*/ 

// [ Package ]
package frc.robot.subsystems;

// [ Imports ] 
// // [ Files ] 
import frc.robot.Constants;
// // [ Classes ] 
import edu.wpi.first.wpilibj.drive.DifferentialDrive; 
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;

// [ Functions ] 
public class DriveTrain extends SubsystemBase {

	//-> Grabs motors from roboRIO ports using Constant values. 
	private final Spark leftMotorA = new Spark(Constants.leftDriveMotorA);
	private final Spark rightMotorA = new Spark(Constants.rightDriveMotorA);

	//-> Places these motors into individual MotorControllerGroups, then into DifferentialDrive. 
	private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftMotorA);
	private final MotorControllerGroup rightMotors = new MotorControllerGroup(rightMotorA);
	private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

	private static int expirationDur = 99999; //-> Edit expiration time. 
	private static boolean safetyToggle = false; //-> Edit safety toggle. 

	//-> Creates new encoder variables to be used in Autonomous. 
	private final Encoder leftEncoder = new Encoder(Constants.driveLeftEncoderA, Constants.driveLeftEncoderB, true, Encoder.EncodingType.k4X);
	private final Encoder rightEncoder = new Encoder(Constants.driveRightEncoderA, Constants.driveRightEncoderB, true, Encoder.EncodingType.k4X);

	//-> Sets a series of constants on motors. 
	public DriveTrain() {
		leftMotorA.setExpiration(expirationDur);
		rightMotorA.setExpiration(expirationDur);
		differentialDrive.setExpiration(expirationDur);

		leftMotorA.setSafetyEnabled(safetyToggle);
		rightMotorA.setSafetyEnabled(safetyToggle);
		differentialDrive.setSafetyEnabled(safetyToggle);
    }

	//-> Two drive functions for arcade drive method and tank drive method. 
	public void arcadeDrive (double moveSpeed, double rotSpeed){
		if (Constants.invertedDrive) {
			differentialDrive.arcadeDrive(moveSpeed, rotSpeed);
		} else {
			differentialDrive.arcadeDrive(-moveSpeed, rotSpeed);
		}
	}

	public void tankDrive (double moveSpeedL, double moveSpeedR) {
		if (Constants.invertedDrive) {            
			differentialDrive.tankDrive(moveSpeedL, moveSpeedR);
		} else {
			differentialDrive.tankDrive(-moveSpeedL, -moveSpeedR);
		}    
	}

	//-> Methods to get different functions out of encoders.
	public double getEncoder(String side) {
		if (side == "left") { 
			return this.leftEncoder.get(); 
		} else if (side == "right") { 
			return this.rightEncoder.get(); 
		}

		return 0.0; 
	}

	public void resetEncoder(String side) {
		if (side == "left") {
			leftEncoder.reset(); 
		} else if (side == "right") {
			rightEncoder.reset(); 
		} else if (side == "both") { 
			leftEncoder.reset(); 
			rightEncoder.reset(); 
		}
	}

	public double getEncoderDistance(String side) {
		if (side == "left") { 
			return leftEncoder.getDistance(); 
		} else if (side == "right") {
			return rightEncoder.getDistance(); 
		}

		return 0.0; 
	}

	@Override
	public void periodic() {}

	@Override
	public void simulationPeriodic() {}
}