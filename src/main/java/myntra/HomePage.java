package myntra;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver ;
	
	@FindBy (xpath ="HomePage") private WebElement search ;
	@FindBy (xpath = "//div[@class='desktop-navContent']") private List <WebElement> cata ;
	@FindBy (xpath = "//input[@placeholder='Search for products, brands and more']") private WebElement Search ;
	
	public HomePage (WebDriver driver ) {
		PageFactory.initElements(driver, this );
		
		this.driver = driver ;
		
	}
	
	public void webSite () {
		
		driver.get("https://www.myntra.com/");
		
	}
	
	public void catagery () {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2));
		List<WebElement> element1 = wait.until(ExpectedConditions.visibilityOfAllElements(cata));
		int n = element1.size();
		System.out.println(n);
		
		String Exp = "MEN";
		
		for (int i = 0 ; i<= n; i++ ) {
			
			String str = element1.get(i).getText().replace("*", " ").trim();
			System.out.println(str);
		if 	(Exp.equalsIgnoreCase(str)) {
			
		       Assert.assertTrue(element1.get(i).isDisplayed());
			   element1.get(i).click();
			break  ; 
			
		}
			
		}
	}
	
	public void Search() {
		
		Search.sendKeys("Tsharts");
		Search.sendKeys(Keys.ENTER);
				
	}


}
