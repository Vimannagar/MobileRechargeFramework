package testclasses;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class TravelSimTest extends TestNGListeners {
	
	
	@Test
	public void buySim()
	{
		buySim.selectCountry();
		buySim.selectPlan();
		buySim.buyNow();
	}

}
