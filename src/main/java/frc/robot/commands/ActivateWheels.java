package frc.robot.commands;

import harkerrobolib.commands.IndefiniteCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystem.Intake;

public class ActivateWheels extends IndefiniteCommand{
    private double speed;
    public ActivateWheels(double s){
        addRequirements(Intake.getInstance());
       this.speed= s;
       
    }
    public void initialize(){
       
    }
    public void execute(){
        Intake.getInstance().getWheel().set(ControlMode.PercentOutput,speed);
    }
    public void end(){
        Intake.getInstance().getWheel().set(ControlMode.Disabled,0);
    }
    
}