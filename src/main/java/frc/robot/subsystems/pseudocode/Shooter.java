/*
   [ Shooter Pseudocode ]
   
   Used to express how the shooter code
   would work, assuming all you have to
   do is rotate just the nautilius gear. 

*/

// Grab package for frc.robot
package frc.robot.SubsystemPsuedocode;

// Imports a series of basic APIs
import edu.wpi.first.wpilibj.PWMVictorSPX; // Random motor I found, may not be used in final product
import edu.wpi.first.wpilibj2.command.SubsystemBase; // Subsystem framework 

public class Shooter extends SubsystemBase {
    // Motor variable, and boolean detectBall as a placeholder to check if a ball is in position. 
    static PWMVictorSPX motor; 
    static boolean detectBall = false; // Does not actually check ball. Just placeholder. 

    /* 
        Checks if the ball is settled, which we could probably just accomplish
        by just waiting a little bit since the ball being settled is not too important.
        Better safe than sorry! 
    */

    // Placeholder function for vision processing. Not actually feasible in real life without sensors,
    // but is something we could do. 
    static boolean checkBall(boolean ballSettled){
        // Simple return-true-or-false conditionnal 
        if (detectBall && ballSettled){
            return true; 
        }
        return false; 
    }

    static void shootBall(){
        boolean ballSettled = true; // Fake variable for usage. 
        if (Shooter.checkBall(ballSettled) && detectBall){
            motor.set(1); // 1 may not be fully accurate, as I just used a random motor class. 
        }
    }

    public static void main(String[] args) {
        Shooter.shootBall();
    }
}

