package redbus.in;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import www.redbus.in.Hotel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Hoteltest {
	WebDriver driver ;
	
	Hotel ho ;
	
	
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		   
		  driver.manage().window().maximize();
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  ho = new Hotel(driver );
	  }

	  
	  
	  @Test
	  public void f() throws InterruptedException {
		  ho.website();
		//  ho.search();
		  ho.d1();

	  }
	 
	  @AfterMethod
	  public void afterMethod() {
	  }
	
	
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
