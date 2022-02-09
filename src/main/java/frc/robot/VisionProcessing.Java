// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

//Import all of the packages to assist with vision processing
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cscore.UsbCamera;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.vision.VisionThread;

//Class to handle all of the calculations
public class VisionProcessing extends TimedRobot {
    //Defining all of the vectors that are going to be used
    public double centerX = 0.0;
    public double centery = 0.0;
    public double radius = 0.0;
    private VisionThread visionThread;
    //Camera width and height
    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;

    public final Object imgLock = new Object();
    //Defining a function to calculate all of the vectors used
    public void get_vision_vectors() {
    //Getting the input from the camera
    UsbCamera camera = CameraServer.startAutomaticCapture();
    camera.setResolution(IMG_WIDTH, IMG_HEIGHT); 
    //Calculations
    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
      if (!pipeline.filterContoursOutput().isEmpty()) {
          Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
          synchronized (imgLock) {
              radius = r.width;
              centerX = r.x + (r.width / 2);
              centery = r.y + (r.height / 2);
          }
      }
  });
  visionThread.start();
  }
}