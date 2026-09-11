package demoqa.com;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;

public class dynamicpropertiesTest {
	
	WebDriver driver ;
	
	dynamicproperties dp ;
	
	
	



	@BeforeClass
	  public void beforeClass() {
		  
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();	
		  driver.manage().window().maximize();
	  }

	  
	  @BeforeMethod
	  public void beforeMethod() {
		  dp = new dynamicproperties(driver );
	  }
	
	  @Test
	  public void f() {
		  dp.website();
		  dp.dynamic();
	  }
	  
	  
	  @AfterMethod
	  public void afterMethod() {
	  }
	
	
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
