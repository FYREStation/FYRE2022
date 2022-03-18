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
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.io.IOException;
import java.nio.file.Path;

// import frc.robot.Constants;
// import frc.robot.commands.*;
import edu.wpi.first.math.MathUtil;


// [ Functions ]
public class PathWeaverTest1 extends CommandBase {
    @SuppressWarnings("unused")
    private final DriveTrain drive_train; 
    String trajectoryJSONOne = "paths/Test1Pt1.wpilib.json";
    Trajectory trajectoryOne = new Trajectory();
    
    //String trajectoryJSONTwo = "..\\..\\..\\..\\..\\..\\PathWeaver\\Paths\\Test1Pt2.wpilib.json";
    //Trajectory trajectoryTwo = new Trajectory();
    
    public PathWeaverTest1(DriveTrain dt) { 
        drive_train = dt; 
        addRequirements(dt);
    }

    @Override
    public void initialize() {
        try {
            Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSONOne);
            trajectoryOne = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
         } catch (IOException ex) {
            DriverStation.reportError("Unable to open trajectory: " + trajectoryJSONOne, ex.getStackTrace());
         }
    }

    @Override   
    public void execute() { 

    }

    @Override
    public boolean isFinished() { 
       return true;
    }

    @Override
    public void end(boolean interrupted) {}

}