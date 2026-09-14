package www.redbus.in;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotel {
	
	WebDriver driver ;
	
	@FindBy (css = "i[class='fieldIcon___83a14b icon icon-search']") private WebElement citysearch ;
	@FindBy (css = "input[placeholder=\"City, area or hotel name\"]")private WebElement input ;
	
	
	@FindBy (css= "div[class=\"listHeader___0a527e\"]") private List <WebElement> area ;
	
	@FindBy (xpath = "(//i[@class=\"fieldIcon___83a14b icon icon-date_range\"])[1]") private WebElement icon ;
	
	@FindBy (css = "li[role='gridcell']") private List <WebElement> day ;
	
	

	public Hotel(WebDriver driver ) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver , this );
		this.driver = driver ;
		
	}
	
	public void website () {
		driver.get("https://www.redbus.in/hotels");
	}
	
	public void search() throws InterruptedException {
		
		Actions act = new Actions(driver);
		
		act.click(citysearch);
		
		act.moveToElement(citysearch).sendKeys("Delhi") ;
		
		Thread.sleep(5000);
		
		int count = area.size();
		
		System.out.println(count );
		
		for(int i= 0 ; i<count ; i++) {
			
			String subarea = area.get(i).getText();
			
			System.out.println(subarea);
		}
			}
	
	
	public void d1 () throws InterruptedException{
		
		Actions act = new Actions(driver);
		act.moveToElement(icon).click().perform();
		
		int count = day.size();
		
		System.out.println(count);
		
		String Check_IN = "19" ;
		String Check_Out = "22" ;
		
		for(int i = 0 ;i< count ; i++) {
			
			String days = day.get(i).getText().trim();
			
			System.out.println(days);
			
			if (Check_IN.equalsIgnoreCase(days)) {
				day.get(i).click();
				System.out.println(" Check In :- " + days);
			}
			

			if (Check_Out.equalsIgnoreCase(days)) {
				day.get(i).click();
				System.out.println(" Check Out :- " + days);
			}
			
		}
		
		

		
	}
	
}



