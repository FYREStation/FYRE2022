/*
	[ commands / IntoIntake.java ]
	Movement for flywheels on outside
	of robot, guiding balls into shooter. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ] 
import frc.robot.subsystems.Intake;
// // [ Classes ] 
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class IntoIntake extends CommandBase {
	private final Intake m_intake;
  
	public IntoIntake(Intake subsystem) {
		m_intake = subsystem;
    	addRequirements(subsystem);
	}

	@Override
	public void initialize() {} 

	@Override
	//-> Runs intake motors continuously. 
	public void execute() {
    	m_intake.runIntakeHold();
  	}

	@Override
	//-> Pauses these motors once this command is called off. 
  	public void end(boolean interrupted) {
    	m_intake.stopIntakeHold();
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
