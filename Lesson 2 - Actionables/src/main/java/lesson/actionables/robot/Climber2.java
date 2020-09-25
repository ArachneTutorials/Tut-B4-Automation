package lesson.actionables.robot;

import arachne.lib.pipeline.BooleanPipe;
import arachne.lib.pipeline.DoublePipe;
import arachne.lib.pipeline.DoubleSource;
import arachne.lib.sequences.Actionable;
import arachne.lib.systems.Subsystem;

import static arachne.lib.sequences.Actionable.*;

public final class Climber2 extends Subsystem
{
	// Inputs
	private final BooleanPipe limitVerticalInput, limitHorizontalInput;
	
	// Outputs
	private final DoublePipe verticalOutput, horizontalOutput;
	
	// Constants
	private static final double
		VERTICAL_SPEED = 0.9,
		HORIZONTAL_SPEED = 0.8;
	
	public Climber2() {
		super();

		this.limitVerticalInput = new BooleanPipe(false);
		this.limitHorizontalInput = new BooleanPipe(false);

		this.verticalOutput = new DoublePipe(0);
		this.horizontalOutput = new DoublePipe(0);
	}

	/**
	 * Task 2
	 * 
	 * @return An Actionable for the entire climb sequence
	 */
	public Actionable doClimb() {
		// TODO Replace return
		return null;
	}

	public void setAtVerticalLimit(boolean atLimit) {
		limitVerticalInput.accept(atLimit);
	}
	
	public void setAtHorizontalLimit(boolean atLimit) {
		limitHorizontalInput.accept(atLimit);
	}
	
	public DoubleSource getVerticalOutput() {
		return verticalOutput;
	}

	public DoubleSource getHorizontalOutput() {
		return horizontalOutput;
	}
}
