package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystem.HatchLatcher;

public class ToggleExtender extends InstantCommand{
    public ToggleExtender(){
        addRequirements(HatchLatcher.getInstance());
        initialize();
    }
    public void initialize(){
        HatchLatcher.getInstance().getExtender().set(HatchLatcher.invert(HatchLatcher.getInstance().getExtender().get()));
    }
}