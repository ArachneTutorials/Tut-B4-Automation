package org.firstinspires.ftc.teamcode;

import arachne.lib.io.GettableBoolean;
import arachne.lib.pipeline.BooleanPipe;
import arachne.lib.pipeline.BooleanSource;
import arachne.lib.pipeline.DoublePipe;
import arachne.lib.pipeline.DoubleSource;
import arachne.lib.systems.Subsystem;

public class Intake extends Subsystem {
    private final DoublePipe intakeOutput;
    private final GettableBoolean.Wrapper hasGamePieceSensor;

    private static final double INTAKE_SPEED = 0.7;
    private static final double OUTTAKE_SPEED = -1;

    public Intake() {
        super();

        this.intakeOutput = new DoublePipe(0);
        this.hasGamePieceSensor = new GettableBoolean.Wrapper();
    }

    @Override
    public void run() {
        super.run();

        if(intakeOutput.get() > 0 && hasGamePieceSensor.get()) {
            intakeOutput.accept(0);
        }
    }

    public void intake(boolean activate) {
        if(activate) {
            intakeOutput.accept(INTAKE_SPEED);
        }
        else {
            intakeOutput.accept(0);
        }
    }

    public void outtake(boolean activate) {
        if(activate) {
            intakeOutput.accept(OUTTAKE_SPEED);
        }
        else {
            intakeOutput.accept(0);
        }
    }

    public DoubleSource getIntakeOutput() {
        return intakeOutput;
    }

    public void setHasGamePieceSensor(GettableBoolean sensor) {
        hasGamePieceSensor.wrap(sensor);
    }
}
