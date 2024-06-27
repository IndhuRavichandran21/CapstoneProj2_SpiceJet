package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Utility {

	public static WebDriver driver;
	public String [][]data; 
	
	public void browserLaunch(String browser ,String siteUrl) {
		
		//launch the browser based on the parameter passed
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		    	
		if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		if(browser.equals("headless")) {		 
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");			
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);		
		}
		
		driver.get(siteUrl); //launch the url
		Assert.assertEquals(driver.getTitle(), "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void browserClose() {
		driver.quit();
	}
	
	//fetch data from excel
	public String[][] getExcelData(String sheetName) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\capstoneProj2\\data\\SpiceJetData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet workSheet = workBook.getSheet(sheetName);
		XSSFRow row;
		XSSFCell column;
		int rowCount = workSheet.getLastRowNum();
		int columnCount= workSheet.getRow(0).getLastCellNum();
		data = new String[rowCount][columnCount];
		
		for(int i=0; i<rowCount; i++) {		
			row = workSheet.getRow(i+1);
			
			for(int j=0; j<columnCount; j++) {						
			   
			 column = row.getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK); 
			 if(column.getCellType() == CellType.NUMERIC) {
				 int number = (int)column.getNumericCellValue(); //converting double to int to truncate decimal value eg:19.0
				 data[i][j] = String.valueOf(number);
			 }
			 
			 if(column.getCellType() == CellType.BLANK)
					data[i][j] = column.getStringCellValue();
				   
			 if(column.getCellType() == CellType.STRING)
				data[i][j] = column.getStringCellValue();				
			}
		}
		workBook.close();
		return data;
	}
	
	public String takeScreenshot(String screenshotName) throws IOException {
		String screenshotPath = "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\capstoneProj2\\screenshot\\"+screenshotName+".jpg";
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotPath);
		FileUtils.copyFile(source, destination);
		return screenshotPath;
		
	}
}
