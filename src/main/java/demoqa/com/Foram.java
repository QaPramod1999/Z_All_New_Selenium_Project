package demoqa.com;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class Foram {
	
	
	WebDriver driver ;
	
	
	@FindBy(css = "input[placeholder=\"First Name\"]") private  WebElement FN ;
	@FindBy(css = "input[id=\"gender-radio-1\"]") private  WebElement GN ;
	@FindBy(css = "input[class=\"subjects-auto-complete__input\"]") private  WebElement sub ;
	@FindBy(css = "input[id=\"dateOfBirthInput\"]") private WebElement DOB ;
	@FindBy(css = "select[class=\"react-datepicker__month-select\"]") private WebElement month ;
	@FindBy (css = "select[class=\"react-datepicker__year-select\"]") private WebElement Year ;
	@FindBy (xpath = "(//div[text()='4'])[1]") private WebElement date ;

	
	public Foram(WebDriver driver ) {
		PageFactory.initElements(driver , this);
		this.driver = driver ;
		
		
	}
	
	public void webSite() {
		
		driver.get("https://demoqa.com/automation-practice-form");
		String Act = driver.getCurrentUrl();
		String Exp = "https://demoqa.com/automation-practice-form" ;
		
		Assert.assertEquals(Act, Exp);
		
		}
	
	public void fn() {
			Assert.assertTrue(FN.isDisplayed());
				FN.sendKeys("Pramod");
				
		}
	
	public void gn () {
		Assert.assertTrue(GN.isDisplayed());
			GN.click();
			
	}
	
	public void Sub () {
		Assert.assertTrue(sub.isDisplayed());
		sub.sendKeys("English");
		sub.sendKeys(Keys.ENTER);
		
	}
	
	public void dob () throws InterruptedException {
		
	Assert.assertTrue(DOB.isDisplayed());	
	DOB.click();
	
	Assert.assertTrue(month.isDisplayed());
	Select s = new Select(month);
	s.selectByIndex(1);
	
	Assert.assertTrue(Year.isDisplayed());
	Select s1 = new Select(Year);
	s1.selectByValue("1999");
	
	
	Assert.assertTrue(date.isDisplayed());
	date.click();
	
	String d = DOB.getText().replace("*", "").trim();
	System.out.println(d);
	System.out.println(DOB);

	Thread.sleep(300);
	
	}
	
}
