package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import arachne.lib.ArachneAutoMode;
import arachne.lib.sequences.Actionable;
import arachne.lib.sequences.conditions.Clock;

import static arachne.lib.sequences.Actionable.*;

@Autonomous
public class Auto extends ArachneAutoMode<Robot> {
    public Auto() {
        super(new Robot());
    }

    @Override
    public Actionable actionable() {
        return SEQUENCE(
                DO(() -> robot.drivetrain.drive(0.5, 0)),
                WAIT().UNTIL(() -> Clock.delay(1000).toPredicate()),
                DO(() -> robot.drivetrain.drive(0, 0))
        );
    }
}
