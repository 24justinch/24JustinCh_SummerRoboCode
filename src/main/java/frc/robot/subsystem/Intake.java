package frc.robot.subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Intake extends SubsystemBase{
    private static Intake intake;
    private HSTalon wheel;
    private DoubleSolenoid arm;
    public static final double KP=0.0;
    public static final double KI=0.0;
    public static final double KD=0.0;
    public static final int allowableError = 0;
    public static final boolean WHEEL_SENSOR_PHASE=true;
    private Intake(){
        arm = new DoubleSolenoid(RobotMap.WHEEL_FORWARD, RobotMap.WHEEL_REVERSE);
        wheel=new HSTalon(RobotMap.ARM_ID);
    }
    public static DoubleSolenoid.Value invert(DoubleSolenoid.Value val){
        switch (val) {
            case kForward:
                return DoubleSolenoid.Value.kReverse;
            case kReverse:
                return DoubleSolenoid.Value.kForward;
            default:
                return DoubleSolenoid.Value.kForward;
        }
       
    }
    public void configPositionPIDConstants(){
        wheel.config_kP(RobotMap.SLOT_INDEX, KP);
        wheel.config_kD(RobotMap.SLOT_INDEX,KD);
        wheel.config_kI(RobotMap.SLOT_INDEX,KI);
        wheel.selectProfileSlot(RobotMap.SLOT_INDEX, RobotMap.LOOP_INDEX);
        wheel.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.LOOP_INDEX);
    }
    public void setPercentOutput(double speed){
        wheel.set(ControlMode.PercentOutput, speed);
        
    }
    public void talonInit() {
        wheel.configFactoryDefault();
   
        wheel.setInverted(true);
        wheel.setSensorPhase(WHEEL_SENSOR_PHASE);
    }

    public HSTalon getWheel(){
        return wheel;
    }

    public DoubleSolenoid getArm(){
        return arm;
    }

    public static Intake getInstance(){
        if (intake == null){
            intake = new Intake();
        }
        return intake;
    }
    
}