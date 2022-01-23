/*
   [ Intake Pseudocode ]
   
   Used to express how the intake code
   would work in a fictional world where
   everything I write works first time.
   
   last edited by Ian G. 1/23/22
   
*/

// Grab package for frc.robot
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Imports a series of basic APIs
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX; // Random motor I found, may not be used in final product
import edu.wpi.first.wpilibj2.command.SubsystemBase; // Subsystem framework 
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Timer; // Timer for incremental wheel turning, possibly used?

// Copy class Subsystem base to Intake
public class Intake extends SubsystemBase {

    private PWMVictorSPX motor;

    // A series of booleans that defines if the round / intake should be started. 
    static boolean intakeOn = false;
    static boolean roundStarted = true;

    static void roundStart(boolean isIntakeDown){

        /*
            Since the actual intake system will be down
            when the round is started, we cannot run the
            wheels the moment the round begins. So I used
            a placeholder. 
        */

        if (isIntakeDown){
            intakeOn = true;
        }
    }
    
    // Runs a motor all the time. Not sure how fast the while loop will run
    public void simulationPeriodic(){
        while (intakeOn == true){
            //motor.set(0.2);
        }
    }

    /* 
        Here is where the color tracking stuff would go.
        Since we don't have a drive function presently set
        up, I'm omitting it from this pseudocode, due to 
        my unfamiliarity with the WpiLIB API. 

        I also do not know anything about GRIP, so I don't 
        know how the vision processing would actually work.
    */

}
