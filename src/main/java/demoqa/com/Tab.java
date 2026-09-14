package demoqa.com;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Tab {

	WebDriver driver ;
	
	@FindBy (css= "a[href='#'") private List <WebElement> tb ;
	
	
	public Tab(WebDriver driver ) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver , this );
		this.driver = driver ;
		
	}

	
	public void website () {
		driver.get("https://demoqa.com/menu");
	}
	
	public void menu() throws InterruptedException {
		Actions act = new Actions(driver);

		String Menu2 = "Main Item 2";
		String sublist = "SUB SUB LIST »";
		String x = "Sub Sub Item 1";

		int count = tb.size();

		for (int i = 0; i < count; i++) {

		    String mainMenu = tb.get(i).getText().trim();

		    if (Menu2.equalsIgnoreCase(mainMenu)) {

		        // Hover Main Item 2
		        act.moveToElement(tb.get(i)).perform();
		        Thread.sleep(1000);
		        System.out.println("MainMenu : " + mainMenu);

		        // Find SUB SUB LIST
		        for (int j = 0; j < tb.size(); j++) {

		            String subMenu = tb.get(j).getText().trim();
		            
		            System.out.println("Sub_Menu");
		            System.out.println(subMenu);

		            if (sublist.equalsIgnoreCase(subMenu)) {

		                act.moveToElement(tb.get(j)).perform();
		                Thread.sleep(1000);
		                System.out.println("SubMenu : " + subMenu);
		                
		                // Find Sub Sub Item 1
		                for (int k = 0; k < tb.size(); k++) {

		                    String subSubMenu = tb.get(k).getText().trim();
		                    
		                    System.out.println("Sub_Sub_Menu");
		                    System.out.println(subSubMenu);

		                    if (x.equalsIgnoreCase(subSubMenu)) {

		                        System.out.println("Found: " + subSubMenu);

		                        act.click(tb.get(k)).perform();
		              //          Assert.assertEquals(x, subSubMenu);
		                        break;
		                    }
		                }
		              //  break;
		            }
		        }
		      //  break;
		    }
		}
	
	}
	
}

