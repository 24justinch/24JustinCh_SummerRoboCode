package frc.robot.subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Robot;
import frc.robot.RobotMap;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher hatchlatcher;
    private  DoubleSolenoid extenderSolenoid;
    private  DoubleSolenoid flowerSolenoid;
    private HatchLatcher(){
        flowerSolenoid = new DoubleSolenoid(RobotMap.FLOWER_FORWARD,RobotMap.FLOWER_REVERSE);
        extenderSolenoid= new DoubleSolenoid(RobotMap.EXTENDER_FORWARD,RobotMap.EXTENDER_REVERSE);
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
    
    public DoubleSolenoid getFlower(){
        return flowerSolenoid;
    }
    public DoubleSolenoid getExtender(){
        return extenderSolenoid;
    }
    public static HatchLatcher getInstance(){
        if (hatchlatcher==null){
            hatchlatcher=new HatchLatcher();
        }
        return hatchlatcher;
    }
}