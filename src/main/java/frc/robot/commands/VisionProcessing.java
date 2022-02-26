// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;

//Import all of the packages to assist with vision processing
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Vision;




//Class to handle all of the calculations
public class VisionProcessing extends CommandBase {
    private final Vision m_vision;
    //Defining all of the vectors that are going to be used

    //Camera width and height

    public VisionProcessing(Vision subsystem) {
        m_vision = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        m_vision.get_vision_vectors();
    }
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
  }

}

//END OF LINE