package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystem.Drivetrain2;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;
    
public class DriveWithPercentOutput extends IndefiniteCommand {
   
    public void initialize(){}
    
    @Override
    public void execute(){
        double deadbandY=MathUtil.mapJoystickOutput(OI.getInstance().getDriver().getLeftY(), OI.DEADBAND);
        double deadbandX=MathUtil.mapJoystickOutput(OI.getInstance().getDriver().getLeftX(), OI.DEADBAND);
        Drivetrain2.getInstance().setPercentOutput(deadbandY,deadbandX);
    }
   
    public boolean isFinished(){
        return false;
    }
    public void end(boolean interrupted){
   
        Drivetrain2.getInstance().setPercentOutput(0, 0);
    }
    public DriveWithPercentOutput(){
        
        addRequirements(Drivetrain2.getInstance());

    }
}

