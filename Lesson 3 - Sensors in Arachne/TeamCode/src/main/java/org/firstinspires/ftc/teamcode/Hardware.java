package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import arachne.lib.io.GettableBoolean;

public class Hardware {
    // Motors
    public final DcMotor driveLeftFront, driveLeftBack, driveRightFront, driveRightBack;
    public final DcMotor intake;

    // Sensors
    public final GettableBoolean hasGamePiece;

    public Hardware(HardwareMap map) {
        driveLeftFront = map.get(DcMotor.class, "driveLF");
        driveLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        driveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveLeftBack = map.get(DcMotor.class, "driveLB");
        driveLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        driveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveRightFront = map.get(DcMotor.class, "driveRF");
        driveRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveRightBack = map.get(DcMotor.class, "driveRB");
        driveRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intake = map.get(DcMotor.class, "intake");
        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DigitalChannel limitSwitch = map.get(DigitalChannel.class, "limitswitch");
        hasGamePiece = limitSwitch::getState;
    }
}
