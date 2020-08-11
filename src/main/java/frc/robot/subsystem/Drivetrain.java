package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

/**
 * Drivetrain
 */
public class Drivetrain extends SubsystemBase{
    
    public static Drivetrain drivetrain;
    private HSTalon leftMaster;

    private HSTalon leftFollower;
    
    private HSTalon rightMaster;
    private HSTalon rightFollower;
    
    public final int KP;
    public final int KI;
    public final int KD;

    private Drivetrain() {

        leftFollower = new HSTalon(RobotMap.LEFT_FOLLOWER_ID);
        leftMaster = new HSTalon(RobotMap.LEFT_MASTER_ID);
        rightFollower = new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);
        rightMaster = new HSTalon(RobotMap.RIGHT_MASTER_ID);
    }

    public void drive( double speed) {
        leftMaster.set(ControlMode.PercentOutput , speed);
        rightMaster.set(ControlMode.PercentOutput, speed);
    }

    public void turn( double speed) {
        leftMaster.set(ControlMode.PercentOutput , speed);
        rightMaster.set(ControlMode.PercentOutput, -1 * speed);
    }
    
    public int calculateError(int t){
        
    }
    
    public void talinInit(){
        //how to reset

    }
    public Drivetrain getInstance() {
        if (drivetrain == null) {
            drivetrain = new Drivetrain();
        }
        return drivetrain;
    }
}
     
