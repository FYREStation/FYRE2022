/*
   [ Intake ]
*/

// Grab package for frc.robot
package frc.robot.subsystems;

// Imports a series of basic APIs
import edu.wpi.first.wpilibj2.command.SubsystemBase; // Subsystem framework 
import edu.wpi.first.wpilibj.motorcontrol.Spark;

// Copy class Subsystem base to Intake
public class Intake extends SubsystemBase {

    private Spark motor = new Spark(0); // To Do: Needs to be replaced (constants must be created)
    public Intake (){
        
    }

    @Override
    public void periodic(){

    }

    @Override
    public void simulationPeriodic(){

    }

    public void setPower(double power){
        motor.set(power);
    }


}
