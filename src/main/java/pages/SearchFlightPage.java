package pages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFlightPage {

WebDriver driver;
	
	public SearchFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[text()='LOGIN']/parent::div")
	WebElement logIn;
	
	@FindBy(xpath = "//div[@data-testid='round-trip-radio-button']//*[local-name()='circle']")
	WebElement roundTrip_RadioBtn;
	
	@FindBy(xpath = "//div[@data-testid='to-testID-origin']//input")	
	WebElement sourceField;
	
	@FindBy(xpath = "//div[@data-testid='to-testID-destination']//input")	
	WebElement destinationField;
	
	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlight;
	
	@FindBy(xpath = "//div[@data-testid='check-in-horizontal-nav-tabs']")
	WebElement checkInTab;
	
	@FindBy(xpath = "//div[text()='PNR Number / Ticket Number']/parent::div/following-sibling::div//input")
	WebElement pnrNum_or_ticketNum;
	
	@FindBy(xpath = "//div[text()='Email ID / Last Name']/parent::div/following-sibling::div//input")
	WebElement emailId_or_lastName;
	
	@FindBy(xpath = "//div[text()='Search Booking']/parent::div")
	WebElement searchBooking;
	
	@FindBy(xpath = "//div[@data-testid='flight status-horizontal-nav-tabs']")
	WebElement flightStatusTab;
	
	@FindBy(xpath = "//div[text()='Departure Date']/parent::div")
	WebElement departureDateDropDown;
	
	@FindBy(xpath = "//input[@value='Select Origin']")
	WebElement flightStatus_From;
	
	@FindBy(xpath = "//input[@value='Select Destination']")
	WebElement flightStatus_To;
		
	@FindBy(xpath = "//div[text()='Flight No.(optional)']/parent::div/following-sibling::div/input")
	WebElement flightNumber;
	
	@FindBy(xpath = "//div[text()='Search Flights']/parent::div")
	WebElement searchFlightBtn;
	
	@FindBy(xpath = "//div[@data-testid='manage booking-horizontal-nav-tabs']")
	WebElement manageBookingTab;
	
	@FindBy(xpath = "//div[text()='Login to View Upcoming Trips']/parent::div")
	WebElement logInToViewTrips;
	
	@FindBy(xpath = "//div[text()='View Change Assist']/parent::div")
	WebElement viewChangeAssist;
	
	@FindBy(xpath = "//label[text()='PNR']/following-sibling::input")
	WebElement pnrNumber;
	
	@FindBy(xpath = "//label[text()='E-MAIL / LAST NAME']/following-sibling::input")
	WebElement emailId_lastName;
	
	@FindBy(xpath = "//input[contains(@class,'retrieve-btn')]")
	WebElement retrieveBooking;
	
	public void searchFlight_OneWay(String source, String destination, String departureDate, String departureMonth, String departureYear) throws InterruptedException {
		
		sourceField.click();	
		driver.findElement(By.xpath("//div[text()='"+source+"']")).click();

		destinationField.click();		
		driver.findElement(By.xpath("//div[text()='"+destination+"']")).click();

		driver.findElement(By.xpath("//div[text()='"+departureMonth+" ' and text()='"+departureYear+"']/parent::div/following-sibling::div/descendant::div[text()='"+departureDate+"']")).click();
		searchFlight.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Select')]"))));
		
	}
	
	public void searchFlight_RoundTrip(String source, String destination, String departureDate, String departureMonth, String departureYear, String returnDate, String returnMonth, String returnYear) throws InterruptedException {
		
		roundTrip_RadioBtn.click();
		sourceField.click();	
		driver.findElement(By.xpath("//div[text()='"+source+"']")).click();

		destinationField.click();		
		driver.findElement(By.xpath("//div[text()='"+destination+"']")).click();

		driver.findElement(By.xpath("//div[text()='"+departureMonth+" ' and text()='"+departureYear+"']/parent::div/following-sibling::div/descendant::div[text()='"+departureDate+"']")).click();
		driver.findElement(By.xpath("//div[text()='"+returnMonth+" ' and text()='"+returnYear+"']/parent::div/following-sibling::div/descendant::div[text()='"+returnDate+"']")).click();
		
		searchFlight.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Select')]"))));
		
	}
	
	public void webCheckIn(String ticketNum, String emailId) {
		checkInTab.click();
		pnrNum_or_ticketNum.sendKeys(ticketNum);
		emailId_or_lastName.sendKeys(emailId);
		searchBooking.click();
	}
	
	public void flightStatus(String selectDepartureDate, String source, String destination, String flightNum) throws InterruptedException {
		flightStatusTab.click();
		departureDateDropDown.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='"+selectDepartureDate+"']/parent::div")));	
		driver.findElement(By.xpath("//div[text()='"+selectDepartureDate+"']/parent::div")).click();
		flightStatus_From.click();	
		driver.findElement(By.xpath("//div[text()='"+source+"']")).click();	
		driver.findElement(By.xpath("//div[text()='"+destination+"']")).click();		
		flightNumber.sendKeys(flightNum);
		searchFlightBtn.click();
	}
	
	public void view_or_manageBooking(String pnrNum, String emailId, String password) throws InterruptedException {
		manageBookingTab.click();
		pnrNum_or_ticketNum.sendKeys(pnrNum);
		emailId_or_lastName.sendKeys(emailId);
		searchBooking.click();

		logInToViewTrips.click();
		LogInPage logInPageObj = new LogInPage(driver);
		logInPageObj.logInUser(emailId, password);		
		
		manageBookingTab.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[text()='Add Your Itinerary']/parent::div")).click();
		viewChangeAssist.click();
		Thread.sleep(10000);
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String childWindow : windows) {
			if(!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
				pnrNumber.sendKeys(pnrNum);
				emailId_lastName.sendKeys(emailId);
				retrieveBooking.click();
			}
		}
		
	}
}
