package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PrePaymentPage {

WebDriver driver;
	
	public PrePaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "card_number")
	WebElement element_cardNumber;
	
	@FindBy(id = "name_on_card")
	WebElement element_cardHolderName;
	
	@FindBy(id = "card_exp_month")
	WebElement card_expiry_month;
	
	@FindBy(id = "card_exp_year")
	WebElement card_expiry_year;
	
	@FindBy(id = "security_code")
	WebElement element_CVV;
	
	@FindBy(xpath = "//div[@data-testid='common-proceed-to-pay']")
	WebElement proceedToPay;
	
	public void enterCredit_DebitCardDetails(String cardNumber, String cardHolderName, String exp_Month, String exp_Year, String cvv) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h3[text()='Enter Debit / Credit Card Details']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='card_number_iframe']")));
		element_cardNumber.sendKeys(cardNumber);	
		driver.switchTo().defaultContent();	
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='name_on_card_iframe']")));
		element_cardHolderName.sendKeys(cardHolderName);	
		driver.switchTo().defaultContent();
	    Thread.sleep(20000);
		int popUpSize = driver.findElements(By.xpath("//div[@id='at_prepayment_close_icon']//img")).size();
		if(popUpSize==1)
		  driver.findElement(By.xpath("//div[@id='at_prepayment_close_icon']//img")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='card_exp_month_iframe']")));
		card_expiry_month.sendKeys(exp_Month);	
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='card_exp_year_iframe']")));
		card_expiry_year.sendKeys(exp_Year);	
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='security_code_iframe']")));
		element_CVV.sendKeys(cvv);		
		driver.switchTo().defaultContent();
		proceedToPay.click();
		Assert.assertFalse(driver.getCurrentUrl().equals("https://www.spicejet.com/booking/prepayment"), "url should not remain same");
		
	}

}
