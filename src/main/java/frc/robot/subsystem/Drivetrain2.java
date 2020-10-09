package frc.robot.subsystem;

import harkerrobolib.wrappers.HSTalon;

public class Drivetrain2 {
    private static Drivetrain2 drivetrain;
    private HSTalon rightMaster;
    private HSTalon leftMaster;
    private HSTalon rightHelper;
    private HSTalon leftHelper;
    private Drivetrain2(){


    }
    public static Drivetrain2 getInstance(){
        if (drivetrain==null){
            drivetrain=new Drivetrain2();
        }
        return drivetrain;

    }
    public static void initMotors(){
        
    }
}
