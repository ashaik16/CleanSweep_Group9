package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import lombok.Setter;

public class Navigation {

	@Getter
	@Setter
	private boolean isVisited = false;
	@Getter
	@Setter
	private boolean isTrackingCycleComplete = false;
}
