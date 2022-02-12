/*
	[ commands / IntoShootContainer.java ]
	Movement for flywheels on inside of 
	robot, propelling balls to shot position. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ] 
import frc.robot.subsystems.Intake;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class IntoShootContainer extends CommandBase {
	private final Intake m_intake;

	public IntoShootContainer(Intake subsystem) {
		m_intake = subsystem;
    	addRequirements(subsystem);
	}

	@Override
	//-> Runs the internal flywheels continously. 
	public void execute() {
		m_intake.runShootHold();
	}

	@Override
	//-> Pauses these wheels once the command is called off. 
  	public void end(boolean interrupted) {
    	m_intake.stopShootHold();
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
