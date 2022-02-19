/*
	[ subsystem / Intake.java ]
    Container for intake commands
    and utilities.  

*/ 

// [ Package ] 
package frc.robot.subsystems;

// [ Imports ] 
// // [ Files ] 
import frc.robot.Constants;
// // [ Classes ]
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.motorcontrol.Spark;

// [ Functions ] 
public class Intake extends SubsystemBase {
    //-> Creates a motor object, whose roboRIO ports are taken from Constants. 
    private Spark motorIntake = new Spark(Constants.intakeMotor);

    public Intake () {}

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}

    //-> Run commands for Intake and Shooter. 
    public void run_intake_forward() {
        motorIntake.set(0.6);
    }

    public void run_intake_backward() {
        motorIntake.set(-0.6);
    }

    public void stopIntake() {
        motorIntake.set(0.0);
    }
    
}
