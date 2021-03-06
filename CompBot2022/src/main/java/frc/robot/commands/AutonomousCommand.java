// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.driveSystem;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class AutonomousCommand extends CommandBase {
    private final driveSystem m_driveSystem;
    private boolean isDriving;
    private double distanceDriven;
    private double startingPosition;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public AutonomousCommand(driveSystem driveSys) {
        m_driveSystem = driveSys;
        addRequirements(m_driveSystem);
        isDriving = false;
        distanceDriven = 0.0;
        startingPosition = m_driveSystem.getSensor();
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
            // Get the initial value of the drive train sensor.
            m_driveSystem.TankDrive(Constants.DriveConstants.kDriveSpeed, Constants.DriveConstants.kDriveSpeed);
            isDriving = true;
        
    }

    // Called once the command ends or is interrupted.
    @Override
    
    public void end(boolean interrupted) {
        m_driveSystem.TankDrive(0, 0);
    }


    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
            m_driveSystem.getSensor();
            distanceDriven = m_driveSystem.getSensor() - startingPosition;
            return (distanceDriven >= Constants.DriveConstants.kTarmacDistance);
           
        
        //return !isDriving;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
