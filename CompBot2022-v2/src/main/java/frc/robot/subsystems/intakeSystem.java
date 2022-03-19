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

//import frc.robot.Constants;
//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class intakeSystem extends SubsystemBase {
        private WPI_TalonFX lowerIntakeMotor;
        private CANSparkMax intakeWheelMotor;
        private boolean inverted;
        private boolean isIntakeLowered;

    public intakeSystem() {
            lowerIntakeMotor = new WPI_TalonFX(5, "rio");
            inverted = false;
            isIntakeLowered = false;
            intakeWheelMotor = new CANSparkMax(7, MotorType.kBrushless);
            intakeWheelMotor.restoreFactoryDefaults();
            intakeWheelMotor.setInverted(false);
            lowerIntakeMotor.setInverted(TalonFXInvertType.Clockwise);
            lowerIntakeMotor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
    }

    public void runIntakeWheels() {
        intakeWheelMotor.set(0.25);
    }

    public void stopIntakeWheels() {
        intakeWheelMotor.set(0);
    }

    public void lowerIntake() {
        if (isIntakeLowered == false) {
            lowerIntakeMotor.set(0.15);
        }
    }

    public void stopLoweringIntake() {
        lowerIntakeMotor.set(0.0);
        isIntakeLowered = true;
    }

    public void changeIntakeDirection() {
        inverted = !inverted;
        intakeWheelMotor.setInverted(inverted);
    }

    public boolean isIntakeLowered() {
        return isIntakeLowered;
    }

    public void resetIntakeState() {
        isIntakeLowered = false;
    }

    @Override
    public void simulationPeriodic() {
    }
}

