package org.firstinspires.ftc.teamcode.examples;

import arachne.lib.io.GettableDouble;
import arachne.lib.systems.Subsystem;

public class ExampleSubsystem extends Subsystem {
    private final GettableDouble.Wrapper positionSensor;

    public ExampleSubsystem() {
        this.positionSensor = new GettableDouble.Wrapper();
    }

    @Override
    public void run() {
        super.run();

        System.out.println(positionSensor.get());
    }

    public void setPositionSensor(GettableDouble sensor) {
        positionSensor.wrap(sensor);
    }
}
