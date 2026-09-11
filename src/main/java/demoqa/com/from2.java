package demoqa.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class from2 {
	
	WebDriver driver ;
	
	@FindBy (css = "input[id=\"firstName\"]") private WebElement FN ;
	@FindBy(css = "input[id=\"lastName\"]") private WebElement LN ;
	@FindBy(css = "input[id=\"userEmail\"]") private WebElement Gmail ;
	
	@FindBy(css = "input[id=\"userNumber\"]") private WebElement mob ;

	@FindBy(css = "input[id=\"dateOfBirthInput\"]") private WebElement date ;
	
//	@FindBy(css = "select[class=\"react-datepicker__month-select\"]") private WebElement Month ;
//	
//	@FindBy(css = "select[class=\"react-datepicker__year-select\"]") private WebElement Yr ;
//
//	@FindBy(xpath = "(//div[text()=\"4\"])[1]") private WebElement day ;

	@FindBy(css = "select[class=\"react-datepicker__month-select\"]") private WebElement Month ;
	@FindBy (css = "select[class=\"react-datepicker__year-select\"]") private WebElement Yr ;
	@FindBy (xpath = "(//div[text()='4'])[1]") private WebElement day ;

	
	
	public from2 (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		
	}

	public void website () {
		driver.get("https://demoqa.com/automation-practice-form");
		
		String Act = driver.getCurrentUrl().toString();
		String Exp = "https://demoqa.com/automation-practice-form";
		System.out.println(Act );
		
		Assert.assertEquals(Exp, Act);
	}
	
	
	public void fn () {
		
		Assert.assertTrue(FN.isDisplayed());
		FN.sendKeys("Pramod");
		
	}
	
	public void LN () {
		
		Assert.assertTrue(LN.isDisplayed());
		LN.sendKeys("Pramod");
		
	}
	
	public void gmail () {
		
		Assert.assertTrue(Gmail.isDisplayed());
		Gmail.sendKeys("Pramod");
		
	}
		
	public void MOB  () {
			
			Assert.assertTrue(mob.isDisplayed());
			mob.sendKeys("889955664431");
			
		}
	
	public void Date  () throws InterruptedException {
		
		Assert.assertTrue(date.isDisplayed());
		mob.click();
		
		//Assert.assertTrue(Month.isDisplayed());
		Select s = new Select(Month);
		s.selectByIndex(2);
		Thread.sleep(2000);

	//	Assert.assertTrue(Yr.isDisplayed());
		Select s2 = new Select (Yr);
		s2.selectByValue("1999");
		Thread.sleep(2000);

		Assert.assertTrue(day.isDisplayed());
		day.click();
		Thread.sleep(2000);

		
	}

	
	
}
