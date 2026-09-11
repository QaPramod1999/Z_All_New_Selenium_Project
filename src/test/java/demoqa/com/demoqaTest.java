package demoqa.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoqaTest {
	
	WebDriver driver ;
	Foram fo ;
	
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver ();
		  driver.manage().window().maximize();
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  
		  fo = new Foram(driver);

	  }
	
	  @Test(priority=1 )
	  public void Test() throws InterruptedException {
		   fo.webSite();
		   fo.fn();
		   fo.gn();
		   fo.Sub();
		   fo.dob();
		   
	
	  }
	 
	
	  @AfterMethod
	  public void afterMethod() {
		  
	  }
	
	
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
