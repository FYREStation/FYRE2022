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

    private Spark motorOne = new Spark(Constants.intakeMotorOne); // TODO: Needs to be replaced (constants must be created)
    private Spark motorTwo = new Spark(Constants.intakeMotorTwo);
    private static double motorOnePower = 0;

    public Intake (){
        
    }

    @Override
    public void periodic(){

    }

    @Override
    public void simulationPeriodic(){

    }

    public void setPower(double power){
        motorOnePower = power;
    }


}
