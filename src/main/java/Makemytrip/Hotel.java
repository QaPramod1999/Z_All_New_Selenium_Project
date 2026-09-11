package Makemytrip;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilClass.UtilClass;

public class Hotel extends UtilClass {
	WebDriver driver ;
	
	@FindBy (xpath = "//span[@data-cy=\"item-wrapper\"]") private List <WebElement> Menu ;
	@FindBy (xpath = "//span[@class='commonModal__close']") private WebElement closs ;
	
	
	@FindBy (xpath = "//input[@id=\"city\"]") private WebElement city ;
	@FindBy (xpath = "//input[@placeholder=\"Where do you want to stay?\"]") private WebElement citysearch ;
	@FindBy (css = "li[role=\"option\"]") private List < WebElement >  areas ;
	
	@FindBy (xpath = "//div[@class=\"chevronIconRight\"]") private WebElement   Arowe ;

	
	@FindBy (xpath = "(//div[@class=\"hsw_inputBox dates\"])[1]") private WebElement checkin ;
	@FindBy (xpath = "(//div[@class=\"hsw_inputBox dates\"])[2]") private WebElement CheckOut ;
	
	@FindBy (xpath = "//span[@role=\"button\"][1]") private WebElement Back ;
	@FindBy (xpath = "//span[@role=\"button\"][2]") private WebElement forword ;
	
	@FindBy (xpath = "//div[@class=\"DayPicker-Day\"]") private List <WebElement>  Day ;
	


	
	//span[@role="button"][2]

	
	public Hotel(WebDriver driver ) {
		PageFactory.initElements(driver , this);
		this.driver = driver ;
		
	}
	
	public void website() throws InterruptedException {
		
		driver.get("https://www.makemytrip.com/");
		
	
		
	}
	
	public void menu() {
		
		int n = Menu.size(); 
		int Exp = 1 ;
		for(int i = 0 ; i<n ; i++) {
			
			String Act_menu = Menu.get(i).getText().replace("*", "").trim();
			
			if ( Exp == i) {
				System.out.println(Act_menu);
				expliciteWait(driver, Menu.get(i));
				Menu.get(i).click();
			}
		}
		
	}
	
	public void city () {
		
		
		expliciteWait(driver, city).click();
		expliciteWait(driver, citysearch);
		citysearch.sendKeys("Pune");
		citysearch.sendKeys(Keys.ENTER);
	
		expliciteWait(driver, Arowe).click();
		
		
//		for(int i = 0; i<n ;i++) {
//			
//			String area = areas.get(i).getText().replace("*", "").trim();
//			
//			if(Exp == i) {
//				System.out.println(area);
//			javascriptExecutor(driver, areas.get(i));
//			areas.get(i).click();
//			
//			}
//	    	}
		}		
	
	
	public void BookingDate () {
		expliciteWait(driver, checkin).click();
		expliciteWait(driver, forword).click();
		expliciteWait(driver, forword).click();
		
		int n = Day.size();
		
		for(int i = 0 ; i<n ;i++) {
			int checkin = 5 ;
			
			String date = Day.get(i).getText().replace("*", "").trim();
			if(checkin == i) {
				System.out.println("Check In : " + date);
				expliciteWait(driver, Day.get(i)).click();
				
			}
		}
		
		for(int i = 0 ; i<n ;i++) {
			int checkout = 10 ;
			String date = Day.get(i).getText().replace("*", "").trim();

			Day.get(i);
			if(checkout == i) {
				System.out.println("Check Out : " + date);
				expliciteWait(driver, Day.get(i)).click();
			}
		}
		
	}
	

}
