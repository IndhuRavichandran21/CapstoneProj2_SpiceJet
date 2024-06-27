package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AddOnsPage;
import pages.BookingPage;
import pages.LogInPage;
import pages.PrePaymentPage;
import pages.SearchFlightPage;
import pages.SelectFlightPage;

public class PrePaymentTest extends ProjectSpecificationMethod{

	@Test(priority = 1, dataProvider = "paymentDetails")
	public void selectPaymentMethods(String emailId, String password, String source, String destination, 
			String departureDate, String departureMonth, String departureYear, String departureFlightNumber, String departureFlightFare,
			String title, String firstName, String lastName, String mobileNum, String emalId, String country, String city, String seatNum, String meal,
			String cardNumber, String cardHolderName, String exp_Month, String exp_Year, String cvv) throws InterruptedException {
				
		LogInPage logInPageObj = new LogInPage(driver);
		SearchFlightPage searchFlightPageObj = new SearchFlightPage(driver);
		SelectFlightPage selectFlightPageObj = new SelectFlightPage(driver);
		BookingPage bookingPageObj = new BookingPage(driver);
		AddOnsPage addOnsPageObj = new AddOnsPage(driver);
		PrePaymentPage prePaymentPageObj =new PrePaymentPage(driver);
		
		logInPageObj.logInUser(emailId, password);
		searchFlightPageObj.searchFlight_OneWay(source, destination, departureDate, departureMonth, departureYear);	
		selectFlightPageObj.selectDepartureFlight(departureFlightNumber, departureFlightFare);				
		bookingPageObj.contactDetails(title, firstName, lastName, mobileNum, emalId, country,  city);
		bookingPageObj.passengerDetails(title, firstName, lastName, mobileNum);
		addOnsPageObj.seatSelection(seatNum);
		addOnsPageObj.mealSelection(meal);
		prePaymentPageObj.enterCredit_DebitCardDetails(cardNumber, cardHolderName, exp_Month, exp_Year, cvv);
	}
}
