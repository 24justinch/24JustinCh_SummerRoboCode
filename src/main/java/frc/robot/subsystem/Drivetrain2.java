package frc.robot.subsystem;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;
import frc.robot.RobotMap;

public class Drivetrain2 extends SubsystemBase {
    private static Drivetrain2 drivetrain;
    private HSTalon rightMaster;
    private HSTalon leftMaster;
    private HSTalon rightHelper;
    private HSTalon leftHelper;
    private static final boolean LEFT_FOLLOWER_INVERTED = false;
    private static final boolean RIGHT_FOLLOWER_INVERTED = false;
    private static final boolean LEFT_MASTER_INVERTED = false;
    private static final boolean RIGHT_MASTER_INVERTED = false;
    public static boolean leftSensorPhase = false;
    public static boolean rightSensorphase = false;
    private static final double KD = 0.0;
    private static final double KI = 0.0;
    private static final double KP = 0.0;

    private Drivetrain2() {
        rightMaster = new HSTalon(RobotMap.RIGHT_MASTER_ID);
        rightHelper = new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);
        leftMaster = new HSTalon(RobotMap.LEFT_MASTER_ID);
        leftHelper = new HSTalon(RobotMap.LEFT_FOLLOWER_ID);
    }

    public void configPositonPID() {
        rightMaster.config_kD(RobotMap.SLOT_INDEX, KD);
        rightMaster.config_kI(RobotMap.SLOT_INDEX, KI);
        rightMaster.config_kP(RobotMap.SLOT_INDEX, KP);
        leftMaster.config_kD(RobotMap.SLOT_INDEX, KD);
        leftMaster.config_kI(RobotMap.SLOT_INDEX, KI);
        leftMaster.config_kP(RobotMap.SLOT_INDEX, KP);

        rightMaster.selectProfileSlot(RobotMap.SLOT_INDEX, RobotMap.LOOP_INDEX);// ru sure its loop index
        leftMaster.selectProfileSlot(RobotMap.SLOT_INDEX, RobotMap.LOOP_INDEX); // yes // Alright

    }

    public void talonInit() {
        rightHelper.configFactoryDefault();
        rightMaster.configFactoryDefault();
        leftHelper.configFactoryDefault();
        leftMaster.configFactoryDefault();

        leftHelper.follow(leftMaster);
        rightHelper.follow(rightMaster);

        rightMaster.setInverted(RIGHT_MASTER_INVERTED);
        leftMaster.setInverted(LEFT_MASTER_INVERTED);
        rightHelper.setInverted(LEFT_FOLLOWER_INVERTED);
        leftHelper.setInverted(LEFT_FOLLOWER_INVERTED);
        rightHelper.setSensorPhase(RIGHT_FOLLOWER_INVERTED);
        
        rightMaster.setSensorPhase(rightSensorphase);
    }

    public void setPercentOutput(double value, double turn) {
        leftMaster.set(ControlMode.PercentOutput, value + turn);
        rightMaster.set(ControlMode.PercentOutput, value - turn);
    }

    public HSTalon getRightMaster() {
        return rightMaster;
    }

    public HSTalon getLeftMaster() {
        return leftMaster;
    }

    public static Drivetrain2 getInstance() {
        if (drivetrain == null) {
            drivetrain = new Drivetrain2();
        }
        return drivetrain;

    }

}