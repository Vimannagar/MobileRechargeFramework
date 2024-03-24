package testclasses;

import java.io.IOException;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;
import utility.ReadPropData;

public class CheckOutTest extends TestNGListeners{
	
	@Test(priority = 4)
	public void checkoutOrder() throws IOException, InterruptedException
	{	
		test.info("entering the billing information");
		
		ReadPropData data = new ReadPropData();
		
		String phone= data.getPropData("phonenumber");
		
		
		checkout.enterBillingInformation(phone);
	
	}

}
