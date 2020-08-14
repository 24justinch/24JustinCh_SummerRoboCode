package frc.robot.subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Intake extends SubsystemBase{
    private static Intake intake;
    private HSTalon wheel;
    private DoubleSolenoid solenoid;
  
    private Intake(){
        solenoid = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID_FORWARD, RobotMap.INTAKE_SOLENOID_REVERSE);
        wheel=new HSTalon(RobotMap.ARM_ID);
    }
    public DoubleSolenoid.Value invert(DoubleSolenoid.Value val){
        switch (val) {
            case kForward:
                return DoubleSolenoid.Value.kReverse;
            case kReverse:
                return DoubleSolenoid.Value.kForward;
            default:
                return DoubleSolenoid.Value.kForward;
        }
       
    }
    
    public void setPercentOutput(double speed){
        wheel.set(ControlMode.PercentOutput, speed);
        
    }
    public void talonInit() {
        wheel.configFactoryDefault();
        wheel.setInverted(false);
       
    }

    public HSTalon getWheel(){
        return wheel;
    }

    public DoubleSolenoid getSol(){
        return solenoid;
    }

    public static Intake getInstance(){
        if (intake == null){
            intake = new Intake();
        }
        return intake;
    }
    
}