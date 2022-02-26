/*
	[ commands / ExampleCommand.java ]
	Example framework for possible
	future commands. 

*/ 

// [ Package ] //-> The folder the code is presently in. 
package frc.robot.commands; 

// [ Imports ] //-> Other files / classes imported from other sources for use in this code. 
// // [ Files ] 
import frc.robot.subsystems.ExampleSubsystem;
// // [ Classes ] //-> Features from the wpilib API for programming aid. 
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class ExampleCommand extends CommandBase {
	@SuppressWarnings("unused") //-> Used to quell possible "unused variable" warnings. 
	private final ExampleSubsystem m_subsystem;

	//-> Creates new ExampleCommand, passing @param subsystem to use whichever subsystem is specified. 
	public ExampleCommand(ExampleSubsystem subsystem) { 
		m_subsystem = subsystem;
		//-> Use addRequirements() to specify subsystem dependencies for a command. 
		// addRequirements(subsystem); //-> Throwing error. 
	}

	//-> When this command is scheduled to be run, this method is run in response. 
	@Override
	public void initialize() {}

	//-> Past initialize(), this method runs every scheduler run (~20ms) until this command is unscheduled.  
	@Override
	public void execute() {}

	//-> When this method is cancelled / interrupted, this method runs in response. 
	@Override
	public void end(boolean interrupted) {}

  	//-> Used as a "kill" method for commands. 
  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
