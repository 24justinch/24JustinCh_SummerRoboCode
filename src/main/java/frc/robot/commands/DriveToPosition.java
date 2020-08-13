package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystem.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import frc.robot.RobotMap;

public class DriveToPosition extends CommandBase{
    
    //private int rightMoveToPosition;
    //private int leftMoveToPosition;
    
    static int distance;

    public DriveToPosition(int pos){
        addRequirements(Drivetrain.getInstance());
        distance = pos;
    }
    
    public void initialize(){
        Drivetrain.getInstance().getRightMaster();
        Drivetrain.getInstance().getLeftMaster();
        Drivetrain.getInstance().getRightMaster().getSelectedSensorPosition(0);
        Drivetrain.getInstance().getLeftMaster().getSelectedSensorPosition(0);
    }

    public void execute(){
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Position, distance);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Position, distance);
    }
    
    public void end(boolean interrupted){
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Disabled, 0);
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Disabled, 0);
    }
    
	public boolean isFinished(){
        return Drivetrain.getInstance().getRightMaster().getClosedLoopError() <= Drivetrain.allowableError && Drivetrain.getInstance().getLeftMaster().getClosedLoopError() <= Drivetrain.allowableError;
    }
}