package lesson.actionables.robot;

import arachne.lib.pipeline.BooleanPipe;
import arachne.lib.pipeline.BooleanSource;
import arachne.lib.pipeline.DoublePipe;
import arachne.lib.pipeline.DoubleSource;
import arachne.lib.systems.Subsystem;

public class Intake extends Subsystem {
    private final DoublePipe rollerOutput;
    private final BooleanPipe grabberOutput;

    private static final double
        INTAKE_SPEED = 0.6,
        OUTTAKE_SPEED = -1;

    public Intake() {
        this.rollerOutput = new DoublePipe(0);
        this.grabberOutput = new BooleanPipe(false);
    }

    public void intake(boolean activate) {
        if(activate) {
            rollerOutput.accept(INTAKE_SPEED);
            grabberOutput.accept(true);
        }
        else {
            rollerOutput.accept(0);
            grabberOutput.accept(false);
        }
    }

    public void outtake(boolean activate) {
        if(activate) {
            rollerOutput.accept(OUTTAKE_SPEED);
        }
        else {
            rollerOutput.accept(0);
        }
    }

    public DoubleSource getRollerOutput() {
        return rollerOutput;
    }

    public BooleanSource getGrabberOutput() {
        return grabberOutput;
    }
}