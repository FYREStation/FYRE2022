// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Motor Controller Ports
    //Intake Ports
    public static int intakeMotorOne = 3;
    public static int intakeMotorTwo = 1;

    //Shooter Ports
    public static int shooterMotor = 2;
    public static int shooterEncoder = 0;

    //Climber Ports
    public static int climberMotorOne = 5;
    public static int climberMotorTwo = 4;
    public static int climberMotorThree = 0;
    public static int climberMotorFour = 6;

    //DriveTrain Ports
    public static int leftDriveMotorA = 0;
    public static int leftDriveMotorB = 1;
    public static int rightDriveMotorA = 2;
    public static int rightDriveMotorB = 3;
    public static boolean invertedDrive = true;

    //TODO: Add sensors (gyro, encoder, and cameras for example)
}
