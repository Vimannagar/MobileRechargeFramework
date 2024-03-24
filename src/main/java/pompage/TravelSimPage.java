package pompage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelSimPage {
	private WebDriver driver;
	public WebDriverWait wait;
	@FindBy(xpath = "//*[@id='product-travel_sim-mainlink']")
	WebElement navToEsim;
	
	
	@FindBy(xpath = "//*[@type='submit' and text()='Buy Now']")
	WebElement buyNowButton;
	
	@FindBy(xpath = "//*[@name='country']")
	WebElement countryDropdown;
	
	
			
	@FindBy(xpath = "(//*[@id='region_products']//span[@class='top_part'])[1]")
	WebElement selectPlan;	
	
	@FindBy(xpath = "(//*[@type='submit'])[1]")
	WebElement buyNowButtonFinal;
	
	public TravelSimPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public void selectCountry()
	{
		wait.until(ExpectedConditions.visibilityOf(navToEsim));
		navToEsim.click();
		Select selectCountry = new Select(countryDropdown);
		
		selectCountry.selectByVisibleText("United States");
		
		buyNowButton.click();
	}
	
	public void selectPlan()
	{
		selectPlan.click();
	}
	
	public void buyNow()
	{
		wait.until(ExpectedConditions.elementToBeClickable(buyNowButtonFinal));
		buyNowButtonFinal.click();
	}

}
