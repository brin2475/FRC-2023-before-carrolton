// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private WPI_TalonFX Left1, Left2, Right1, Right2;
  private DifferentialDrive drive;
  
  

  public DriveSubsystem() {
    Left1 = new WPI_TalonFX(Constants.canBus.Left1);
    Left2 = new WPI_TalonFX(Constants.canBus.Left2);
    Right1 = new WPI_TalonFX(Constants.canBus.Right1);
    Right2 = new WPI_TalonFX(Constants.canBus.Right2);     

    
    //links motor controllers together 
    MotorControllerGroup left = new MotorControllerGroup(Left1, Left2);
    MotorControllerGroup right = new MotorControllerGroup(Right1, Right2);
    
    drive = new DifferentialDrive(left, right);
    
    //disables motor saftey so we can have full motor performance 
    drive.setSafetyEnabled(false);
  }

  public void teleop(double speed, double Rotation) {
    drive.arcadeDrive(speed, Rotation);
  }

  public void autoDrive(double speed, double Rotation) {

    teleop(Rotation, speed);
 
  }

  public void stop() {
    drive.stopMotor();
 
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
