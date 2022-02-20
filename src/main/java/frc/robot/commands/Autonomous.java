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
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.commands.*;

// [ Functions ]
public class Autonomous extends CommandBase {
    @SuppressWarnings("unused")
    private final DriveTrain drive_train; 

    public Autonomous(DriveTrain dt) { 
        drive_train = dt; 
        addRequirements(dt);
    }

    @Override
    public void initialize() {
        auto_distance(1, true);
    }

    @Override   
    public void execute() { 
       
    }

    @Override
    public boolean isFinished() { 
        return false; 
    }

    @Override
    public void end(boolean interrupted) {}

    // Short movement command. Not fully functional. 
    public void auto_distance(double distance, boolean forward) { 
        double position = drive_train.get_encoder_distance("right");
        double destination;

        double speed = 30; 
        double speed_pwm = ((speed * 0.465) + 44.1) / 100;
        
        if (speed_pwm > 0.8 || speed_pwm < 0.5) {
            System.out.println("Speed does not fall in the threshold. Current speed " + speed_pwm + ".");
        } else {
            if (forward) { 
                destination = position + distance;

                while (position < destination) { 
                    System.out.println("Current position " + position);
                    position = drive_train.get_encoder_distance("right");

                    drive_train.tankDrive(speed_pwm + 0.03, speed_pwm);
                }
            } else { 
                destination = position - distance;

                while (position > destination) { 
                    System.out.println("Current position " + position);
                    position = drive_train.get_encoder_distance("right");

                    drive_train.tankDrive(-(speed_pwm + 0.03), -speed_pwm);
                }
            }
        }
    }
}