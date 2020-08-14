package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
/**
 * Drivetrain
 */
public class Drivetrain extends SubsystemBase{
    
    public static Drivetrain drivetrain;
    private  HSTalon leftMaster;
    private HSTalon leftFollower;
    
    private HSTalon rightMaster;
    private HSTalon rightFollower;

    public static final double KP=0.0;
    public static final double KI=0.0;
    public static final double KD=0.0;
    public static final int allowableError = 0;

    //true means going forward, false means going backwards
    public static final boolean LEFT_MASTER_SENSOR_PHASE = true;
    public static final boolean RIGHT_MASTER_SENSOR_PHASE = true; 

    private Drivetrain() {
        leftFollower = new HSTalon(RobotMap.LEFT_FOLLOWER_ID);
        leftMaster = new HSTalon(RobotMap.LEFT_MASTER_ID);
        rightFollower = new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);
        rightMaster = new HSTalon(RobotMap.RIGHT_MASTER_ID);
    }  

    public void configPositionPIDConstants(){
        leftMaster.config_kP(RobotMap.SLOT_INDEX, KP);
        leftMaster.config_kI(RobotMap.SLOT_INDEX, KI);
        leftMaster.config_kD(RobotMap.SLOT_INDEX, KD);
        rightMaster.config_kP(RobotMap.SLOT_INDEX, KP);
        rightMaster.config_kI(RobotMap.SLOT_INDEX, KI);
        rightMaster.config_kD(RobotMap.SLOT_INDEX, KD);
        leftMaster.selectProfileSlot(RobotMap.SLOT_INDEX, RobotMap.LOOP_INDEX);
        rightMaster.selectProfileSlot(RobotMap.SLOT_INDEX, RobotMap.LOOP_INDEX);
        leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.LOOP_INDEX);
        rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.LOOP_INDEX);        
    }

    public void setPercentOutput(double speed,double turn){
        leftMaster.set(ControlMode.PercentOutput , speed+turn);
        rightMaster.set(ControlMode.PercentOutput, speed-turn);
        
    }

   

    public void talonInit() {
        leftMaster.configFactoryDefault();
        rightMaster.configFactoryDefault();
        leftFollower.configFactoryDefault();
        rightFollower.configFactoryDefault();
        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
        leftMaster.setInverted(true);
        rightMaster.setInverted(true);
        leftMaster.setSensorPhase(LEFT_MASTER_SENSOR_PHASE);
        rightMaster.setSensorPhase(RIGHT_MASTER_SENSOR_PHASE);
    }
    public HSTalon getRightMaster(){
        return rightMaster;
    }

    public HSTalon getLeftMaster(){
        return leftMaster;
    }

   
    
    public static final Drivetrain getInstance() {
        if (drivetrain==null) {
            drivetrain = new Drivetrain();
        }
        return drivetrain;
   
    }  
 }

 

 

 

