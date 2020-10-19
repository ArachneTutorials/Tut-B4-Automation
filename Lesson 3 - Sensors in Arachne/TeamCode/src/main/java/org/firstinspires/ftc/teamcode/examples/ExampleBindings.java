package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ExampleBindings {
    public void bindControls(ExampleRobot robot, Gamepad gamepad1, Gamepad gamepad2) {}

    public void bindHardware(ExampleRobot robot, ExampleHardware hardware) {
        // Option 1
        robot.exampleSubsystem.setPositionSensor(hardware.leftMotorPosition);

        // Option 2
        robot.exampleSubsystem.setPositionSensor(hardware.driveLeft::getCurrentPosition);
    }
}
