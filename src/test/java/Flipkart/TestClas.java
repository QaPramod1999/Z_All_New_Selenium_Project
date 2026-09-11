package Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClas {
	
	Flipkart f ;
	 WebDriver driver ;
	
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver ();
		  driver.manage().window().maximize();
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		 f= new  Flipkart(driver);
	  }
	
@Test
public void f() throws InterruptedException {
	  f.Website();
	  f.search();
	  f.Filtter();
	  f.Product();
}


@AfterMethod
public void afterMethod() {
	
}


@AfterClass
public void afterClass() {
	  driver.close();
}


}
