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
	private final Spark left_motorA = new Spark(Constants.leftDriveMotorA);
	private final Spark right_motorA = new Spark(Constants.rightDriveMotorA);

	//-> Places these motors into individual MotorControllerGroups, then into DifferentialDrive. 
	private final MotorControllerGroup left_motors = new MotorControllerGroup(left_motorA);
	private final MotorControllerGroup right_motors = new MotorControllerGroup(right_motorA);
	private final DifferentialDrive differential_drive = new DifferentialDrive(left_motors, right_motors);

	private static int expiration_dur = 99999; //-> Edit expiration time. 
	private static boolean safety_toggle = false; //-> Edit safety toggle. 

	//-> Creates new encoder variables to be used in Autonomous. 
	private final Encoder left_encoder = new Encoder(Constants.driveLeftEncoderA, Constants.driveLeftEncoderB, true, Encoder.EncodingType.k4X);
	private final Encoder right_encoder = new Encoder(Constants.driveRightEncoderA, Constants.driveRightEncoderB, true, Encoder.EncodingType.k4X);

	//-> Sets a series of constants on motors. 
	public DriveTrain (){
		left_motorA.setExpiration(expiration_dur);
		right_motorA.setExpiration(expiration_dur);
		differential_drive.setExpiration(expiration_dur);

		left_motorA.setSafetyEnabled(safety_toggle);
		right_motorA.setSafetyEnabled(safety_toggle);
		differential_drive.setSafetyEnabled(safety_toggle);
    }

	//-> Two drive functions for arcade drive method and tank drive method. 
	public void arcadeDrive (double move_speed, double rot_speed){
		if (Constants.invertedDrive) {
			differential_drive.arcadeDrive(move_speed, rot_speed);
		} else {
			differential_drive.arcadeDrive(-move_speed, rot_speed);
		}
	}

	public void tankDrive (double move_speed_l, double move_speed_r) {
		if (Constants.invertedDrive) {            
			differential_drive.tankDrive(move_speed_l, move_speed_r);
		} else {
			differential_drive.tankDrive(-move_speed_l, -move_speed_r);
		}    
	}

	//-> Methods to get different functions out of encoders.
	public double get_encoder(String side) {
		if (side == "left") { 
			return this.left_encoder.get(); 
		} else if (side == "right") { 
			return this.right_encoder.get(); 
		}

		return 0.0; 
	}

	public void reset_encoder(String side) {
		if (side == "left") {
			left_encoder.reset(); 
		} else if (side == "right") {
			right_encoder.reset(); 
		} else if (side == "both") { 
			left_encoder.reset(); 
			right_encoder.reset(); 
		}
	}

	public double get_encoder_distance(String side) {
		if (side == "left") { 
			return left_encoder.getDistance(); 
		} else if (side == "right") {
			return right_encoder.getDistance(); 
		}

		return 0.0; 
	}

	@Override
	public void periodic() {}

	@Override
	public void simulationPeriodic() {}
}