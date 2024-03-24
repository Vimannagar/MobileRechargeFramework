package pompage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	@FindBy(xpath = "//*[@id='username']")
	WebElement username;

//	If we want to locate both the locator over the webpage and then we want to perform the operation then we have to use @FindBys
	@FindBy(xpath = "//*[@id='login-register-menu-btn']")
	private WebElement loginLink;

	@FindBy(xpath = "//*[@type='email']")
	private WebElement email;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//*[@type='submit' and @value = 'submit']")
	WebElement loginButton;

//	If we want to locate either of the locator over webpage then we can use @FindAll
//	@FindAll({ @FindBy(xpath = "//*[@id='login']"), @FindBy(xpath = "//*[@id='login123']") })
//	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void enterCredentials(String email) throws InterruptedException {
		loginLink.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		username.sendKeys(email);

		password.sendKeys("Test@1234");
	}

	public void clickOnLogin() {
		loginButton.click();
	}

	public String getTitleOfPage() {
		String titleOfPage = driver.getTitle();

		return titleOfPage;
	}

}
