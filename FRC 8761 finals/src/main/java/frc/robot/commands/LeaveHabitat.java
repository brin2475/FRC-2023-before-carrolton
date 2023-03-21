// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClawSubsystem; 
import edu.wpi.first.wpilibj2.command.StartEndCommand;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LeaveHabitat extends SequentialCommandGroup {
  /** Creates a new ChargeCube. */
  public LeaveHabitat(
    DriveSubsystem drive,
      ArmSubsystem arm,
      ClawSubsystem claw
  ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());



    // this command will leave the habitat resulting in 3 points 
    addCommands(
      new StartEndCommand(
            () -> drive.autoDrive(3, 0), () -> drive.stop(), drive).withTimeout(5)
    );
            
      
    
  }
}
