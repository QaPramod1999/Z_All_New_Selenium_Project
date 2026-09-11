package UtilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microsoft.playwright.Page;

public class UtilClass {
	
	// ScreenShort
		public static String getScreenShot(WebDriver driver , String testName) throws IOException
		{
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
			String currentDate = f.format(date);
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path = testName + ".png" ;
			File dest = new File(path);
			FileHandler.copy(source, dest);
			return path;
		}
		
		public static WebElement expliciteWait(WebDriver driver, WebElement element)		{
		
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
			WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
			return element1;
		}
		
		public static List<WebElement> expliciteWait_List(WebDriver driver, List<WebElement> element)		{
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
			List<WebElement> element1 = wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) element));
			return element1;
		}
		
		
		public static WebElement expliciteWaitAlert(WebDriver driver, Alert element){
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
			WebElement element2 = wait.until(ExpectedConditions.visibilityOf((WebElement) element));
			return element2;
		}
		
		
		public static String getDataFromPropertyFile(String key) throws IOException	{
			
			FileInputStream file = new FileInputStream("configuration\\config.properties");
			Properties prop = new Properties();
			prop.load(file);
			return prop.getProperty(key);
		}

		public static WebElement mousActions( WebDriver driver ,WebElement element) 
		{ 
			Actions act = new Actions(driver);
			WebElement element1 = (WebElement) act.moveToElement(element);
			return element;
		}
		
		public static WebElement javascriptExecutor(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			WebElement element1 = UtilClass.expliciteWait(driver, element); 
			js.executeScript("arguments[0].scrollIntoView(true);", element1); 
			return element1; 
			
		}	
		
		
		
			
} 