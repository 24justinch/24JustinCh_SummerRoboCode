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
    private HSTalon leftMaster;;
    private HSTalon leftFollower;
    
    private HSTalon rightMaster;
    private HSTalon rightFollower;

    public static final double P=0.0;
    public static final double I=0.0;
    public static final double D=0.0;
    public static final int SLOT_INDEX=0;
    public static final double allowableError = 0.0;

    //true means going forward, false means going backwards
    boolean leftMasterDir = true;
    boolean rightMasterDir = true; 

    private Drivetrain() {
        leftFollower = new HSTalon(RobotMap.LEFT_FOLLOWER_ID);
        leftMaster = new HSTalon(RobotMap.LEFT_MASTER_ID);
        rightFollower = new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);
        rightMaster = new HSTalon(RobotMap.RIGHT_MASTER_ID);
    }

    public void configPositionPIDConstants(){
        leftMaster.config_kP(SLOT_INDEX, P);
        leftMaster.config_kI(SLOT_INDEX, I);
        leftMaster.config_kD(SLOT_INDEX, D);
        rightMaster.config_kP(SLOT_INDEX, P);
        rightMaster.config_kI(SLOT_INDEX, I);
        rightMaster.config_kD(SLOT_INDEX, D);
        leftMaster.selectProfileSlot(SLOT_INDEX, RobotMap.LOOP_INDEX);
        rightMaster.selectProfileSlot(SLOT_INDEX, RobotMap.LOOP_INDEX);

rleftMaster.sleconfigSelectedFeedbackSensor()SLOT_INDEX;
        rightMaster.configSelectedFeedbackSensor(SLOT_INDEX);        
        
    }


    public void drive( double speed) { 
        leftMaster.set(ControlMode.PercentOutput , speed);
        rightMaster.set(ControlMode.PercentOutput, speed);
    }
    public void driveToPosition(){
        
    }

    //if dir is -1 then turn right, else turn left
    public void turn( double speed, int dir) {
        leftMaster.set(ControlMode.PercentOutput , -1 * dir * speed);
        rightMaster.set(ControlMode.PercentOutput, dir * speed);
    }

    public void setSensorPhase(boolean dir,double speed){
        leftMasterDir = dir;
        rightMasterDir = dir;
        rightMaster.set(ControlMode.PercentOutput, speed);
        leftMaster.set(ControlMode.PercentOutput,speed);
    }

    public void talonInit() {
        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
        leftMaster.setInverted(true);
        rightMaster.setInverted(true);
        leftMaster.setSensorPhase(leftMasterDir);
        rightMaster.setSensorPhase(rightMasterDir);
    }
    
    public static final Drivetrain getInstance() {
        if (drivetrain==null) {
            drivetrain = new Drivetrain();
        }
        return drivetrain;
    }
}
