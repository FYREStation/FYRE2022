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
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class ElevatorPower extends CommandBase {
  	private final Climber m_climber;
	String sectionPower;
	  
	public ElevatorPower(Climber subsystem, String section) {
		m_climber = subsystem;
		sectionPower = section;
		addRequirements(subsystem);
	}

	@Override
	public void initialize() {}

	//-> Switch statement for selecting power and functions for Climber command. 
	@Override
	public void execute() {
		switch (sectionPower) {
			case "Hook Positive":
				m_climber.setHookPower(0.6);
				m_climber.spinHook();
				break;
			case "Hook Negative":
				m_climber.setHookPower(-0.6);
				m_climber.spinHook();
				break;
			case "Articulate Positive":
				m_climber.setArticulatePower(0.4);
				m_climber.spinArticulate();
				break;
			case "Articulate Negative":
				m_climber.setArticulatePower(-0.4);
				m_climber.spinArticulate();
				break;
			case "Elevator Positive":
				if(!m_climber.getElevatorLimit()){
					m_climber.setElevatorPower(-0.4);
					m_climber.spinElevator();
				}
				break;
			case "Elevator Negative":
				m_climber.setElevatorPower(0.4);
				m_climber.spinElevator();
				break;
			default:
				m_climber.stopEverything();
				break;
		}
	}

	@Override
	//-> Kills elevator when this command is cancelled. 
	public void end(boolean interrupted) {
		m_climber.stopEverything();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
