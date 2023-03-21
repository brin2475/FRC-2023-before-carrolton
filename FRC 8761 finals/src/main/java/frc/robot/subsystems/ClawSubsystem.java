// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase {
  private Solenoid ClawSolenoid;

  /** Creates a new ClawSubsystem. */
  public ClawSubsystem() {

    ClawSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.pneumaticIds.ClawSolenoid);

  }

  public void ClawSolenoidControlOn() {
    ClawSolenoid.set(true);
  }

  public void ClawSolenoidControlOff() {
    ClawSolenoid.set(false);

  }


  
  // boolean value is set to control the the solenoids state true = on false = off

  public void AutoClawSolenoid(boolean retractOrExtend) {
    if (retractOrExtend == true) {
      ClawSolenoid.set(true);
    }

    else {
      ClawSolenoid.set(false);
    }

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
