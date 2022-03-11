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
	String going_direction;
  
	public IntoIntake(Intake subsystem, String direction) {
		m_intake = subsystem;
		going_direction = direction;
    	addRequirements(subsystem);
	}

	@Override
	public void initialize() {} 

	@Override
	//-> Switch statement for intake motor rotation. 
	public void execute() {
    	switch(going_direction) {
			case "Intake_Forward":
				m_intake.run_intake_forward();
				break;
			case "Intake_Backward":
				m_intake.run_intake_backward();
				break;
			default:
				m_intake.stopIntake(); 
				//m_intake.run_intake_normal();
				break;
		}
  	}

	@Override
	//-> Pauses these motors once this command is called off. 
  	public void end(boolean interrupted) {
    	m_intake.stopIntake();
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
