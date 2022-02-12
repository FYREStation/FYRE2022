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
    private final DriveTrain drive_train; 

    public Autonomous(DriveTrain dt) { 
        drive_train = dt; 
        addRequirements(dt);
    }

    @Override
    public void initialize() {}

    @Override   
    public void execute() { 
        fake_auto();  
    }

    @Override
    public boolean isFinished() { 
        return false; 
    }

    @Override
    public void end(boolean interrupted) {}

    // Short movement command. Not fully functional. 
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