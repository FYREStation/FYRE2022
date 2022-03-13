/*
    [ commands / Autonomous.java ]
    Storage of autonomous code for 
    Autonomous section of round. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ]
import frc.robot.subsystems.*;
// import frc.robot.commands.*;
import edu.wpi.first.math.controller.PIDController;
// import frc.robot.Constants;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.math.MathUtil;

// [ Functions ]
public class Autonomous extends CommandBase {
    private final DriveTrain mDriveTrain; 
    private PIDController PIDAutoController;

    public Autonomous(DriveTrain subsystem) { 
        mDriveTrain = subsystem; 
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        //DriveTrain.resetGyro();

        PIDAutoController = new PIDController(0.0035,0.0005,0.0001);
        PIDAutoController.setSetpoint(180);
        PIDAutoController.setTolerance(1);
    }

    @Override   
    public void execute() { 
        //DriveTrain.tankDrive(MathUtil.clamp(PIDAutoController.calculate(DriveTrain.getGyro()), -0.85, 0.85), MathUtil.clamp(PIDAutoController.calculate(DriveTrain.getGyro()), -0.85, 0.85));
    }

    @Override
    public boolean isFinished() { 
        /*
        if (PIDAutoController.atSetpoint()) {
            System.out.println("REACHED SETPOINT!!!");
            return true;   
        }
        return false;
        */

        return false;
    }

    @Override
    public void end(boolean interrupted) {}

    // Short movement command. Not fully functional. 
    public void autoDistance(double distance, boolean forward) { 
        double position = mDriveTrain.getEncoderDistance("right");
        double destination;

        double speed = 30; 
        double speedPWM = ((speed * 0.465) + 44.1) / 100;
        
        if (speedPWM > 0.8 || speedPWM < 0.5) {
            System.out.println("Speed does not fall in the threshold. Current speed " + speedPWM + ".");
        } else {
            if (forward) { 
                destination = position + distance;

                while (position < destination) { 
                    System.out.println("Current position " + position);
                    position = mDriveTrain.getEncoderDistance("right");

                    mDriveTrain.tankDrive(speedPWM + 0.03, speedPWM);
                }
            } else { 
                destination = position - distance;

                while (position > destination) { 
                    System.out.println("Current position " + position);
                    position = mDriveTrain.getEncoderDistance("right");

                    mDriveTrain.tankDrive(-(speedPWM + 0.03), -speedPWM);
                }
            }
        }
    }
} 