// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.LeaveHabitat;
import frc.robot.commands.ScoreLow;
import frc.robot.commands.ScoreLowChargeLeaveComunity;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually Pbe handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final ArmSubsystem Arm = new ArmSubsystem();

  private final DriveSubsystem DriveTrain = new DriveSubsystem();

  private final ClawSubsystem claw = new ClawSubsystem();

  private static final Joystick Brian = new Joystick(Constants.OperatorConstants.Brians_stick);

  private static final Joystick Will = new Joystick(Constants.OperatorConstants.Ritters_stick);

  // creates my Automode chooser obj for autonomous selection before matches
  private static SendableChooser<SequentialCommandGroup> AutoModeChooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    DriveTrain.setDefaultCommand(
        new RunCommand(
            () -> DriveTrain.teleop(Brian.getZ(), -Brian.getY()/0.8), DriveTrain)
          );

    // Configure the trigger bindings

    configureBindings();

    AutoModeChooser();

    defaultShuffleboardTab();
  }

  private void configureBindings() {
    JoystickButton ArmSolenoid = new JoystickButton(Will, 1);
    JoystickButton ClawSolenoid = new JoystickButton(Will, 2);
    

    ArmSolenoid.toggleOnTrue(Commands.startEnd(() -> Arm.ArmSolenoidControlOn(),
        () -> Arm.ArmSolenoidControlOff(),
        Arm));


        ClawSolenoid.toggleOnTrue(Commands.startEnd(() -> claw.ClawSolenoidControlOn(),
        () -> claw.ClawSolenoidControlOff(),
        Arm));

        
  }

  private void AutoModeChooser() {
    
    
  // this command will score low try to level and then leave the habitat resulting in 18 points if we engage 14 if not 
      AutoModeChooser.setDefaultOption("placelow,Charge,Leave 18||14 points", new ScoreLowChargeLeaveComunity(DriveTrain, Arm, claw));

  // this command will score low giving 3 points in auto 
    AutoModeChooser.addOption("Place cube/cone low 3 points", new ScoreLow(DriveTrain, Arm, claw));

  // this command will leave the habitat resulting in 3 points 
    AutoModeChooser.addOption("Leave habitay 3 points ", new LeaveHabitat(DriveTrain, Arm, claw));
  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return AutoModeChooser.getSelected();
  }

  public void defaultShuffleboardTab() {
    Shuffleboard.selectTab("SmartDashboard");
    SmartDashboard.putData("Auto Mode", AutoModeChooser);
  }
}
