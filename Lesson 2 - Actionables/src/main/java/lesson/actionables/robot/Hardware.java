package lesson.actionables.robot;

import arachne.lib.io.GettableBoolean;
import arachne.lib.pipeline.BooleanSink;

public class Hardware {
    public final GettableBoolean intakeHasCube = new BooleanSink(false);
}
