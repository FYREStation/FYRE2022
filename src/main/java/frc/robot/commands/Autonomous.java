package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class Autonomous extends CommandBase {
    private final DriveTrain drive_train; 

    public Autonomous(DriveTrain dt) { 
        drive_train = dt; 
        addRequirements(dt);
    }

    @Override
    public void initialize() { 
 
    }

    @Override   
    public void execute() { 
        //fake_auto();  
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
