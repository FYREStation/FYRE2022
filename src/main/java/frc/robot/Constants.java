// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static double throttle = 0.6;
    //Motor Controller Ports
    //Intake Ports
    public static int intakeMotorOne = 3;
    public static int intakeMotorTwo = 1; // was 1 

    //Shooter Ports
    public static int shooterMotor = 0; 
    public static int shooterEncoderA = 0;
    public static int shooterEncoderB = 1;

    //Climber Ports
    public static int climberMotorOne = 5;
    public static int climberMotorTwo = 4;
    public static int climberMotorThree = 8; // was 0 
    public static int climberMotorFour = 6;

    //DriveTrain Ports
    public static int leftDriveMotorA = 1; 
    //public static int leftDriveMotorB = 3;
    public static int rightDriveMotorA = 2;
    //public static int rightDriveMotorB = 4;
    public static boolean invertedDrive = true;
    public static boolean isTank = true;

    //TODO: Add sensors (gyro, encoder, and cameras for example)

    public static UsbCamera camera = CameraServer.startAutomaticCapture();
}
