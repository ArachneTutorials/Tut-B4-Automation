package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import arachne.lib.io.GettableDouble;

public class ExampleHardware {
    // Motors
    public final DcMotor driveLeft, driveRight;

    // Sensors
    public final GettableDouble leftMotorPosition;

    public ExampleHardware(HardwareMap map) {
        driveLeft = map.get(DcMotor.class, "driveL");
        driveLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        driveLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveRight = map.get(DcMotor.class, "driveR");
        driveRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftMotorPosition = driveLeft::getCurrentPosition;
    }
}
