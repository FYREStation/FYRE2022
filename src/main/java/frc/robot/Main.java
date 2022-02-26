/*
	[ Main.java ]
	Original file ran when 
	constructing robot code. 

*/ 

/* -> Do NOT add any static variables or initialization to this class. The only thing you should
modify in this file the parameter class to the startRobot call, unless you are positive you know what you're doing. */ 

// [ Package ] 
package frc.robot;

// [ Imports ] 
// // [ Classes ] 
import edu.wpi.first.wpilibj.RobotBase;

// [ Functions ]
public final class Main {
	private Main() {}

	/* -> Main initialzation function. Do not initialize anything here. */ 
	public static void main(String... args) {
		RobotBase.startRobot(Robot::new);
	}
}
