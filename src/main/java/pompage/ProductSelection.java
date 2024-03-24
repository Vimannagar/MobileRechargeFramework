package pompage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSelection {
	WebDriver driver;
	private	By firstname  = By.xpath("//*[@id='product-mr-mainlink']");
	
	@FindBy(xpath = "//*[@id='product-mr-mainlink']")
	private	WebElement mobileRechargeLink;
	
//	@FindBy(xpath = "//*[@id='firstName']")
//	WebElement firstname;
	
	@FindBy(xpath = "//*[@id='country']")
	private WebElement country;
		
	@FindBy(xpath = "(//*[@id='operator-content']//div)[1]")
	private	WebElement selectOperator;
	
	@FindBy(xpath = "//*[@data-country='Airtel Plan']")
	private WebElement planType;
	
	@FindBy(xpath = "//*[@id='phone_number']")
	private	WebElement phonenumber;
	
	@FindBy(xpath = "//*[@id='userPassword']")
	private	WebElement password;
	
	@FindBy(xpath = "//form//select")
	private	WebElement occupationDropdown;
	
	@FindBy(xpath = "//*[@value='Male']")
	private	WebElement radioButton;
	
	@FindBy(xpath = "//*[@id='confirmPassword']")
	private	WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@type='checkbox']")
	private	WebElement checkbox;
	
	@FindBy(xpath = "//*[@id='login']")
	private	WebElement registerfinalButton;
	
	
	@FindBy(xpath = "//*[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//*[@id='submit-holder']//a")
	WebElement rechargeButton;
	
	@FindBy(xpath = "//*[@id='phone_number']")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//*[@value='359']")
	WebElement planDetails;
	
	@FindBy(xpath = "//*[@id='buy-button-mr']")
	WebElement rechargeButtonFinal;
	
	WebDriverWait wait;
	
	public ProductSelection(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	
	
	public void navigatingToMobile()
	{
		mobileRechargeLink.click();
//		
		
	}
	
	public void selectCountry()
	{
		Select selectCountry = new Select(country);
		selectCountry.selectByValue("IN");
	}
	
	public void selectOperator()
	{
		wait.until(ExpectedConditions.visibilityOf(selectOperator));
		selectOperator.click();
		wait.until(ExpectedConditions.visibilityOf(planType));
		planType.click();
		rechargeButton.click();
	}
	
	public void enterNumber()
	{
		wait.until(ExpectedConditions.visibilityOf(phonenumber));
		
		phonenumber.sendKeys("8176867662");
		
		
	}
	
	public void selectPlan() throws InterruptedException
	{
	
		wait.until(ExpectedConditions.elementToBeClickable(planDetails));
		planDetails.click();
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		
		
		act.scrollToElement(rechargeButtonFinal).perform();
		wait.until(ExpectedConditions.elementToBeClickable(rechargeButtonFinal));
		rechargeButtonFinal.click();
	}
	
	
	
	
	
	
	
}
