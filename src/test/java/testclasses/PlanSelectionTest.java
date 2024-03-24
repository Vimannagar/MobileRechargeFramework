package testclasses;

import java.io.IOException;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;
import utility.ReadPropData;
import utility.TimeValueGenerator;

public class PlanSelectionTest extends TestNGListeners {
	
	@Test(priority = 3)
	public void selectOperator() throws IOException, InterruptedException
	{
		test.info("Clicking on register");
		register.navigatingToMobile();
		test.info("entering the details of user");
		register.selectCountry();
		register.selectOperator();
		register.enterNumber();
		register.selectPlan();
	}
	
	

	
	
}
