package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends CommandBase {
    private final DriveTrain drive_train; 

    public Autonomous(DriveTrain dt) { 
        drive_train = dt; 
        addRequirements(dt);
    }

    @Override
    public void initialize() { 
        VisionProcessing.get_vision_vectors();
    }

    @Override   
    public void execute() { 
    //THIS SECTION OF CODE CAN BE MOVED!!
    //Tells the robot to face the targeted ball
    //Note: At this time, I do not fully understand how to make 
    //motors move, and do not want to screw anything up, so I will 
    //leave placeholders for those actions
    VisionProcessing.get_radius();
    if (VisionProcessing.get_center("X") <= 150) {
      SmartDashboard.putNumber("Center X", VisionProcessing.get_center("X"));
      //Code here to make motors spin the robot counterclockwise
    } else if (VisionProcessing.get_center("X") >= 170) {
      SmartDashboard.putNumber("Center X", VisionProcessing.get_center("X"));
      //Code here to make motors spun the robot clockwise
    } else {
      SmartDashboard.putNumber("Center X", 69);
      //Stop spinning, maybe move straight
    }
    }

    @Override
    public boolean isFinished() { 
        return true; 
    }

    @Override
    public void end(boolean interrupted) { 

    }

    public void fake_auto() { 
        int i = 0; 
        while (i < 2000) { 
            drive_train.tankDrive(-0.7, 0.7);
            i += 1; 
        }
        i = 0; 

        System.out.println("ENDED!"); 
        isFinished();
    }
}
