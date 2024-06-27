package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.BookingPage;
import pages.SearchFlightPage;
import pages.SelectFlightPage;


public class BookingTest extends ProjectSpecificationMethod{
	
	@Test(priority = 1, dataProvider = "bookingDetails")
	public void bookingDetails(String emailId, String password, String source, String destination, 
			String departureDate, String departureMonth, String departureYear, String departureFlightNumber, String departureFlightFare,
			String title, String firstName, String lastName, String mobileNum, String emalId, String country, String city) throws InterruptedException {
				
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		SelectFlightPage selectFlightPageObj = new SelectFlightPage(driver);
		BookingPage bookingPageObj = new BookingPage(driver);
		
		searchFlightPageObj.searchFlight_OneWay(source, destination, departureDate, departureMonth, departureYear);	
		selectFlightPageObj.selectDepartureFlight(departureFlightNumber, departureFlightFare);				
		//Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Contact Details']")).isDisplayed());
		bookingPageObj.contactDetails(title, firstName, lastName, mobileNum, emalId, country,  city);
		bookingPageObj.passengerDetails(title, firstName, lastName, mobileNum);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='SEAT SELECTION']")).getText(), "SEAT SELECTION");
	}

}
