package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import arachne.lib.ArachneTeleopMode;

@TeleOp
public class Teleop extends ArachneTeleopMode<Robot> {
    public Teleop() {
        super(new Robot());
    }
}
