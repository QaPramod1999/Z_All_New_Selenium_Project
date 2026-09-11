package www.redbus.in;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testa {
	
	@Test
	public void test() {
		
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver  = new ChromeDriver ();
		driver.get("https://www.redbus.in/");

	}

}
