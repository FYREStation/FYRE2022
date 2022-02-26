/*
	[ commands / OneRevolution.java ]
	Movement for flywheels on inside of 
	robot, propelling balls to shot position. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ] 
import frc.robot.subsystems.Shooter;
// // [ Classes ] 
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.ExampleSubsystem;

// [ Functions ] 
public class OneRevolution extends CommandBase {	
	@SuppressWarnings("unused")
	private final Shooter m_shooter;

  	public OneRevolution(Shooter subsystem) {
    	m_shooter = subsystem;
    	addRequirements(subsystem);
  	}

	@Override
	//-> Calculates one rotation of motor and executes it. 
	public void initialize() {
		//TODO: Condition needs to be the correct position
		
    	double distance = m_shooter.getDistance();
    	double destination = distance + 1;

    	while(distance < destination){
      		m_shooter.spinForward();
      		distance = m_shooter.getDistance();
    	}
    	m_shooter.stopSpin();
	}
	  
	@Override
	public void execute() {}

	@Override
  	public void end(boolean interrupted) {
    	m_shooter.stopSpin();
  	}

  	@Override
  	public boolean isFinished() {
    	return true;
  	}
}
