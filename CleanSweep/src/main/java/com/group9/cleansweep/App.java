package com.group9.cleansweep;

import com.group9.cleansweep.controlsystem.PowerManagement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Miami!" );
        System.out.println("Lou was here.");
        
        PowerManagement powerManagementService= new PowerManagement();
        String currentfloorPlanType="LOW_PILE_CARPET";
        String previousfloorPlanType="BARE_FOOT";
        powerManagementService.getUnitOfCharge(currentfloorPlanType);
        powerManagementService.getAverageUnitOfCharge(currentfloorPlanType,previousfloorPlanType);
    	
        powerManagementService.checkUnitOfPower(100.0);
    }
}
