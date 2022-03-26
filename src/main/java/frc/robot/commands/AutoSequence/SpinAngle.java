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
public class SpinAngle extends CommandBase {
    @SuppressWarnings("unused")
    private final DriveTrain drive_train; 
    private PIDController PIDAngleController;
    private String direction;

    public SpinAngle(DriveTrain dt, String direct) { 
        drive_train = dt; 
        direction = direct;
        addRequirements(dt);
    }

    @Override
    public void initialize() {
        drive_train.resetGyro();

        PIDAngleController = new PIDController(0.10,0.001,0.0);
        if(direction.equals("left")){        
            PIDAngleController.setSetpoint(-30);
        }else if (direction.equals("right")){
            PIDAngleController.setSetpoint(30);
        }else{
            PIDAngleController.setSetpoint(0);
        }
        
        PIDAngleController.setTolerance(5);
    }

    @Override   
    public void execute() { 

        drive_train.tankDrive(
            MathUtil.clamp(PIDAngleController.calculate(drive_train.getGyro()), -0.75, 0.75),
            MathUtil.clamp(PIDAngleController.calculate(drive_train.getGyro()), -0.75, 0.75)
        );
    }

    @Override
    public boolean isFinished() { 
        if(PIDAngleController.atSetpoint()){
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drive_train.tankDrive(0.0, 0.0);
    }

}