/*
	[ subsystems / Vision.java ]
	Container for all vision commands 
	and utilities. 

*/ 

// [ Package ] 
package frc.robot.subsystems;

// [ Imports ] 
// // [ Files ] 
import frc.robot.BlueGripPipeline;
import frc.robot.Constants;
import frc.robot.RedGripPipeline;
import frc.robot.subsystems.Vision;
// // [ Classes ] 
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

// [ Functions ] 
public class Vision extends SubsystemBase {
	//-> Create set of to-be-changed variables. 
	public static double centerX, centerY, diameter = 0.0;
	private static VisionThread visionThread;

	//-> Create camera object with img resolution. 
  	private static final int IMG_WIDTH = 320;
  	private static final int IMG_HEIGHT = 240;
  	private static UsbCamera camera = Constants.camera;

  	public Vision() {
		//-> Passes resolution on startup. 
    	camera.setResolution(IMG_WIDTH, IMG_HEIGHT); 
  	}

	@Override
	//-> Passes numbers to SmartDashboard for visual convenience. 
  	public void periodic() {
    	SmartDashboard.putNumber("Center X", centerX);
    	SmartDashboard.putNumber("Center Y", centerY);
    	SmartDashboard.putNumber("Diameter", diameter);
    	SmartDashboard.putString("Testing", "Periodic");
  	}

	public static final Object imgLock = new Object();
	  
  	//-> Function for vector calculation. 
  	public void getVisionVectors() {
		//-> Getting the input from the camera.
		
    	//-> Deciding what aliance we are on and calculating the vectors
    	if (DriverStation.getAlliance().toString() == "RED") {
      		SmartDashboard.putString("Alliance", "Red");
      		visionThread = new VisionThread(camera, new RedGripPipeline(), pipeline -> {
      			if (!pipeline.filterContoursOutput().isEmpty()) {
       	 			Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
        			diameter = r.width;
        			centerX = r.x + (r.width / 2);
        			centerY = r.y + (r.height / 2);
      			}
      			visionThread.start();
      		});
    	} else {
      		SmartDashboard.putString("Alliance", "Blue");
      		visionThread = new VisionThread(camera, new BlueGripPipeline(), pipeline -> {
				if (!pipeline.filterContoursOutput().isEmpty()) {
					Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
					diameter = r.width;
					centerX = r.x + (r.width / 2);
					centerY = r.y + (r.height / 2);
				}
      			visionThread.start();
      		});
    	}
	}

	//-> Data returning functions. 
	public static double getRadius() {
    	return(diameter);
	}

	public static double getCenter(String input) {
    	if (input == "X") {
      		return(centerX);
    	} else {
      		return(centerY);
    	}
  	}

  	@Override
  	public void simulationPeriodic() {}
}
