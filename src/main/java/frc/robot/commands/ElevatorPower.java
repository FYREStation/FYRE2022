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
	private final String sectionPower;

	public ElevatorPower(Climber subsystem, String section) {
    	m_Climber = subsystem;
    	sectionPower = section;
    	addRequirements(subsystem);
	}

  	@Override
  	public void initialize() {}

	@Override
	//-> Switch statement to check how this command should run in regards to sectionPower. 
	public void execute() {
		switch (sectionPower) {
      		case "Hook":
        		m_Climber.spinHook();
        		break;
      		case "Articulate":
        		m_Climber.spinArticulate();
        		break;
      		case "Elevator":
        		m_Climber.spinElevator();
        		break;
      		default:
        		m_Climber.stopEverything();
        		break;
		}
	}

  @Override
  //-> Kills elevator when this command is cancelled. 
  public void end(boolean interrupted) {
    m_Climber.stopElevator();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
