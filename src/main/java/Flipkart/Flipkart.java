package Flipkart;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilClass.UtilClass;

public class Flipkart extends UtilClass  {
	
	WebDriver driver ;
	
	@FindBy (xpath = "(//input[@placeholder=\"Search for Products, Brands and More\"])[1]") private WebElement search ;
	
	@FindBy (xpath = "//div[@class=\"_6odwB UHMz4K\"]") private List<WebElement> Filtter ;
	
	@FindBy (xpath = "//div[@class=\"p0C73x\"]") private List <WebElement> product ;
	

	
	public Flipkart(WebDriver driver ) {
		
		PageFactory.initElements(driver, this );
		this.driver = driver ;
		
	}
	
	public void Website () {
		
		String Act = "https://www.flipkart.com/";
		
		driver.get("https://www.flipkart.com/");
		
		String Exp = driver.getCurrentUrl();
		
		Assert.assertEquals(Act, Exp);
		
	}
	
	public void search () {
		
		search.sendKeys("tshirt for men");
		search.sendKeys(Keys.ENTER);
		
	}

	public void Product () throws InterruptedException {
		
		Thread.sleep(2000);
	   	   
		  int n = product.size();
		  System.out.println(n);
		  
		  int exp = 4 ;
			
			for (int i = 0  ; i< n; i++ ) {
				
			product.get(i);                 
			
			
			if (i== exp) {
				 
				javascriptExecutor(driver, product.get(i));
				product.get(i).click();
				 
			}
				
			}
			
			}
	
	
	
   public void Filtter () {
	   	   
	  int n = Filtter.size();
	  System.out.println(n);
		
		for (int i =0 ; i< n; i++ ) {
			
			String FiltterType = Filtter.get(i).getText().replace("*", "").trim();
			
			System.out.println(FiltterType);
			
			String Exp = "SIZE";
			
			if(FiltterType.equalsIgnoreCase(Exp)) {
				Filtter.get(i).click();
				System.out.println();
			}
			
		}
		
	}
	
	
}
