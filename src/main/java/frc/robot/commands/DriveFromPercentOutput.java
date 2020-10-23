package frc.robot.commands;

import harkerrobolib.commands.IndefiniteCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystem.Intake;

public class DriveFromPercentOutput extends IndefiniteCommand{
    private double speed;
    public DriveFromPercentOutput(double s){
        addRequirements(Intake.getInstance());
       this.speed= s;
       
    }
    public void initialize(){
       
    }
    public void execute(){
        Intake.getInstance().getWheel().set(ControlMode.PercentOutput,speed);
    }
    public void end(boolean interrupted){
        Intake.getInstance().getWheel().set(ControlMode.Disabled,0);
    }
    
}
