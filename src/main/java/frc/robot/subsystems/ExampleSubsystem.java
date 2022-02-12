/*
	[ subsystem / ExampleSubsystem.java ]
	Example framework for possible
	future subsystem. 

*/ 

// [ Package ]
package frc.robot.subsystems;

// [ Imports ] 
// // [ Classes ] 
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
	//-> Creates a new ExampleSubsystem. 
	public ExampleSubsystem() {}

	@Override
	//-> This method will be run once per scheduler run. 
	public void periodic() {}

	@Override
	//-> Similar to periodic(), however it will only run during simulation. 
	public void simulationPeriodic() {}
}