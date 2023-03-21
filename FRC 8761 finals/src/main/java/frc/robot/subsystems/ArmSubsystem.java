// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ArmSubsystem extends SubsystemBase {
  private Solenoid armSolenoid;
 
  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    armSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.pneumaticIds.ArmSolenoid);
    
   }

      public void ArmSolenoidControlOn() {
        armSolenoid.set(true);
      }
    
      
      public void ArmSolenoidControlOff() {
        armSolenoid.set(false);
    
      }

      public void AutoArmSolenoid(boolean retractOrExtend) {
        if (retractOrExtend == true) {
          armSolenoid.set(true);
        }
    
        else {
          armSolenoid.set(false);
        }
    
      }
  


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
