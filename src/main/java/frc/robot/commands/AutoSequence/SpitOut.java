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
public class SpitOut extends CommandBase {
    @SuppressWarnings("unused")
    private final Shooter m_shot; 
    private double startTime;

    public SpitOut(Shooter shooter) { 
        m_shot = shooter; 
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();

    }

    @Override   
    public void execute() { 
        m_shot.spinAmount(-0.20);
    }

    @Override
    public boolean isFinished() { 
        if(System.currentTimeMillis() - startTime > 500){
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_shot.stopSpin();
    }

}