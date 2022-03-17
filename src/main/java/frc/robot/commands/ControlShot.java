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
    private final Shooter mShooter;
    String goingDirection;
  
    public ControlShot(Shooter subsystem, String direction) {
    	mShooter = subsystem;
        goingDirection = direction;
    	addRequirements(subsystem);
    }

    @Override
    public void initialize() {}

    //-> Switch statement to decide the direction of the motor.
    @Override
    public void execute() {
        switch(goingDirection) {
            case "ShooterForward":
                mShooter.spinForward();
                break;
            case "ShooterBackward":
                mShooter.spinBackward();
                break;
            default:
                mShooter.stopSpin();
                break;
        }

    }

  	@Override
    //-> Kills spin function.
  	public void end(boolean interrupted) {
    	mShooter.stopSpin();
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
