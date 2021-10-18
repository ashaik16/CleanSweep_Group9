package com.group9.cleansweep.controlsystem;

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



	private  final double minimumCapacityForPowerUnit=50.0;
	public float getUnitOfCharge(String floorPlanType) {
		
	
		float unitOfCharge = unitConsumedEnum.valueOf(floorPlanType).getUnitsConsumedPerFloorType();
		System.out.println("UnitOfCharge: "+unitOfCharge);
		return unitOfCharge;
	}

	public float getAverageUnitOfCharge(String currentFloorPlanType, String previousFloorPlanType) {

		

		float previousUnitOfCharge = unitConsumedEnum.valueOf(previousFloorPlanType)
				.getUnitsConsumedPerFloorType();

		float currentUnitOfCharge = unitConsumedEnum.valueOf(currentFloorPlanType)
				.getUnitsConsumedPerFloorType();

		float avgUnitOfCharge = (previousUnitOfCharge + currentUnitOfCharge) / 2;

		System.out.println("Average Unit Of Charge: " + avgUnitOfCharge);
		return avgUnitOfCharge;

	}
	
	public void checkUnitOfPower(double currentPowerUnit)
	{
		if(currentPowerUnit<minimumCapacityForPowerUnit)
		{
			StatusCheck statusCheck=new StatusCheck();
			statusCheck.getStatus("Reached Minimum Capacity Of Power");
			
		}
	}
}
