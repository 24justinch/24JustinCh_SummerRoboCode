package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystem.HatchLatcher;
public class ToggleFlower extends InstantCommand{
    public ToggleFlower(){
        addRequirements(HatchLatcher.getInstance());
    }
    public void initialize(){
        HatchLatcher.getInstance().getFlower().set(HatchLatcher.invert(HatchLatcher.getInstance().getFlower().get()));
    }
    
    
}