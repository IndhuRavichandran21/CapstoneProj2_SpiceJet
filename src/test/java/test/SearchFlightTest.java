package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.SearchFlightPage;

public class SearchFlightTest extends ProjectSpecificationMethod{

	@Test(priority = 1, dataProvider = "oneWayDetails")
	public void oneWayBooking(String emailId, String password, String source, String destination, String departureDate, String departureMonth, String departureYear) throws InterruptedException {
		
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		//LogInPage logInPageObj = new LogInPage(driver);
		
		//logInPageObj.logInUser(emailId, password);		
		searchFlightPageObj.searchFlight_OneWay(source, destination, departureDate, departureMonth, departureYear);
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Select')]")).isDisplayed());
	}
	
	@Test(priority =2, dataProvider = "roundTripDetails")
	public void roundTripBooking(String emailId, String password, String source, String destination, String departureDate, String departureMonth, String departureYear, String returnDate, String returnMonth, String returnYear) throws InterruptedException {
		
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		//LogInPage logInPageObj = new LogInPage(driver);
		
		//logInPageObj.logInUser(emailId, password);		
		searchFlightPageObj.searchFlight_RoundTrip(source, destination, departureDate, departureMonth, departureYear, returnDate, returnMonth, returnYear);
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Select')]")).isDisplayed());
	}
	
	@Test(priority =3, dataProvider = "checkInDetails")
	public void performWebCheckIn(String ticketNum, String emailId) {
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		searchFlightPageObj.webCheckIn(ticketNum, emailId);	
	}
	
	@Test(priority =4, dataProvider = "flightStatusDetails")
	public void checkFlightStatus(String selectDepartureDate, String source, String destination, String flightNum) throws InterruptedException {
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		searchFlightPageObj.flightStatus(selectDepartureDate, source, destination, flightNum);		
	}
	
	@Test(priority =5, dataProvider = "manageBookingDetails")
	public void manageBooking(String pnrNum, String emailId, String password) throws InterruptedException {
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		searchFlightPageObj.view_or_manageBooking(pnrNum, emailId, password);	
	}
}
