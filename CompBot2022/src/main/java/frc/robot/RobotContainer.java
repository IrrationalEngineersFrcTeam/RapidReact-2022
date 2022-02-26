// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final dumperSystem m_dumperSystem = new dumperSystem();
    public final intakeSystem m_intakeSystem = new intakeSystem();
    public final driveSystem m_driveSystem = new driveSystem();

// Joysticks
private final Joystick joystick1 = new Joystick(1);
private final Joystick joystick0 = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("driveCommand", new driveCommand( m_driveSystem ));
    SmartDashboard.putData("lowerIntakeCommand", new lowerIntakeCommand( m_intakeSystem ));
    SmartDashboard.putData("raiseIntakeCommand", new changeIntakeDirectionCommand( m_intakeSystem ));
    SmartDashboard.putData("lowerDumperCommand", new pickupCargoCommand( m_dumperSystem ));
    SmartDashboard.putData("raiseDumperCommand", new moveDumperCommand( m_dumperSystem ));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton b_lowerIntake = new JoystickButton(joystick1, Constants.RightJoystickConstants.kLowerIntake);        
b_lowerIntake.whenPressed(new lowerIntakeCommand( m_intakeSystem ) ,true);
    SmartDashboard.putData("Button Lower Intake",new lowerIntakeCommand( m_intakeSystem ) );

final JoystickButton b_changeIntakeDirection = new JoystickButton(joystick0, Constants.LeftJoystickConstants.kChangeIntakeDirection);        
b_changeIntakeDirection.whenPressed(new changeIntakeDirectionCommand( m_intakeSystem ) ,true);
    SmartDashboard.putData("Button Change Intake Direction",new changeIntakeDirectionCommand( m_intakeSystem ) );

final JoystickButton b_pickupCargo = new JoystickButton(joystick0, Constants.LeftJoystickConstants.kPickupCargo);        
b_pickupCargo.whenPressed(new pickupCargoCommand( m_dumperSystem ) ,true);
    SmartDashboard.putData("Button Pickup Cargo",new pickupCargoCommand( m_dumperSystem ) );

final JoystickButton b_moveDumper = new JoystickButton(joystick1, Constants.RightJoystickConstants.kMoveDumper);        
b_moveDumper.whenPressed(new moveDumperCommand( m_dumperSystem ) ,true);
    SmartDashboard.putData("Button Move Dumper",new moveDumperCommand( m_dumperSystem ) );



        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getJoystick0() {
        return joystick0;
    }

public Joystick getJoystick1() {
        return joystick1;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

