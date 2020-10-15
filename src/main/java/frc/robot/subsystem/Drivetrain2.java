package frc.robot.subsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;
import frc.robot.RobotMap;

public class Drivetrain2 extends SubsystemBase{
    private static Drivetrain2 drivetrain;
    private HSTalon rightMaster;
    private HSTalon leftMaster;
    private HSTalon rightHelper;
    private HSTalon leftHelper;
    private Drivetrain2(){
        rightMaster=new HSTalon(RobotMap.RIGHT_MASTER_ID);
        rightHelper=new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);
        leftMaster=new HSTalon(RobotMap.LEFT_MASTER_ID);
        leftHelper=new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);
        initMotors();
    }
    public static Drivetrain2 getInstance(){
        if (drivetrain==null){
            drivetrain=new Drivetrain2();
        }
        return drivetrain;

    }

    public void talonInit(){
        
    }
    //wait after this lets commitkk
    public void initMotors(){
        rightHelper.configFactoryDefault();
        rightMaster.configFactoryDefault();
        leftHelper.configFactoryDefault();
        leftMaster.configFactoryDefault();
        
    }


}
