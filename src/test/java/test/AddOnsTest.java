package test;

import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.AddOnsPage;
import pages.BookingPage;
import pages.SearchFlightPage;
import pages.SelectFlightPage;

public class AddOnsTest extends ProjectSpecificationMethod{

	@Test(priority = 1, dataProvider = "addOnsDetails")
	public void bookingDetails(String emailId, String password, String source, String destination, 
			String departureDate, String departureMonth, String departureYear, String departureFlightNumber, String departureFlightFare,
			String title, String firstName, String lastName, String mobileNum, String emalId, String country, String city, String seatNum, String meal) throws InterruptedException {
				
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		SelectFlightPage selectFlightPageObj = new SelectFlightPage(driver);
		BookingPage bookingPageObj = new BookingPage(driver);
		AddOnsPage addOnsPageObj = new AddOnsPage(driver);
		
		searchFlightPageObj.searchFlight_OneWay(source, destination, departureDate, departureMonth, departureYear);	
		selectFlightPageObj.selectDepartureFlight(departureFlightNumber, departureFlightFare);				
		bookingPageObj.contactDetails(title, firstName, lastName, mobileNum, emalId, country,  city);
		bookingPageObj.passengerDetails(title, firstName, lastName, mobileNum);
		addOnsPageObj.seatSelection(seatNum);
		addOnsPageObj.mealSelection(meal);
	}
}
