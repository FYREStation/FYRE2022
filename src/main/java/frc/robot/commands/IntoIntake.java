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
	private final Intake mIntake;
	String goingDirection;
  
	public IntoIntake(Intake subsystem, String direction) {
		mIntake = subsystem;
		goingDirection = direction;
    	addRequirements(subsystem);
	}

	@Override
	public void initialize() {} 

	@Override
	//-> Switch statement for intake motor rotation. 
	public void execute() {
    	switch(goingDirection) {
			case "IntakeForward":
				mIntake.runIntakeForward();
				break;
			case "IntakeBackward":
				mIntake.runIntakeBackward();
				break;
			default:
				mIntake.stopIntake(); 
				//mIntake.run_intake_normal();
				break;
		}
  	}

	@Override
	//-> Pauses these motors once this command is called off. 
  	public void end(boolean interrupted) {
    	mIntake.stopIntake();
	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
