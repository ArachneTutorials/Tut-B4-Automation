package org.firstinspires.ftc.teamcode;

import arachne.lib.pipeline.DoublePipe;
import arachne.lib.pipeline.DoubleSource;
import arachne.lib.systems.Subsystem;

public class Drivetrain extends Subsystem {
    private final DoublePipe leftOutput, rightOutput;

    public Drivetrain() {
        this.leftOutput = new DoublePipe(0);
        this.rightOutput = new DoublePipe(0);
    }

    public void drive(double speed, double rotation) {
        leftOutput.accept(speed + rotation);
        rightOutput.accept(speed - rotation);
    }

    public DoubleSource getLeftOutput() {
        return leftOutput;
    }

    public DoubleSource getRightOutput() {
        return rightOutput;
    }
}
