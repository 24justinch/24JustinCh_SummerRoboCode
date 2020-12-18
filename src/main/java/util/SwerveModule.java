package util;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;
import harkerrobolib.wrappers.HSFalcon;

public class SwerveModule {
    private HSTalon talon;
    private HSFalcon falcon;    
    private final boolean FALCON_INVERTED=false;
    private final boolean TALON_INVERTED=false;
    private  boolean FALCON_SENSORPHASE=false;
    private double talonvolt=talon.getBusVoltage();
    private double falconvold=falcon.getBusVoltage();
    private boolean TALON_SENSORPHASE=false;

    //how do i get the thing to set current limit?

    public HSTalon getTalon(){
        return talon;
    }
    public HSFalcon getFalcon(){
        return falcon;
    }
    public void motorInit(){
        talon.configFactoryDefault();
        falcon.configFactoryDefault();
        talon.setInverted(TALON_INVERTED);
        falcon.setInverted(FALCON_INVERTED);
        talon.setSensorPhase(TALON_SENSORPHASE);
        falcon.setSensorPhase(FALCON_SENSORPHASE);
        falcon.setNeutralMode(NeutralMode.Coast);
        talon.setNeutralMode(NeutralMode.Coast);
        falcon.configStatorCurrentLimit(new StatorCurrentLimitConfiguration());
        talon.configStatorCurrentLimit(new StatorCurrentLimitConfiguration());
        falcon.enableVoltageCompensation(true);
        talon.enableVoltageCompensation(true);
        
        
    }
    
    private SwerveModule(){
       motorInit();

        

    }
}
