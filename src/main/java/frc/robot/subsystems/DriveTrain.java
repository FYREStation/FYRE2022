/*
   [ DriveTrain.java ]
*/

// Grab package for frc.robot
package frc.robot.subsystems;

// Imports a series of basic APIs
import frc.robot.Constants; // Constants folder for motor variables

//import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive; 
// import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup; // Motor control folder (MotorController + MotorControllerGroup)
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import edu.wpi.first.wpilibj2.command.SubsystemBase; // Subsystem framework

/* FYI, I went off of the 2021 DriveTrain system and updated it / removed
depricated API. Just letting you know. */

public class DriveTrain extends SubsystemBase {

    /* leftDriveMotors + rightDriveMotors are empty variables in Constants. Once we can start
    messing with actual motors, PLEASE update them / this code!! */
    private final Spark left_motorA = new Spark(Constants.leftDriveMotorA);
    //private final Spark left_motorB = new Spark(Constants.leftDriveMotorB);

    private final Spark right_motorA = new Spark(Constants.rightDriveMotorA);
    //private final Spark right_motorB = new Spark(Constants.rightDriveMotorB);

    private final MotorControllerGroup left_motors = new MotorControllerGroup(left_motorA);
    private final MotorControllerGroup right_motors = new MotorControllerGroup(right_motorA);

    private final DifferentialDrive differential_drive = new DifferentialDrive(left_motors, right_motors);

    // /* Set a series of variables. For more information on what they do, check out this link: 
    // https://first.wpi.edu/wpilib/allwpilib/docs/release/java/edu/wpi/first/wpilibj/MotorSafety.html#setExpiration(double) */

    private static int expiration_dur = 99999; // Change this variable to affect expiration time. 
    private static boolean safety_toggle = false; // Change this variable to toggle safety mode. 
    
    public DriveTrain (){
         // Not fully sure if we need these. Kept them anyway.
        
             left_motorA.setExpiration(expiration_dur);
             right_motorA.setExpiration(expiration_dur);

             left_motorA.setSafetyEnabled(safety_toggle);
             right_motorA.setSafetyEnabled(safety_toggle);
         

         differential_drive.setExpiration(expiration_dur);
         differential_drive.setSafetyEnabled(safety_toggle);
    }

    /* Once you guys figure out your encoders, please add them here! :) I am going to 
    need them for the arcadeDrive subsystem. */

    // Two drive functions for arcade drive method and tank drive method. 
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

    // Periodic commands. 
    @Override
    public void periodic() {
        
    }

    @Override
    public void simulationPeriodic() {
    
    }
}
