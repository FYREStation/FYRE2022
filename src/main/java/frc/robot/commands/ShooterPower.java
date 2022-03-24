/*
	[ commands / ElevatorPower.java ]
	Established framework for 
	driving system of the robot. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ]
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Shooter;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class ShooterPower extends CommandBase {
  	private final Shooter m_shooter;
	String sectionPower;
	  
	public ShooterPower(Shooter subsystem, String section) {
		m_shooter = subsystem;
		sectionPower = section;
		addRequirements(subsystem);
	}

	@Override
	public void initialize() {
		switch (sectionPower) {
			case "Shooter Increment":
				m_shooter.setThrottle(m_shooter.getThrottle()+0.05);
				break;
			case "Shooter Decrement":
				m_shooter.setThrottle(m_shooter.getThrottle()-0.05);
				break;
			default:
				break;
		}
	}

	//-> Switch statement for selecting power and functions for Climber command. 
	@Override
	public void execute() {
		
	}

	@Override
	//-> Kills elevator when this command is cancelled. 
	public void end(boolean interrupted) {
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
