package test;

import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.SignUpPage;

public class SignUpTest extends ProjectSpecificationMethod{

	
	@Test(priority = 1, dataProvider = "valid_SignUpDetails")
	public void signUp_ValidCredential(String title, String firstName, String lastName, String country, String month, String year, String date, String MobileNum, String emailId, String password, String confirmPassword) throws InterruptedException {
		SignUpPage signUpPageObj = new SignUpPage(driver);
		signUpPageObj.signUp_ValidCred(title, firstName, lastName, country, month, year, date, MobileNum, emailId, password, confirmPassword);
	}
	
	@Test(priority = 2, dataProvider = "invalid_SignUpDetails")
	public void signUp_InValidCredential(String title, String firstName, String lastName, String country, String month, String year, String date, String MobileNum, String emailId, String password, String confirmPassword) throws InterruptedException {
		SignUpPage signUpPageObj = new SignUpPage(driver);
		signUpPageObj.signUp_InValidCred(title, firstName, lastName, country, month, year, date, MobileNum, emailId, password, confirmPassword);
	}
	
}
