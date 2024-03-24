package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	private WebDriver driver;
	@FindBy(xpath = "//*[@name='bill[phone]']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//*[@name='bill[address]']")
	private WebElement address;

	@FindBy(xpath = "//*[@name='bill[city]']")
	WebElement cityName;
	@FindBy(xpath = "//*[@name='bill[zip]']")
	WebElement zipCode;

	@FindBy(xpath = "//*[@name='bill[state]']")
	WebElement stateDropDown;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	public void enterBillingInformation(String number)
	{
		phoneNumber.sendKeys(number);
		cityName.sendKeys("Pune");
		address.sendKeys("101 Pune");
		zipCode.sendKeys("411028");
		Select selectRegion = new Select(stateDropDown);
		
		selectRegion.selectByIndex(21);
	}
}
