package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystem.Drivetrain2;
import harkerrobolib.commands.IndefiniteCommand;
    
public class DriveWithPercentOutput extends IndefiniteCommand {

    public void initialize(){}
    
    @Override
    public void execute(){
        Drivetrain2.getInstance().setPercentOutput(OI.getInstance().getDriver().getLeftY(),OI.getInstance().getDriver().getLeftX());//is this right??? 
    }
   
    public boolean isFinished(){
        return false;
    }
    public void end(boolean interrupted){
        //set it all to 0
        Drivetrain2.getInstance().setPercentOutput(0, 0);
    }
    public DriveWithPercentOutput(int percent,int turn){
        
        addRequirements(Drivetrain2.getInstance());

    }
}

