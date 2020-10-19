package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class Bindings {
    public void bindControls(Robot robot, Gamepad gamepad1, Gamepad gamepad2) {
        robot.drivetrain.addBinding(
                () -> robot.drivetrain.drive(-gamepad1.right_stick_y, gamepad1.left_stick_x)
        );
    }

    public void bindHardware(Robot robot, Hardware hardware) {
        robot.drivetrain.getLeftOutput().attach(hardware.driveLeftFront::setPower);
        robot.drivetrain.getLeftOutput().attach(hardware.driveLeftBack::setPower);
        robot.drivetrain.getRightOutput().attach(hardware.driveRightFront::setPower);
        robot.drivetrain.getRightOutput().attach(hardware.driveRightBack::setPower);

        robot.intake.getIntakeOutput().attach(hardware.intake::setPower);
        robot.intake.setHasGamePieceSensor(hardware.hasGamePiece);
    }
}
