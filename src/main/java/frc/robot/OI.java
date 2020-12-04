package frc.robot;
import frc.robot.commands.ActivateWheels;
import frc.robot.commands.ToggleArm;
import frc.robot.commands.DriveWithPercentOutput;
//import frc.robot.commands.ToggleExtender;
//import frc.robot.commands.ToggleFlower;
import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {
    
    private  HSGamepad operaterGamepad;//i think these should be static
    private HSGamepad driverGamepad;
    public static final int OPERATOR_PORT = 1;
    public static final int DRIVER_PORT = 0;
    private static OI oi;
    public static final double DEADBAND = 0.1;
   
     private OI(){
    
            operaterGamepad = new XboxGamepad(OPERATOR_PORT);
        driverGamepad = new XboxGamepad(DRIVER_PORT);
        initJoystickBindings();
    }
    public void initJoystickBindings(){
        //driverGamepad.getButtonA().whenPressed(new ToggleExtender());
        //driverGamepad.getButtonB().whenPressed(new ToggleFlower());
        driverGamepad.getButtonX().whilePressed(new ActivateWheels(-0.5));
        driverGamepad.getButtonY().whenPressed(new ToggleArm());
        
    }
    public HSGamepad getDriver(){

        return driverGamepad;
    }
    public HSGamepad getOperator(){
        return operaterGamepad;
    }
    public static OI getInstance(){
        if (oi==null){
            oi=new OI();
        }
        return oi;
    }
}