/*
   [ Intake ]
*/

// Grab package for frc.robot
package frc.robot.subsystems;

// Imports a series of basic APIs
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase; // Subsystem framework 
import edu.wpi.first.wpilibj.motorcontrol.Spark;

// Copy class Subsystem base to Intake
public class Intake extends SubsystemBase {

    private Spark motorIntake = new Spark(Constants.intakeMotor);

    public Intake (){
        
    }

    @Override
    public void periodic(){

    }

    @Override
    public void simulationPeriodic(){}
  
    public void run_intake_forward() {
        motorIntake.set(1.0);
    }

    public void run_intake_backward() {
        motorIntake.set(-1.0);
    }

    public void stopIntake() {
        motorIntake.set(0.0);
    }


}
