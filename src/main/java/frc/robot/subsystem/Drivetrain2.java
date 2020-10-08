package frc.robot.subsystem;

import harkerrobolib.wrappers.HSTalon;

public class Drivetrain2 {
    private static Drivetrain2 drivetrain;
    private static HSTalon rightMaster;
    private static HSTalon leftMaster;
    private static HSTalon rightHelper;
    private static HSTalon leftHelper;
    private Drivetrain2(){


    }
    public static Drivetrain2 getInstance(){
        if (drivetrain==null){
            drivetrain=new Drivetrain2();
        }
        return drivetrain;

    }
    public static void initMotors(){
        rightMaster.confi
        
    }
}
