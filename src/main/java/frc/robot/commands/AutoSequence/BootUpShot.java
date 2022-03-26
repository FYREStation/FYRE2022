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
import edu.wpi.first.wpilibj.DriverStation;

// [ Functions ]
public class BootUpShot extends CommandBase {
    @SuppressWarnings("unused")
    private final Shooter m_shot;
    private final Intake m_intake;
    private double startTime;

    public BootUpShot(Shooter shooter, Intake intake) { 
        m_shot = shooter;
        m_intake = intake; 
        addRequirements(shooter, intake);
    }

    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        m_shot.spinAmount(0.75);
    }

    @Override 
    public void execute() { 
        if(System.currentTimeMillis() - startTime > 3000){
            m_intake.run_intake_backward();
        }
    }

    @Override
    public boolean isFinished() { 
        if(System.currentTimeMillis() - startTime > 4000){
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_shot.stopSpin();
        m_intake.stopIntake();
    }

}