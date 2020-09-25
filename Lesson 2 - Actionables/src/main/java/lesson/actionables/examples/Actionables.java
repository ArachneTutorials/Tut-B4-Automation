package lesson.actionables.examples;

import static arachne.lib.sequences.Actionable.*;

import arachne.lib.io.GettableBoolean;
import arachne.lib.pipeline.BooleanSink;
import arachne.lib.sequences.Actionable;
import arachne.lib.sequences.conditions.Clock;
import lesson.actionables.robot.Climber;
import lesson.actionables.robot.Hardware;
import lesson.actionables.robot.Intake;

public class Actionables {
    Intake intake = new Intake();
    Climber climber = new Climber();
    Hardware hardware = new Hardware();
    GettableBoolean shooterOnTarget = new BooleanSink(false);

    Actionable a = DO_NOTHING();

    Actionable b = DO(() -> intake.intake(true));

    Actionable c = SEQUENCE(
        b,
        DO(() -> climber.climb(false)),
        DO(() -> intake.intake(false))
    );

    Actionable d = WAIT(500);

    Actionable e = WAIT();

    Actionable f = SEQUENCE(
        DO(() -> intake.intake(true)),
        WAIT(500),
        DO(() -> intake.intake(false))
    ).UNSAFE_UNTIL(hardware.intakeHasCube);

    Actionable g = WAIT().UNSAFE_UNTIL(hardware.intakeHasCube);

    Actionable h = SEQUENCE(
        SEQUENCE(
            DO(() -> intake.intake(true)),
            WAIT(500)
        ).UNSAFE_UNTIL(
            (finishedSequence) -> finishedSequence || hardware.intakeHasCube.get()
        ),
        DO(() -> intake.intake(false))
    );

    Actionable i = SEQUENCE(
        DO(() -> intake.intake(true)),
        WAIT().UNTIL(() -> {
            GettableBoolean condition = Clock.delay(500).or(hardware.intakeHasCube);
            return condition.toPredicate();
        }),
        DO(() -> intake.intake(false))
    );

    Actionable j = SEQUENCE(
        IF(hardware.intakeHasCube).THEN(
            DO(() -> intake.outtake(true))
        ).ELSE_IF(shooterOnTarget).THEN(
            DO(() -> { /* Some shooting sequence */ })
        ).ELSE(
            DO(() -> intake.intake(true))
        )
    );

    Actionable k = REPEAT(
        () -> { /* Track target */ }
    ).UNSAFE_UNTIL(Clock.delay(500));

    Actionable l = SPLIT(
        SEQUENCE()
    ).AND(
        SEQUENCE()
    ).AND(
        SEQUENCE()
    );

    Actionable m = REQUIRE(intake).FOR(
        SEQUENCE(
            /* Some long sequence requiring the intake */
        )
    );

    Actionable n = SEQUENCE(
        DO(() -> intake.intake(true)),
        // WAIT().UNTIL(
        //     () -> hardware.intakeHasCube.toPredicate()
        // ),
        WAIT().UNSAFE_UNTIL(hardware.intakeHasCube),
        DO(() -> intake.intake(false))
    );
}
