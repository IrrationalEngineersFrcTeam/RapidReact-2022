// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.Constants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

// Add imports for WPI_TalonFX FX motors
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class driveSystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
        private WPI_TalonFX m_frontL;
        private WPI_TalonFX m_backL;
        private WPI_TalonFX m_frontR;
        private WPI_TalonFX m_backR;
        private DifferentialDrive differentialDrive1;
        private boolean m_enabled;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public driveSystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        m_frontL = new WPI_TalonFX(Constants.DriveConstants.kLeftFrontMotorPort, "rio");
        m_backL = new WPI_TalonFX(Constants.DriveConstants.kLeftBackMotorPort, "rio");
        m_frontR = new WPI_TalonFX(Constants.DriveConstants.kRightFrontMotorPort, "rio");
        m_backR = new WPI_TalonFX(Constants.DriveConstants.kRightBackMotorPort, "rio");

        m_frontL.configFactoryDefault();
        m_backL.configFactoryDefault();
        m_frontR.configFactoryDefault();
        m_backR.configFactoryDefault();

        m_frontL.set(ControlMode.PercentOutput, 0);
        m_backL.set(ControlMode.PercentOutput, 0);
        m_frontR.set(ControlMode.PercentOutput, 0);
        m_backR.set(ControlMode.PercentOutput, 0);

        m_backL.follow(m_frontL);
        m_backR.follow(m_frontR);

        m_frontR.setInverted(TalonFXInvertType.CounterClockwise);
        m_frontL.setInverted(TalonFXInvertType.Clockwise);

        m_backR.setInverted(InvertType.FollowMaster);
        m_backL.setInverted(InvertType.FollowMaster);

        differentialDrive1 = new DifferentialDrive(m_frontL, m_frontR);

        
        differentialDrive1.setSafetyEnabled(false);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);
        m_enabled = true;



        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void TankDrive (double speedL, double speedR) {
        if (m_enabled == true) {
            differentialDrive1.tankDrive(speedL, speedR);
        } else {
            differentialDrive1.tankDrive(0, 0);
        }
    }

    public void enable() {
        m_enabled = true;
    }

    public void disable() {
        m_enabled = false;
    }

    public double getSensor() {
        return 0.0;
    }

}

