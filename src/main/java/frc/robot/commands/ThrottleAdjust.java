/*
    [ commands / ThrottleAdjust.java ]
    Player attempt to move throttle values
    up or down when necessary. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ]
// // [ Files ]
import frc.robot.Constants;
import frc.robot.RobotContainer;

// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ThrottleAdjust extends CommandBase {
    //-> Initialize new boolean for bumper checks. 
    boolean leftBumper, rightBumper; 
    double increment = 0.01; 

    @Override
    //-> Should, theoretically, reduce throttle by about 0.2 every second it is held down.
    public void execute(){
        leftBumper = RobotContainer.driverControl.getLeftBumper();
        rightBumper = RobotContainer.driverControl.getRightBumper();

        //-> Sets boundaries of 0 - 1 for robot speed so we don't go haywire. 
        if (leftBumper) {
            if (Constants.throttle > 0) {
                Constants.throttle -= increment; 
            }
        } else if (rightBumper) {
            if (Constants.throttle < 1) {
                Constants.throttle += increment; 
            }
        }

        System.out.println(Constants.throttle + " : THROTTLE");
    }

    @Override
    public boolean isFinished() {
      return false;
    }
}
