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

public class AddOnsPage {

WebDriver driver;
	
	public AddOnsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Skip']")
	WebElement skipBtn;
	
	@FindBy(xpath = "//div[text()='Select Meals']/parent::div")
	WebElement selectMealBtn;
	
	@FindBy(xpath = "//div[text()='Done']/parent::div")
	WebElement doneBtn;
	
	@FindBy(xpath = "//div[@data-testid='add-ons-continue-footer-button'][3]")
	WebElement continueToPaymentPage;
	
	@FindBy(xpath = "//div[text()='Payment Methods']")
	WebElement text_PaymentMethod;
	
	public void seatSelection(String seatNum) throws InterruptedException {
		Thread.sleep(20000);
		WebElement selectSeat = driver.findElement(By.xpath("//div[text()='"+seatNum+"']/preceding-sibling::*[local-name()='svg']/parent::div"));
		Actions actions = new Actions(driver);
		actions.moveToElement(selectSeat).build().perform();	
		selectSeat.click();
		if(skipBtn.isDisplayed())
		skipBtn.click();
	}
	
	public void mealSelection(String meal) throws InterruptedException {
		selectMealBtn.click();
		driver.findElement(By.xpath("//div[text()='"+meal+"']")).click();
		doneBtn.click();
		Thread.sleep(20000);
		if(driver.findElement(By.xpath("//div[@class='at_addon_close']/img")).isDisplayed())
			driver.findElement(By.xpath("//div[@class='at_addon_close']/img")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", continueToPaymentPage);		
		continueToPaymentPage.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(text_PaymentMethod,"Payment Methods")));
	}
}
