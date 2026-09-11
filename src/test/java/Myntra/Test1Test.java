package Myntra;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import myntra.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Test1Test {
	
	WebDriver driver ;
	HomePage hp ;
	
	
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver ();
		  driver.manage().window().maximize();
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		 hp= new  HomePage (driver);
	  }
	
  @Test
  public void f() {
	  
	  hp.webSite();
	  hp.catagery();
	  hp.Search();  
  }
 

  @AfterMethod
  public void afterMethod() {
  }


  @AfterClass
  public void afterClass() {
	 // driver.close();
  }

}
