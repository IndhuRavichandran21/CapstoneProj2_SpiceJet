package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectFlightPage {

WebDriver driver;
	
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement continueBtn;
	
	public void selectDepartureFlight(String departureFlightNumber, String departureFlightFare) throws InterruptedException {
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Select')]")).isDisplayed());
		Thread.sleep(20000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//div[text()='"+departureFlightNumber+"']")));
		driver.findElement(By.xpath("//div[text()='"+departureFlightNumber+"']/parent::div/parent::div/parent::div/following-sibling::div//div[@data-testid='"+departureFlightFare.toLowerCase()+"-flight-select-radio-button-2']//*[local-name()='circle']")).click();		
		Thread.sleep(5000);
		continueBtn.click();
		Thread.sleep(10000);	
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Contact Details']")).isDisplayed());
	}
	
    public void selectDepartureAndReturnFlight(String departureFlightNumber, String departureFlightFare, String returnFlightNumber, String returnFlightFare) throws InterruptedException {
    	
    	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Select')]")).isDisplayed());
		Thread.sleep(10000);		
		driver.findElement(By.xpath("//div[text()='"+departureFlightNumber+"']/parent::div/parent::div/parent::div/following-sibling::div//div[@data-testid='"+departureFlightFare.toLowerCase()+"-flight-select-radio-button-2']//*[local-name()='circle']")).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='"+returnFlightNumber+"']/parent::div/parent::div/parent::div/following-sibling::div//div[@data-testid='"+returnFlightFare.toLowerCase()+"-flight-select-radio-button-1']//*[local-name()='circle']"))));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[text()='"+returnFlightNumber+"']")));
		Thread.sleep(10000);	
		driver.findElement(By.xpath("//div[text()='"+returnFlightNumber+"']/parent::div/parent::div/parent::div/following-sibling::div//div[@data-testid='"+returnFlightFare.toLowerCase()+"-flight-select-radio-button-1']//*[local-name()='circle']")).click();
		Thread.sleep(10000);	
		continueBtn.click();
		Thread.sleep(10000);	
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Contact Details']")).isDisplayed());
	}
	
	
}
