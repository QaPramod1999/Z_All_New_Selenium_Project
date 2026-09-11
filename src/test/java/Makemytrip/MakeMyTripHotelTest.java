package Makemytrip;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripHotelTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {

    	
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	
        driver.get("https://www.makemytrip.com/");
    }

    @Test
    public void hotelSearch() {

        // 1. Close popup
        try {
            WebElement closePopup = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector(".commonModal__close")
                    )
            );

            closePopup.click();

        } catch (Exception e) {
            System.out.println("Popup not displayed");
        }

        // 2. Click City / Property textbox
        WebElement cityBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[contains(@placeholder,'City, Property name')]")
                )
        );

        cityBox.click();

        // 3. Enter Pune
        cityBox.sendKeys("Pune");

        // 4. Select Pune from suggestion
        WebElement pune = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'Pune') and contains(text(),'Maharashtra')]")
                )
        );

        pune.click();

        // 5. Select Check-in date
        WebElement checkIn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'9')]")
                )
        );

        checkIn.click();

        // 6. Select Check-out date
        WebElement checkOut = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'18')]")
                )
        );

        checkOut.click();

        // 7. Open guest section
        WebElement guests = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'Guests')]")
                )
        );

        guests.click();

        // 8. Increase Adults
        WebElement adultPlus = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(@class,'addRoo')][1]")
                )
        );

        adultPlus.click();

        // 9. Click Apply
        WebElement apply = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'APPLY')]")
                )
        );

        apply.click();

        // 10. Click Search
        WebElement search = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Search')]")
                )
        );

        search.click();

        System.out.println("Hotel search completed successfully");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}