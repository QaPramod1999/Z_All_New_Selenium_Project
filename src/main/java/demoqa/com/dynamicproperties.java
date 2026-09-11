package demoqa.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class dynamicproperties {
	
	WebDriver driver ;
	
	@FindBy (css = "button[id=\"enableAfter\"]") private WebElement Will_enable ;
	@FindBy (css ="button[id=\"colorChange\"]") private WebElement color ;
	@FindBy (css = "button[id=\"visibleAfter\"]") private WebElement VisiblAfter ;
	

	
	
	public dynamicproperties(WebDriver driver ) {
		PageFactory.initElements(driver , this);
		this.driver = driver ;
		
		
	}
	
	public void website() {
		driver.get("https://demoqa.com/dynamic-properties");
		String Act = driver.getCurrentUrl();
		String Exp = "https://demoqa.com/dynamic-properties" ;
		
	//	Assert.assertEquals(Act, Exp);
	}
	
	public void dynamic() {
		
		Assert.assertTrue(Will_enable.isDisplayed());
		
		Assert.assertTrue(color.isDisplayed());
		
		Assert.assertTrue(VisiblAfter.isDisplayed());
		
	}

	
	
}
