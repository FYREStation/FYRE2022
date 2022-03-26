/*
    [ commands / ControlShot.java ]
    Controller of firing balls in 
    pinball shooting mechanism.  

*/ 

// [ Package ]
package frc.robot.commands;

import frc.robot.subsystems.Intake;
// [ Imports ] 
// // [ Files ] 
import frc.robot.subsystems.Shooter;
import frc.robot.Robot;
// // [ Classes ]
import frc.robot.RobotContainer;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class PIDControlledShots extends CommandBase {
    private final Shooter m_shot;
    private final Intake m_intake;
    private double goalSpeed;
    private PIDController RPMController;
  
    public PIDControlledShots(Shooter subsystem, Intake intakeSub) {
    	m_shot = subsystem;
        m_intake = intakeSub;
    	addRequirements(subsystem, intakeSub);
    }

    @Override
    public void initialize() {
        goalSpeed = convertToRPM(m_shot.getThrottle());
        RPMController = new PIDController(0.2, 0.001, 0.02);
        RPMController.setSetpoint(goalSpeed);
        RPMController.setTolerance(2.0);
    }

    //-> Switch statement to decide the direction of the motor.
    @Override
    public void execute() {
        m_shot.spinAmount(RPMController.calculate(m_shot.getRPMRate()));
        if(RPMController.atSetpoint()){
            m_intake.run_intake_backward();
        }
    }

  	@Override
    //-> Kills spin function.
  	public void end(boolean interrupted) {
    	m_shot.stopSpin();
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}

    public double convertToRPM(double throttleNum){
        return(throttleNum * 165.0)-18.7;
    }
}
