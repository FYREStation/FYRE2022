/*
    [ commands / VisionProcessing.java ]
    Established camera framework for detecting
    balls and discerning their colors. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ] 
import frc.robot.subsystems.Vision;
// // [ Classes ] 
import edu.wpi.first.wpilibj2.command.CommandBase;

//Class to handle all of the calculations
public class VisionProcessing extends CommandBase {
    private final Vision Vision;

    /*-> Defining all of the vectors that are going to be used
      -> Camera width and height */

    public VisionProcessing(Vision subsystem) {
        Vision = subsystem;
        addRequirements(subsystem);
    }

    @Override
    //-> Passes vision vectors through every scheduler run. 
    public void execute() {
        Vision.getVisionVectors();
    }

    @Override
    public boolean isFinished() {
        return false;
  }

}

//END OF LINE