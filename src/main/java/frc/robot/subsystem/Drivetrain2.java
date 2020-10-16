package frc.robot.subsystem;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;
import frc.robot.RobotMap;

public class Drivetrain2 extends SubsystemBase{
    private static Drivetrain2 drivetrain;
    private HSTalon rightMaster;
    private HSTalon leftMaster;
    private HSTalon rightHelper;
    private HSTalon leftHelper;
    private boolean leftInverted = false;
    private boolean rightInverted = false;
    private boolean leftSensorPhase=false;
    private boolean rightSensorphase = false;

    private Drivetrain2(){
        rightMaster=new HSTalon(RobotMap.RIGHT_MASTER_ID);
        rightHelper=new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);
        leftMaster=new HSTalon(RobotMap.LEFT_MASTER_ID);
        leftHelper=new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);
    }
    public static Drivetrain2 getInstance(){
        if (drivetrain==null){
            drivetrain=new Drivetrain2();
        }
        return drivetrain;

    }

    public void talonInit(){
        rightHelper.configFactoryDefault();
        rightMaster.configFactoryDefault();
        leftHelper.configFactoryDefault();
        leftMaster.configFactoryDefault();
        leftHelper.follow(leftMaster);
        rightHelper.follow(rightMaster);
        rightMaster.setInverted(rightInverted);
        leftMaster.setInverted(leftInverted);
        leftMaster.setSensorPhase(leftSensorPhase);
        rightMaster.setSensorPhase(rightSensorphase);   
    }
    
    public void setPercentOutput(double value,double turn){
            leftMaster.set(ControlMode.PercentOutput, value+turn);
            rightMaster.set(ControlMode.PercentOutput, value-turn);

    }

}