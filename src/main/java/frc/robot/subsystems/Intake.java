/*
	[ subsystem / Intake.java ]
    Container for intake commands
    and utilities.  

*/ 

// [ Package ] 
package frc.robot.subsystems;

// [ Imports ] 
// // [ Files ] 
import frc.robot.Constants;
// // [ Classes ]
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.motorcontrol.Spark;

// [ Functions ] 
public class Intake extends SubsystemBase {
    //-> Creates two motor objects, whose roboRIO ports are taken from Constants. 
    private Relay motorOne = new Relay(Constants.intakeMotorOne);
    private Relay motorTwo = new Relay(Constants.intakeMotorTwo);

    public Intake (){}

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
  
    //-> Series of methods designed to run motors at specific power settings, defined by Relay.Value. 
    public void setPower(double power){
        //motor.set(power);
    }

    //-> Run commands for Intake and Shooter. 
    public void runIntakeHold(){
        motorOne.set(Value.kForward);
    }

    public void stopIntakeHold(){
        motorOne.set(Value.kOff);
    }

    //-> Pause commands for Intake and Shooter. 
    public void runShootHold(){
        motorTwo.set(Value.kForward);
    }

    public void stopShootHold(){
        motorTwo.set(Value.kOff);
    }
}
