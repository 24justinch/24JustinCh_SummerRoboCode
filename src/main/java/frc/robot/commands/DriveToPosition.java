package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystem.Drivetrain;
import frc.robot.subsystem.Drivetrain2;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import frc.robot.RobotMap;

public class DriveToPosition extends CommandBase{
    
    //private int rightMoveToPosition;
    //private int leftMoveToPosition;
    
    int distance;

    public DriveToPosition(int pos){
        addRequirements(Drivetrain2.getInstance());
        distance = pos;
    }
    
    public void initialize(){
       // Drivetrain.getInstance().getRightMaster();
        //Drivetrain.getInstance().getLeftMaster();
        Drivetrain2.getInstance().getRightMaster().setSelectedSensorPosition(0);//from get to set is this right?
        Drivetrain2.getInstance().getLeftMaster().setSelectedSensorPosition(0);
    }

    public void execute(){
        Drivetrain2.getInstance().getLeftMaster().set(ControlMode.Position, distance);
        Drivetrain2.getInstance().getRightMaster().set(ControlMode.Position, distance);
    }
    
    public void end(boolean interrupted){
        Drivetrain2.getInstance().getRightMaster().set(ControlMode.Disabled, 0);
        Drivetrain2.getInstance().getLeftMaster().set(ControlMode.Disabled, 0);
    }
    
	public boolean isFinished(){
        return Math.abs(Drivetrain2.getInstance().getRightMaster().getClosedLoopError()) <= Drivetrain2.allowableError && Math.abs(Drivetrain2.getInstance().getLeftMaster().getClosedLoopError()) <= Drivetrain.allowableError;
    }
}