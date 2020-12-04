package util;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;
import harkerrobolib.wrappers.HSFalcon;

public class SwerveModule {
    private HSTalon talon;
    private HSFalcon falcon;    
    private static final boolean FALCON_INVERTED=false;
    private static final boolean TALON_INVERTED=false;
    private static boolean FALCON_SENSORPHASE=false;
    private static boolean TALON_SENSORPHASE=false;
    public void motorInit(){
        talon.configFactoryDefault();
        falcon.configFactoryDefault();
        

    }
    private SwerveModule(){
       motorInit();

        

    }
}
