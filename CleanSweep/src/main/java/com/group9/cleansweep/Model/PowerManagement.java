package com.group9.cleansweep.Model;

import com.group9.cleansweep.Enum.FloorPlanTypeEnum;
import com.group9.cleansweep.Enum.UnitConsumedEnum;

import lombok.Getter;
import lombok.Setter;

public class PowerManagement {

	@Getter

private final int totalBatteryUnit=250;
	@Getter
	@Setter
private int currentUnitOfCharge;
	
	@Getter
	@Setter
	private UnitConsumedEnum unitConsumedEnum;
	
	@Getter
	@Setter
	private FloorPlan floorPlanType;

}
