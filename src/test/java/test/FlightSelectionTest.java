package test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.SearchFlightPage;
import pages.SelectFlightPage;

public class FlightSelectionTest extends ProjectSpecificationMethod{
	
	@Test(priority = 1, dataProvider = "selectDepartureFlight")
	public void flightSelection_OneWayBooking(String emailId, String password, String source, String destination, 
			 String departureDate, String departureMonth, String departureYear, String departureFlightNumber, String departureFlightFare) throws InterruptedException {
				
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		SelectFlightPage selectFlightPageObj = new SelectFlightPage(driver);
		
		searchFlightPageObj.searchFlight_OneWay(source, destination,  departureDate, departureMonth, departureYear);	
		selectFlightPageObj.selectDepartureFlight(departureFlightNumber, departureFlightFare);				
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Contact Details']")).isDisplayed());
	}
	
	@Test(priority = 2, dataProvider = "selectReturnFlight")
		public void flightSelection_RoundTripBooking(String emailId, String password, String source, String destination, 
				String departureDate, String departureMonth, String departureYear, String returnDate, String returnMonth, String returnYear, 
				String departureFlightNumber, String departureFlightFare, String returnFlightNumber, String returnFlightFare) throws InterruptedException {
			
			//LogInPage logInPageObj = new LogInPage(driver);
			SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);	
			SelectFlightPage selectFlightPageObj = new SelectFlightPage(driver);
			
			//logInPageObj.logInUser(emailId, password);		
			searchFlightPageObj.searchFlight_RoundTrip(source, destination, departureDate, departureMonth, departureYear, returnDate, returnMonth, returnYear);	
			selectFlightPageObj.selectDepartureAndReturnFlight(departureFlightNumber, departureFlightFare, returnFlightNumber, returnFlightFare);		
			
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Contact Details']"))));
			Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Contact Details']")).isDisplayed());
		}
}
