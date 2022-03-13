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
  	private final Climber mClimber;
	String sectionPower;
	  
	public ElevatorPower(Climber subsystem, String section) {
		mClimber = subsystem;
		sectionPower = section;
		addRequirements(subsystem);
	}

	@Override
	public void initialize() {}

	//-> Switch statement for selecting power and functions for Climber command. 
	@Override
	public void execute() {
		switch (sectionPower) {
			case "HookPositive":
				mClimber.setHookPower(0.95);
				mClimber.spinHook();
				break;
			case "HookNegative":
				mClimber.setHookPower(-0.95);
				mClimber.spinHook();
				break;
			case "ArticulatePositive":
				mClimber.setArticulatePower(0.4);
				mClimber.spinArticulate();
				break;
			case "ArticulateNegative":
				mClimber.setArticulatePower(-0.4);
				mClimber.spinArticulate();
				break;
			case "ElevatorPositive":
				mClimber.setElevatorPower(0.4);
				mClimber.spinElevator();
				break;
			case "ElevatorNegative":
				mClimber.setElevatorPower(-0.4);
				mClimber.spinElevator();
				break;
			default:
				mClimber.stopEverything();
				break;
		}
	} 

	@Override
	//-> Kills elevator when this command is cancelled. 
	public void end(boolean interrupted) {
		mClimber.stopEverything();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
