/*
    [ commands / OneShot.java ]
    Combination of three motors to
    create fluid shot progression. 

*/ 

// [ Package ]
package frc.robot.commands;

// [ Imports ] 
// // [ Files ] 
// import frc.robot.Constants;
import frc.robot.subsystems.*;
// // [ Classes ]
// import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;

//-> Uncomment out Constants + Spark when gatekeeper motor is being run. 

// [ Functions ]
public class OneShot extends CommandBase {
    //-> New variables to set subsystems and counting integers. 
    private final Intake mIntake; 
    private final Shooter mShooter;
    // private final Spark mGatekeeper = new Spark(Constants.gatekeeperMotor);

    int debounce = 0; 
  
    public OneShot(Shooter sSubsystem, Intake iSubsystem) {
        mShooter = sSubsystem;
        mIntake = iSubsystem; 
    	addRequirements(sSubsystem, iSubsystem);
    }

    @Override
    public void initialize() {}

    //-> Switch statement to decide the direction of the motor.
    @Override
    public void execute() {
        debounce++;

        mShooter.spinBackward();
        if (debounce == 30) {
            mIntake.runIntakeForward();
            //mGatekeeper.set(0.75);
        }
    }

  	@Override
    //-> Kills spin function.
  	public void end(boolean interrupted) {
        debounce = 0;
    
        mShooter.stopSpin();
        mIntake.stopIntake();
        //mGatekeeper.set(0.0);
  	}

  	@Override
  	public boolean isFinished() {
    	return false;
  	}
}
