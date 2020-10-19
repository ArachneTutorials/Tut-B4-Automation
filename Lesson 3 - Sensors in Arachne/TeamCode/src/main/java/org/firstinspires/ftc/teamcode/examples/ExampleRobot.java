package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Hardware;

import arachne.lib.ArachneRobot;
import arachne.lib.game.GameState;

public class ExampleRobot extends ArachneRobot {
    // Subsystems
    public final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

    public Hardware hardware;
    private final ExampleBindings bindings = new ExampleBindings();

    @Override
    protected void initialize(HardwareMap hardwareMap) {
        exampleSubsystem.initialize();

        hardware = new Hardware(hardwareMap);

        bindings.bindHardware(this, hardware);
    }

    @Override
    protected void setupControls(Gamepad gamepad1, Gamepad gamepad2) {
        bindings.bindControls(this, gamepad1, gamepad2);
    }

    @Override
    protected void execute(GameState state) {
        exampleSubsystem.run();
    }
}
