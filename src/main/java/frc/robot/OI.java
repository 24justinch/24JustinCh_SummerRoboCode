package frc.robot;
import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {
    
    public static HSGamepad operaterGamepad;
    public static HSGamepad driverGamepad;
    public static final int OPERATOR_PORT=0;
    public static final int DRIVER_PORT=1;
    private static OI oi;
    private OI(){
        operaterGamepad = new XboxGamepad(OPERATOR_PORT);
        driverGamepad = new XboxGamepad(DRIVER_PORT);
    }
    public static OI getInstance(){
        if (oi==null){
            oi=new OI();
        }
        return oi;
    }
}