package www.redbus.in;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class bustickets {
	
		WebDriver driver ;
		
		
		@FindBy (css = "input[id='srcinput']") private WebElement from ;
		
		@FindBy (css = "div[class=\"listHeader___c2d064\"]") private List <WebElement> listHeader ;		
	
		@FindBy (css = "input[id='destinput']") private WebElement To ;
		
		@FindBy (css = "div[class=\"listHeader___c2d064\"]") private List <WebElement> listdrop ;		

		
		@FindBy (xpath = "//div[@class=\"dateWrapper___fed9d3 \"]") private WebElement date ;
		
		@FindBy (css = "div[class='dateWrap___a1f877']") private List <WebElement> days ;
		
		@FindBy (css = "button[aria-label=\"Search buses\"]") private WebElement Search ;
		
		@FindBy (css = "div[class='travelsName___4606dc']") private List<WebElement> TravelsName ;
		
	
		public bustickets (WebDriver driver ) 
		{			
			PageFactory.initElements(driver, this );
			this.driver = driver ;			
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver ;


		public void website () {
			driver.get("https://www.redbus.in/");	
		}
	
		public void from1(String City , String Picup_Area) throws InterruptedException 
		{
			from.sendKeys(City); //Pune 

			Thread.sleep(2000);

			int n = listHeader.size();

			String Area = Picup_Area ; //"Shivaji Nagar, Pune";
			
			System.out.println("All OnBordding  Area List :-");
			
			for (int i = 0; i < n; i++) {

			    String fromList = listHeader.get(i).getAttribute("aria-label").trim();

		        System.out.println(fromList);

			    if (Area.equalsIgnoreCase(fromList)) {

			        Actions act = new Actions(driver);
			        act.moveToElement(listHeader.get(i)).click().perform();
			        System.out.println("Pickup Point :- " + fromList);

			        Assert.assertEquals(Area, fromList);
			        break;
			    }
			}
			
			Thread.sleep(2000);
			
			System.out.println();

		} 
		
		

		public void TO11(String City , String Drop_area) throws InterruptedException 
		{
			To.sendKeys(City);
			
			Thread.sleep(2000);

			String Area = Drop_area ;
	        Actions act = new Actions(driver);

			
			 System.out.println("All Dropping Area List :- ");
			 
			for (int i = 0; i < listdrop.size(); i++) {

			    String ToList = listdrop.get(i).getAttribute("aria-label").trim();
			    System.out.println(ToList);
			    
			    if (Area.equalsIgnoreCase(ToList)) {

			        System.out.println("Pickup Point :- " + ToList);

			        act.moveToElement(listdrop.get(i)).click().perform();

			        Assert.assertEquals(Area, ToList);
			        break;
			    }
			}
			
			Thread.sleep(2000);

		}
	
	public void date () throws InterruptedException {
		
		Actions act = new Actions(driver);

		act.moveToElement(date).click().perform();

		Thread.sleep(2000);

		int day = days.size();
		String expectedDate = "28";

		for (int i = 0; i < day; i++) {

		    String Act = days.get(i).getText().trim();

		    if (expectedDate.equals(Act)) {
		        days.get(i).click();
			    System.out.println(Act);
			    
			    Assert.assertEquals(expectedDate, Act);
		        break;
		    }
		}
		
	}
	
	public void Search () 
	{
		Actions act = new Actions(driver);
		act.click(Search).click().perform();	
	}
	
	
	public void Travelsname() throws InterruptedException {
		
		
		int n = TravelsName.size();
		
		for(int i=0 ;i<n ; i++) {
			 
			String act = TravelsName.get(i).getText().trim();
			
			System.out.println(act);
		}
		
		Thread.sleep(5000);
	}
	
}
