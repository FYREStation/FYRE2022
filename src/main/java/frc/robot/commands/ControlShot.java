/*
    [ commands / ControlShot.java ]
    Controller of firing balls in 
    pinball shooting mechanism.  

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ] 
import frc.robot.subsystems.Shooter;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class ControlShot extends CommandBase {
    private final Shooter m_shot;
  
    public ControlShot(Shooter subsystem) {
    	m_shot = subsystem;
    	addRequirements(subsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
    	m_shot.spinForward();
    }

  	@Override
  	public void end(boolean interrupted) {
    	m_shot.stopSpin();
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
