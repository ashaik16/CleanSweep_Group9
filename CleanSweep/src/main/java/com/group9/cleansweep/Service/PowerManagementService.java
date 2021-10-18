package com.group9.cleansweep.Service;

import com.group9.cleansweep.Model.PowerManagement;

public class PowerManagementService {
	private  final double minimumCapacityForPowerUnit=50.0;
	public float getUnitOfCharge(String floorPlanType) {
		
		PowerManagement powerManagement = new PowerManagement();
		float unitOfCharge = powerManagement.getUnitConsumedEnum().valueOf(floorPlanType).getUnitsConsumedPerFloorType();
		System.out.println("UnitOfCharge: "+unitOfCharge);
		return unitOfCharge;
	}

	public float getAverageUnitOfCharge(String currentFloorPlanType, String previousFloorPlanType) {

		PowerManagement powerManagement = new PowerManagement();

		float previousUnitOfCharge = powerManagement.getUnitConsumedEnum().valueOf(previousFloorPlanType)
				.getUnitsConsumedPerFloorType();

		float currentUnitOfCharge = powerManagement.getUnitConsumedEnum().valueOf(currentFloorPlanType)
				.getUnitsConsumedPerFloorType();

		float avgUnitOfCharge = (previousUnitOfCharge + currentUnitOfCharge) / 2;

		System.out.println("Average Unit Of Charge: " + avgUnitOfCharge);
		return avgUnitOfCharge;

	}
	
	public void checkUnitOfPower(double currentPowerUnit)
	{
		if(currentPowerUnit<minimumCapacityForPowerUnit)
		{
			StatusCheckService statusCheck=new StatusCheckService();
			statusCheck.getStatus("Reached Minimum Capacity Of Power");
			
		}
	}
}
