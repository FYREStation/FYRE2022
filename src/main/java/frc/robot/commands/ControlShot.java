/*
    [ commands / ControlShot.java ]
    Controller of firing balls in 
    pinball shooting mechanism.  

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ] 
import frc.robot.subsystems.Shooter;
// // [ Classes ]
import edu.wpi.first.wpilibj2.command.CommandBase;

// [ Functions ]
public class ControlShot extends CommandBase {
    private final Shooter m_shot;
    String going_direction;
  
    public ControlShot(Shooter subsystem, String direction) {
    	m_shot = subsystem;
        going_direction = direction;
    	addRequirements(subsystem);
    }

    @Override
    public void initialize() {}

    //-> Switch statement to decide the direction of the motor.
    @Override
    public void execute() {
        switch(going_direction) {
            case "Shooter_Forward":
                m_shot.spinForward();
                break;
            case "Shooter_Backward":
                m_shot.spinBackward();
            default:
                m_shot.stopSpin();
                break;
        }

    }

  	@Override
    //-> Kills spin function.
  	public void end(boolean interrupted) {
    	m_shot.stopSpin();
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
