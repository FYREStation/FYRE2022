/*
	[ subsystems / Intake.java ]
	Container for all intake commands 
	and utilities. 

*/ 

// [ Package ] 
package frc.robot.subsystems;

// [ Imports ]
// // [ Files ] 
import frc.robot.Constants;
// // [ Classes ] 
import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import edu.wpi.first.wpilibj.motorcontrol.Spark;

// [ Functions ] 
public class Intake extends SubsystemBase {
    //-> Pass in intake motor for flywheel bar. 
    private Spark motorIntake = new Spark(Constants.intakeMotor);
  
    //-> Series of motor speed commands for adjusting I/O. 
    public void runIntakeForward() {
        motorIntake.set(-0.75);
    }

    public void runIntakeBackward() {
        motorIntake.set(0.75);
    }

    public void runIntakeNormal() {
        motorIntake.set(-0.1); 
    }

    //-> Stop motor command. 
    public void stopIntake() {
        motorIntake.set(0.0);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}

}
