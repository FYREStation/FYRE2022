// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
/*
import java.lang.reflect.Array;
import java.util.function.BinaryOperator;

import com.fasterxml.jackson.databind.util.RawValue;
*/
import org.opencv.core.Mat;
/*
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
*/
import edu.wpi.first.cscore.UsbCamera;
/*
import edu.wpi.first.cscore.UsbCameraInfo;
import edu.wpi.first.cscore.VideoCamera;
import edu.wpi.first.cscore.raw.RawSource;
*/
import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.vision.VisionRunner;
import edu.wpi.first.vision.VisionThread;
/*
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
*/
public class VisionProcessing extends TimedRobot {
  /** Creates a new ExampleSubsystem. */

  private VisionThread visionThread;
  //To be used for image display
  private static final int IMG_WIDTH = 320;
  private static final int IMG_HEIGHT = 240;
  //Will be computed through the center X value of the detected target
  //private double centerX = 0.0;
  //WPI class that makes it easy to do camera processing

  public void get_vison_array() {
    GripPipeline Bazinga = new GripPipeline();
    Mat image = Bazinga.findBlobsOutput();
    UsbCamera camera = CameraServer.startAutomaticCapture();
    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
    public Object image = Bazinga.process(image); 
  }
  //@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

  }
}
