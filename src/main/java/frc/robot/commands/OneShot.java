/*
    [ commands / ControlShot.java ]
    Controller of firing balls in 
    pinball shooting mechanism.  

*/ 

// [ Package ]
package frc.robot.commands;

import frc.robot.Constants;
// [ Imports ] 
// // [ Files ] 
import frc.robot.subsystems.*;
// // [ Classes ]
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class OneShot extends CommandBase {
    //-> New variables to set subsystems and counting integers. 
    private final Intake m_intake; 
    private final Shooter m_shot;
    //private final Spark m_gatekeeper = new Spark(Constants.gatekeeperMotor);

    int debounce = 0; 
  
    public OneShot(Shooter s_subsystem, Intake i_subsystem) {
        m_shot = s_subsystem;
        m_intake = i_subsystem; 
    	addRequirements(s_subsystem, i_subsystem);
    }

    @Override
    public void initialize() {}

    //-> Switch statement to decide the direction of the motor.
    @Override
    public void execute() {
        debounce++;

        m_shot.spinBackward();
        if (debounce == 30) {
            m_intake.run_intake_forward();
            //m_gatekeeper.set(0.75);
        }
    }

  	@Override
    //-> Kills spin function.
  	public void end(boolean interrupted) {
        debounce = 0;
    
        m_shot.stopSpin();
        m_intake.stopIntake();
        //m_gatekeeper.set(0.0);
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
