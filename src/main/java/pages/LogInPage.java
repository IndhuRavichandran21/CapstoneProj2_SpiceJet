package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInPage {
	
	WebDriver driver;
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement logInBtn;
	
	@FindBy(xpath = "//div[text()='Email']/parent::div/preceding-sibling::div//*[local-name()='svg']/*[local-name()='circle']")
	WebElement emailIdRadioBtn;
	
	@FindBy(xpath = "//input[@data-testid='user-mobileno-input-box']")
	WebElement emailIdField;
	
	@FindBy(xpath = "//input[@data-testid='password-input-box-cta']")
	WebElement passwordField;
	
	@FindBy(xpath = "//div[text()='LOGIN']/parent::div")
	WebElement logIn;

	public void logInUser(String emailId, String password) {
		logInBtn.click();
		emailIdRadioBtn.click();
		emailIdField.sendKeys(emailId);
		passwordField.sendKeys(password);
		logIn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='LOGIN']/parent::div")));
		
	}
}
