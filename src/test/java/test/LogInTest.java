package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.LogInPage;

public class LogInTest extends ProjectSpecificationMethod{

	@Test(dataProvider = "valid_LogInDetails")
	public void login_ValidCred(String emailId, String password) {
		
		LogInPage logInPageObj = new LogInPage(driver);
		logInPageObj.logInUser(emailId, password);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Welcome aboard']")).getText(), "Welcome aboard");
	}
}
