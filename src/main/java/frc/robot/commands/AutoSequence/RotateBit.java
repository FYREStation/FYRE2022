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
public class RotateBit extends CommandBase {
    @SuppressWarnings("unused")
    private final DriveTrain m_driveTrain; 
    private double startTime;
    private PIDController rotatePID;
    private double startAngle;

    public RotateBit(DriveTrain drive) { 
        m_driveTrain = drive; 
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        rotatePID = new PIDController(0.05,0,0);
        rotatePID.setTolerance(3);
        startAngle = m_driveTrain.getGyro();
        rotatePID.setSetpoint(startAngle + 20);
    }

    @Override   
    public void execute() { 
        m_driveTrain.tankDrive(
            MathUtil.clamp(rotatePID.calculate(m_driveTrain.getGyro() - startAngle), -0.75, 0.75),
            MathUtil.clamp(rotatePID.calculate(m_driveTrain.getGyro() - startAngle), -0.75, 0.75)
        );
    }

    @Override
    public boolean isFinished() { 
        if(rotatePID.atSetpoint()){
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_driveTrain.tankDrive(0,0);
    }

}