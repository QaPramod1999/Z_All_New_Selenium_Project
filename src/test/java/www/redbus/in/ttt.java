package www.redbus.in;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import myntra.HomePage;

public class ttt {
	WebDriver driver ;
	bustickets hp ;
	
	
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver ();
		  driver.manage().window().maximize();
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		 hp= new  bustickets (driver);
	  }
		
	  @Test
	  public void f() throws InterruptedException {
		  
		  hp.website();
		  hp.from1("Pune", "Shivaji Nagar, Pune");
		  hp.TO11("Mumbai", "Andheri East, Mumbai" );
		  hp.date();
		  hp.Search();
		
	  }
	 
	
	  @AfterMethod
	  public void afterMethod() {
	  }
	
	
	  @AfterClass
	  public void afterClass() {
		 driver.close();
	  }

}
