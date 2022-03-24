/*
	[ commands / ElevatorPower.java ]
	Established framework for 
	driving system of the robot. 

*/ 

// [ Package ]
package frc.robot.commands;

import frc.robot.Constants;
// [ Imports ] 
// // [ Files ]
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class DrivingPower extends CommandBase {
	String sectionPower;
	  
	public DrivingPower(String section) {
		sectionPower = section;
	}

	@Override
	public void initialize() {}

	//-> Switch statement for selecting power and functions for Climber command. 
	@Override
	public void execute() {
		switch (sectionPower) {
			case "Positive":
                if (Constants.throttle <1)
				    Constants.throttle += 0.05;
                break;
			case "Negative":
                if (Constants.throttle >0)
                    Constants.throttle -= 0.05;
				break;
			default:
				break;
		}
	}

	@Override
	//-> Kills elevator when this command is cancelled. 
	public void end(boolean interrupted) {
		
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
