package demoqa.com;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	WebDriver driver ;
	from2 f2 ;
	
	 @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  
	  }
	
	  @BeforeMethod
	  public void beforeMethod() {
		  f2 = new from2(driver);
	  }

	
  @Test
  public void f() throws InterruptedException {
	  f2.website();
	  f2.fn();
	  f2.LN();
	  f2.gmail();
	  f2.MOB();
	  f2.Date();
  }

  @AfterMethod
  public void afterMethod() {
  }

 

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
