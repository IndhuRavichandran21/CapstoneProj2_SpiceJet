package pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[text()='Signup']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//label[text()='Title']/following-sibling::select")
	WebElement titleDropdown;
	
	@FindBy(id="first_name")
	WebElement elementFirstName;
	
	@FindBy(id="last_name")
	WebElement elementLastName;
	
	@FindBy(xpath="//label[contains(text(),'Country')]/following-sibling::select")
	WebElement countryDropdown;
	
	@FindBy(xpath="//label[text()='Mobile Number']/following-sibling::div//input[@class=' form-control']")
	WebElement elementMobileNum;
	
	@FindBy(id="email_id")
	WebElement elementEmailId;
	
	@FindBy(id="new-password")
	WebElement elementPassword;
	
	@FindBy(id="c-password")
	WebElement elementConfirmPassword;
	
	@FindBy(id="defaultCheck1")
	WebElement checkbox;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//img[contains(@class,'datepicker')]")
	WebElement datePicker;
	
	@FindBy(css=".react-datepicker__month-select")
	WebElement monthDropDown;
	
	@FindBy(css=".react-datepicker__year-select")
	WebElement yearDropDown;
	
	@FindBy(xpath="//label[text()='OTP Verification']")
	WebElement otpDialogBox;
	
	@FindBy(xpath="//div[contains(@class,'btn-close')]")
	WebElement closeBtn;
	
	public void signUp_ValidCred(String title, String firstName, String lastName, String country, String month, String year, String date, String MobileNum, String emailId, String password, String confirmPassword) throws InterruptedException {
		
		signUpBtn.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		for(String childWindow : childWindows) {
			
			if(!childWindow.equals(parentWindow))
			{
			driver.switchTo().window(childWindow);			
			Select selectTitle = new Select(titleDropdown);
			selectTitle.selectByVisibleText(title);
			elementFirstName.sendKeys(firstName);
			elementLastName.sendKeys(lastName);
			
			Select selectCountry = new Select(countryDropdown);
			selectCountry.selectByVisibleText(country);
			
            datePicker.click();			
            
            driver.findElement(By.cssSelector(".react-datepicker__month-select")).isEnabled();
			Select selectMonth = new Select(monthDropDown);
			selectMonth.selectByVisibleText(month);		
			Select selectYear = new Select(yearDropDown);
			selectYear.selectByVisibleText(year);
			driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day')and text()='"+date+"' and not(contains(@class,'react-datepicker__day--outside-month'))]")).click();
			 
			elementMobileNum.sendKeys(MobileNum);
			Thread.sleep(3000);
			elementEmailId.click();
			Thread.sleep(3000);
			elementEmailId.click();			
			elementEmailId.sendKeys(emailId);
			Thread.sleep(3000);
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", elementPassword);
			Thread.sleep(3000);
			elementPassword.click();
			Thread.sleep(3000);
			elementPassword.click();
			elementPassword.sendKeys(password);
			elementConfirmPassword.sendKeys(confirmPassword);	
			js.executeScript("arguments[0].scrollIntoView(true)", checkbox);
			checkbox.click();
			submitBtn.click();
			if(otpDialogBox.isDisplayed())
			{
				System.out.println("Dialog Box to enter OTP is displayed");
				closeBtn.click();			
			}
			else
				System.out.println("Dialog Box to enter OTP is not displayed");
			}
		}
		
	}
	
public void signUp_InValidCred(String title, String firstName, String lastName, String country, String month, String year, String date, String MobileNum, String emailId, String password, String confirmPassword) throws InterruptedException {
		
		signUpBtn.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		for(String childWindow : childWindows) {
			
			if(!childWindow.equals(parentWindow))
			{
			driver.switchTo().window(childWindow);			
			Select selectTitle = new Select(titleDropdown);
			selectTitle.selectByVisibleText(title);
			elementFirstName.sendKeys(firstName);
			elementLastName.sendKeys(lastName);
			
			Select selectCountry = new Select(countryDropdown);
			selectCountry.selectByVisibleText(country);
			
            datePicker.click();			
            
            driver.findElement(By.cssSelector(".react-datepicker__month-select")).isEnabled();
			Select selectMonth = new Select(monthDropDown);
			selectMonth.selectByVisibleText(month);		
			Select selectYear = new Select(yearDropDown);
			selectYear.selectByVisibleText(year);
			driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day')and text()='"+date+"' and not(contains(@class,'react-datepicker__day--outside-month'))]")).click();
			 
			elementMobileNum.sendKeys(MobileNum);
			Thread.sleep(3000);
			elementEmailId.click();
			Thread.sleep(3000);
			elementEmailId.click();			
			elementEmailId.sendKeys(emailId);
			Thread.sleep(3000);
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", elementPassword);
			Thread.sleep(3000);
			elementPassword.click();
			Thread.sleep(3000);
			elementPassword.click();
			elementPassword.sendKeys(password);
			elementConfirmPassword.sendKeys(confirmPassword);	
			js.executeScript("arguments[0].scrollIntoView(true)", checkbox);
			checkbox.click();
			submitBtn.click();
			try {	
				if(driver.findElement(By.xpath(" //div[contains(text(),'Please fill all mandatory fields')]")).isDisplayed())
					throw new IllegalArgumentException("Please fill the mandatory fields");
			}	
			catch(Exception e){
				System.out.println(e);
			}
			}
		}
}
}