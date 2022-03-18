/*
    [ commands / Autonomous.java ]
    Storage of autonomous code for 
    Autonomous section of round. 

*/ 

// [ Package ]
package frc.robot.commands.AutoSequence;

// [ Imports ] 
// // [ Files ]
import frc.robot.subsystems.*;
import edu.wpi.first.math.controller.PIDController;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.commands.*;
import edu.wpi.first.math.MathUtil;


// [ Functions ]
public class StraightAuto extends CommandBase {
    @SuppressWarnings("unused")
    private final DriveTrain drive_train; 
    private PIDController PIDLeftController;
    private PIDController PIDRightController;

    public StraightAuto(DriveTrain dt) { 
        drive_train = dt; 
        addRequirements(dt);
    }

    @Override
    public void initialize() {
        drive_train.reset_encoder("left");
        drive_train.reset_encoder("right");

        PIDLeftController = new PIDController(0.055,0.001,0.0);
        PIDLeftController.setSetpoint(-72);
        PIDLeftController.setTolerance(1);

        PIDRightController = new PIDController(0.055,0.001,0.0);
        PIDRightController.setSetpoint(-72);
        PIDRightController.setTolerance(1);
    }

    @Override   
    public void execute() { 

        drive_train.tankDrive(
            MathUtil.clamp(PIDLeftController.calculate(drive_train.get_encoder_distance("left")), -0.75, 0.75),
            -1 * MathUtil.clamp(PIDRightController.calculate(drive_train.get_encoder_distance("right")), -0.75, 0.75)
        );
    }

    @Override
    public boolean isFinished() { 
        if(PIDLeftController.atSetpoint() && PIDRightController.atSetpoint()){
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drive_train.tankDrive(0.0, 0.0);
    }

}