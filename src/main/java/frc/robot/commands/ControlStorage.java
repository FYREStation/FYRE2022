/*
    [ commands / ControlStorage.java ]
    Controller of balls in internal shaft
    between intake and shooter. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ]
// // [ Files ] 
import frc.robot.subsystems.Shooter;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class ControlStorage extends CommandBase {
	@SuppressWarnings("unused")
	private final Shooter m_storage;
  
	public ControlStorage(Shooter subsystem) {
		m_storage = subsystem;
    	addRequirements(subsystem);
  	}

  	@Override
  	public void initialize() {}

  	@Override
  	public void execute() {}

  	@Override
  	public void end(boolean interrupted) {}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
