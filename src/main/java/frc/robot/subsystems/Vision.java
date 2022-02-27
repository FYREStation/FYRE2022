// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//Import all of the packages to assist with vision processing
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cscore.UsbCamera;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.BlueGripPipeline;
import frc.robot.Constants;
import frc.robot.RedGripPipeline;
import frc.robot.subsystems.Vision;
import edu.wpi.first.vision.VisionThread;

public class Vision extends SubsystemBase {
  public static double centerX = 0.0;
  public static double centerY = 0.0;
  public static double diameter = 0.0;
  private static VisionThread visionThread;

  private static final int IMG_WIDTH = 320;
  private static final int IMG_HEIGHT = 240;
  private static UsbCamera camera = Constants.camera;

  
  /** Creates a new ExampleSubsystem. */
  public Vision() {
    visionThread.start();
    camera.setResolution(IMG_WIDTH, IMG_HEIGHT); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Center X", centerX);
    SmartDashboard.putNumber("Center Y", centerY);
    SmartDashboard.putNumber("Diameter", diameter);
    SmartDashboard.putString("Testing", "Periodic");
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static final Object imgLock = new Object();
  //Defining a function to calculate all of the vectors used
  public void get_vision_vectors() {
    //Getting the input from the camera
    //Deciding what aliance we are on and calculating the vectors
    if(DriverStation.getAlliance().toString() == "RED") {
      SmartDashboard.putString("Alliance", "Red");
      visionThread = new VisionThread(camera, new RedGripPipeline(), pipeline -> {
        if (!pipeline.filterContoursOutput().isEmpty()) {
          try {
            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
            synchronized(imgLock){
              diameter = r.width;
              centerX = r.x + (r.width / 2);
              centerY = r.y + (r.height / 2);
              SmartDashboard.putNumber("Center X", centerX);
              SmartDashboard.putNumber("Center Y", centerY);
              SmartDashboard.putNumber("Diameter", diameter);
              SmartDashboard.putString("Testing", "Periodic");
              System.out.println(centerX);
              Thread.sleep(500);
            }
          } 
          catch (Exception e) {
            System.out.println("Vision Detection did not run! F**K!!!");
          } 
        }
      });
    } else {
      SmartDashboard.putString("Alliance", "Blue");
      visionThread = new VisionThread(camera, new BlueGripPipeline(), pipeline -> {
        if (!pipeline.filterContoursOutput().isEmpty()) {
          try {
            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
            synchronized(imgLock) {
              diameter = r.width;
              centerX = r.x + (r.width / 2);
              centerY = r.y + (r.height / 2);
              SmartDashboard.putNumber("Center X", centerX);
              SmartDashboard.putNumber("Center Y", centerY);
              SmartDashboard.putNumber("Diameter", diameter);
              SmartDashboard.putString("Testing", "Periodic");
              System.out.println(centerX);
              Thread.sleep(500);
            }
          }
          catch (Exception e) {
            System.out.println("Vision Detection did not run! F**K!!!");
          }
        }
      });
    }
  }

  
  public static double get_radius() {
      return(diameter);
  }

  public static double get_center(String input) {
    if (input == "X") {
      return(centerX);
    } else {
      return(centerY);
    }
  }
}
