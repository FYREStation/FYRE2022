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
  	private final Climber m_Climber;
	String sectionPower;
	  
	public ElevatorPower(Climber subsystem,String section) {
		m_Climber = subsystem;
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
				m_Climber.setHookPower(0.4);
				m_Climber.spinHook();
				break;
			case "Hook Negative":
				m_Climber.setHookPower(-0.4);
				m_Climber.spinHook();
				break;
			case "Articulate Positive":
				m_Climber.setArticulatePower(0.4);
				m_Climber.spinArticulate();
				break;
			case "Articulate Negative":
				m_Climber.setArticulatePower(-0.4);
				m_Climber.spinArticulate();
				break;
			case "Elevator Positive":
				m_Climber.setElevatorPower(0.4);
				m_Climber.spinElevator();
				break;
			case "Elevator Negative":
				m_Climber.setElevatorPower(-0.4);
				m_Climber.spinArticulate();
				break;
			default:
				m_Climber.stopEverything();
				break;
		}
	}

	@Override
	//-> Kills elevator when this command is cancelled. 
	public void end(boolean interrupted) {
		m_Climber.stopEverything();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
