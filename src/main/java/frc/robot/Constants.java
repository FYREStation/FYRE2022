/*
	[ Constants.java ]
    Container for universal variables
    utilized by commands / subsystems alike. 

*/ 

/* -> This Constants class provides a convenient place for commands, subsystems, and other files
to access a set of global variables in order to avoid repetition. All constants should be declared
in a public states. Do not put anything functional in this class. */ 

// [ Package ] 
package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;

// [ Functions ] 
public final class Constants {
	// [ Variables ] 
    public static double throttle = 0.6;

    // [ Intake Ports ] 
    public static int intakeMotor = 2;

    // [ Shooter Ports ] 
    public static int shooterMotor = 5; 
    public static int shooterEncoderA = 0;
    public static int shooterEncoderB = 1;

    // [ Climber Ports ] 
    public static int motorOneArticulate = 1;
    public static int motorTwoArticulate = 2;
    public static int chainMotor = 3;
    public static int motorElevator = 4;


    // [ DriveTrain Ports ]
    public static int leftDriveMotorA = 0; 
    public static int rightDriveMotorA = 1;
    public static boolean invertedDrive = true;
    public static boolean isTank = true;

    // Placeholder ports for drivetrain encoders. 
    public static int driveRightEncoderA = 2;
    public static int driveRightEncoderB = 3;
    public static int driveLeftEncoderA = 4;
    public static int driveLeftEncoderB = 5; 

    // TODO: Add sensors (gyro, encoder, and cameras for example)

    public static UsbCamera camera = CameraServer.startAutomaticCapture();
}
