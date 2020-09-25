package lesson.actionables.robot;

import arachne.lib.pipeline.BooleanListener;
import arachne.lib.pipeline.BooleanPipe;
import arachne.lib.pipeline.BooleanSource;
import arachne.lib.pipeline.DoublePipe;
import arachne.lib.pipeline.DoubleSource;
import arachne.lib.states.State;
import arachne.lib.states.StatefulSubsystem;

public final class Climber extends StatefulSubsystem<Climber.SystemState, Climber>
{
	// Inputs
	private final BooleanPipe limitVerticalInput, limitHorizontalInput;
	
	// Outputs
	private final DoublePipe verticalOutput, horizontalOutput;
	private final BooleanPipe extensionOutput, unlockOutput;
	
	// Constants
	private static final double
		VERTICAL_SPEED = 0.9,
		HORIZONTAL_SPEED = 0.8;
	
	public enum SystemState implements State<SystemState, Climber> {
		STATIONARY {
			public void constructState(Climber climber) {
				climber.verticalOutput.accept(0);
				climber.horizontalOutput.accept(0);
				climber.unlockOutput.accept(false);
			}
		},
		CLIMBING_VERTICALLY {
			private BooleanListener stateEndTrigger;
			
			public void constructState(Climber climber) {
				climber.unlockOutput.accept(true);
				climber.verticalOutput.accept(VERTICAL_SPEED);
				
				stateEndTrigger = (oldValue, newValue) -> {
					if(newValue) climber.setState(CLIMBING_HORIZONTALLY);
				};
				
				climber.limitVerticalInput.attachListener(stateEndTrigger);
			}
			
			public void deconstructState(Climber climber) {
				climber.limitVerticalInput.detachListener(stateEndTrigger);
				climber.verticalOutput.accept(0);
			}
		},
		CLIMBING_HORIZONTALLY {
			private BooleanListener stateEndTrigger;
			
			public void constructState(Climber climber) {
				climber.extensionOutput.accept(true);
				climber.horizontalOutput.accept(HORIZONTAL_SPEED);
				
				stateEndTrigger = (oldValue, newValue) -> {
					if(newValue) climber.setState(CLIMBED);
				};
				
				climber.limitHorizontalInput.attachListener(stateEndTrigger);
			}
			
			public void deconstructState(Climber climber) {
				climber.limitHorizontalInput.detachListener(stateEndTrigger);
				climber.horizontalOutput.accept(0);
			}
		},
		CLIMBED;
	}
	
	public Climber() {
		super(SystemState.STATIONARY, SystemState.class);

		this.limitVerticalInput = new BooleanPipe(false);
		this.limitHorizontalInput = new BooleanPipe(false);

		this.verticalOutput = new DoublePipe(0);
		this.horizontalOutput = new DoublePipe(0);
		this.extensionOutput = new BooleanPipe(false);
		this.unlockOutput = new BooleanPipe(false);
	}

	@Override
	protected Climber getSelf() {
		return this;
	}
	
	public void climb(boolean activate) {
		if(activate) {
			setState(SystemState.CLIMBING_VERTICALLY);
		}
		else {
			setState(SystemState.STATIONARY);
		}
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

	public BooleanSource getExtensionOutput() {
		return extensionOutput;
	}

	public BooleanSource getUnlockOutput() {
		return unlockOutput;
	}
}
