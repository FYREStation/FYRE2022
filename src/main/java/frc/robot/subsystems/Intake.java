/*
   [ Intake ]
*/

// Grab package for frc.robot
package frc.robot.subsystems;

// Imports a series of basic APIs
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase; // Subsystem framework 
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

// Copy class Subsystem base to Intake
public class Intake extends SubsystemBase {

    private Relay motorOne = new Relay(Constants.intakeMotorOne);
    private Relay motorTwo = new Relay(Constants.intakeMotorTwo);

    public Intake (){
        
    }

    @Override
    public void periodic(){

    }

    @Override
    public void simulationPeriodic(){

    }

    public void runIntakeHold(){
        motorOne.set(Value.kForward);
    }

    public void stopIntakeHold(){
        motorOne.set(Value.kOff);
    }

    public void runShootHold(){
        motorTwo.set(Value.kForward);
    }

    public void stopShootHold(){
        motorTwo.set(Value.kOff);
    }

}
