package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BookingPage {

WebDriver driver;
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-testid='title-contact-detail-card']")
	WebElement contact_Title;
	
	@FindBy(xpath = "//div[@data-testid='traveller-0-title-field']")
	WebElement passenger_Title;
	
	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	WebElement contact_FirstName;
	
	@FindBy(xpath = "//input[@data-testid='traveller-0-first-traveller-info-input-box']")
	WebElement passenger_FirstName;
	
	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	WebElement contact_LastName;
	
	@FindBy(xpath = "//input[@data-testid='traveller-0-last-traveller-info-input-box']")
	WebElement passenger_LastName;
	
	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	WebElement contact_MobileNum;
	
	@FindBy(xpath = "//input[@data-testid='sc-member-mobile-number-input-box']")
	WebElement passenger_MobileNum;
	
	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement elementemailId;
	
	@FindBy(xpath = "//div[text()='Country*']/following-sibling::div[1]")
	WebElement elementCountry;
	
	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	WebElement elementCity;
	
	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement continueBtn;
	
	public void contactDetails(String title, String firstName, String lastName, String mobileNum, String emalId, String country, String city){
		
		contact_Title.click();
		driver.findElement(By.xpath("//div[text()='"+title+"']")).click();
		contact_FirstName.sendKeys(firstName);
		contact_LastName.sendKeys(lastName);
		contact_MobileNum.sendKeys(mobileNum);
		elementemailId.sendKeys(emalId);
		if(country.equals("India"))
			elementCity.sendKeys(city);
		else {
			elementCountry.click();
			driver.findElement(By.xpath("//div[text()='"+country+"']")).click();
			elementCity.sendKeys(city);
		}
		
	}
	
public void passengerDetails(String title, String firstName, String lastName, String mobileNum) throws InterruptedException{
		
	passenger_Title.click();
	driver.findElement(By.xpath("//div[text()='"+title+"']")).click();
	passenger_FirstName.sendKeys(firstName);
	passenger_LastName.sendKeys(lastName);
	passenger_MobileNum.sendKeys(mobileNum);
	continueBtn.click();
	Thread.sleep(10000);
	
	}
}
