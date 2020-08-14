package frc.robot.commands;



import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystem.Intake;
public class ToggleArm extends InstantCommand{
    public ToggleArm(){
        addRequirements(Intake.getInstance());

    }
    public void initialize(){
        Intake.getInstance().getSol().set(Intake.getInstance().invert(Intake.getInstance().getSol().get()));
    }
}