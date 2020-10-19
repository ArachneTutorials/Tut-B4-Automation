package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import arachne.lib.ArachneRobot;
import arachne.lib.game.GameState;

public class Robot extends ArachneRobot {
    // Subsystems
    public final Drivetrain drivetrain = new Drivetrain();
    public final Intake intake = new Intake();

    public Hardware hardware;
    private final Bindings bindings = new Bindings();

    @Override
    protected void initialize(HardwareMap hardwareMap) {
        drivetrain.initialize();

        hardware = new Hardware(hardwareMap);

        bindings.bindHardware(this, hardware);
    }

    @Override
    protected void setupControls(Gamepad gamepad1, Gamepad gamepad2) {
        bindings.bindControls(this, gamepad1, gamepad2);
    }

    @Override
    protected void execute(GameState state) {
        drivetrain.run();
    }
}
