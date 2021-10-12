package Model;

import lombok.Getter;
import lombok.Setter;

public class Navigation {

	@Getter
	@Setter
	private boolean isVistied = false;
	@Getter
	@Setter
	private boolean isTrackingCycleComplete = false;
}
