package base;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.Utility;

public class ProjectSpecificationMethod extends Utility{
	
	@Parameters({"browser","siteUrl"})
	@BeforeMethod
	//launch the browser 
	public void launchBrowser(String browser, String siteUrl) {
		browserLaunch(browser,siteUrl);
	}
	
	
	@AfterMethod
	//close the browser after each Test
	public void closeBrowser() {
		browserClose();
	}
	
	@DataProvider
	public String[][] valid_SignUpDetails() throws IOException {
		return getExcelData("Valid_SignUpDetails"); //passing the sheet name of the excel to get data
	}
	
	@DataProvider
	public String[][] invalid_SignUpDetails() throws IOException {
		return getExcelData("InValid_SignUpDetails");
	}
	
	@DataProvider
	public String[][] valid_LogInDetails() throws IOException {
		return getExcelData("Valid_LogInDetails"); 
	}
	
	@DataProvider
	public String[][] oneWayDetails() throws IOException {
		return getExcelData("OneWayDetails"); 
	}
	
	@DataProvider
	public String[][] roundTripDetails() throws IOException {
		return getExcelData("RoundTripDetails"); 
	}
	
	@DataProvider
	public String[][] selectDepartureFlight() throws IOException {
		return getExcelData("SelectDepartureFlight"); 
	}
	
	@DataProvider
	public String[][] selectReturnFlight() throws IOException {
		return getExcelData("SelectReturnFlight"); 
	}
	
	@DataProvider
	public String[][] bookingDetails() throws IOException {
		return getExcelData("BookingDetails"); 
	}
	
	@DataProvider
	public String[][] addOnsDetails() throws IOException {
		return getExcelData("AddOnsDetails"); 
	}
	
	@DataProvider
	public String[][] paymentDetails() throws IOException {
		return getExcelData("PaymentDetails"); 
	}
	
	@DataProvider
	public String[][] checkInDetails() throws IOException {
		return getExcelData("CheckInDetails"); 
	}

	
	@DataProvider
	public String[][] flightStatusDetails() throws IOException {
		return getExcelData("FlightStatusDetails"); 
	}

	
	@DataProvider
	public String[][] manageBookingDetails() throws IOException {
		return getExcelData("ManageBookingDetails"); 
	}

	
}
