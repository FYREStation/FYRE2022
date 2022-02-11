// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import java.lang.reflect.Array;
import java.util.function.DoubleToLongFunction;

//Import all of the packages to assist with vision processing
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cscore.UsbCamera;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.vision.VisionPipeline;
import edu.wpi.first.vision.VisionThread;




//Class to handle all of the calculations
public class VisionProcessing extends TimedRobot {
    //Defining all of the vectors that are going to be used
    public static double centerX = 0.0;
    public static double centerY = 0.0;
    public static double diameter = 0.0;
    private static VisionThread visionThread;
    //Camera width and height
    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;

    public static final Object imgLock = new Object();
    //Defining a function to calculate all of the vectors used
    public static void get_vision_vectors() {
        //Getting the input from the camera
        UsbCamera camera = CameraServer.startAutomaticCapture();
        camera.setResolution(IMG_WIDTH, IMG_HEIGHT); 
        //Deciding what aliance we are on and calculating the vectors
        if(DriverStation.getAlliance().toString() == "RED") {
            visionThread = new VisionThread(camera, new RedGripPipeline(), pipeline -> {
            if (!pipeline.filterContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                synchronized (imgLock) {
                    diameter = r.width;
                    centerX = r.x + (r.width / 2);
                    centerY = r.y + (r.height / 2);
                }
            }
            visionThread.start();
        });
        } else {
            visionThread = new VisionThread(camera, new BlueGripPipeline(), pipeline -> {
                if (!pipeline.filterContoursOutput().isEmpty()) {
                    Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                    synchronized (imgLock) {
                        diameter = r.width;
                        centerX = r.x + (r.width / 2);
                        centerY = r.y + (r.height / 2);
                        
                    }
                }
                visionThread.start();
            });
        }
        
    }


    public static double get_radius() {
        return(diameter);
    }

    public static double get_center(String input) {
        if (input == "x") {
            return(centerX);
        } else {
            return(centerY);
        }
    }

}
//END OF LINE