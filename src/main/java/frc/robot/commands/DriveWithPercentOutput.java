package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystem.Drivetrain2;

    
public class DriveWithPercentOutput extends IndefiniteCommand{
    private int percentoutput;
    private int turnvalue;
    @Override
    public void execute(){
        Drivetrain2.getInstance().setPercentOutput(percentoutput, turnvalue);//is this right??? 
    }
    public void initialize(){
        
    }

    public boolean end(boolean interrupted){
        //set it all to 0
        Drivetrain2.getInstance().setPercentOutput(0, 0);

    }
    public boolean isFinished(){
        //how do we know?
    }
    public DriveWithPercentOutput(int percent,int turn){
        addrequirement(Drivetrain2.getInstance()); 
        percentoutput=percent;
        turnvalue=turn;

    }
}

