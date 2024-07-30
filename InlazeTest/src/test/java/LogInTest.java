import org.junit.After;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.json.JSONObject;

public class LogInTest {
    private WebDriver driver;

    @Before
    public void setUp() {

    	System.setProperty("webdriver.edge.driver", "./src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://test-qa.inlaze.com/auth/sign-in");
    }
 
    @Test
    public void testValidLogIn() {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        driver.findElement(By.cssSelector("#email")).sendKeys("miguel_angel230999@hotmail.com");
        driver.findElement(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/form/div[2]/app-password/div/input")).sendKeys("Bmaobi83@");
        driver.findElement(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/form/button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
		WebElement welcomeMessage = driver.findElement(By.xpath("/html/body/app-root/app-panel-root/app-navbar/div/div[2]/div/div/h2")); 
		assertTrue(welcomeMessage.isDisplayed());
		assertEquals("Miguel Angel Hermida Mogollon", welcomeMessage.getText()); 
 
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
  
          

}

