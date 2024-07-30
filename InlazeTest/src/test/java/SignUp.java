import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {
	private WebDriver driver;
	@Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
    	System.setProperty("webdriver.edge.driver", "./src/test/resources/msedgedriver.exe");
        //driver = new ChromeDriver();
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
    
    public void testValidSignUp() {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        driver.findElement(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/span/a")).click();
        driver.findElement(By.xpath("//*[@id=\"full-name\"]")).sendKeys("Usuario ejemplo");
        driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[2]/input")).sendKeys("UsuarioEjemplo@hotmail.com");
        driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[3]/app-password/div/input")).sendKeys("Bmaobi76#");
        driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[4]/app-password/div/input")).sendKeys("Bmaobi76#");
        driver.findElement(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
		WebElement welcomeMessage = driver.findElement(By.xpath("/html/body/app-root/app-panel-root/app-navbar/div/div[2]/div/div/h2")); 
		assertTrue(welcomeMessage.isDisplayed());
		assertEquals("Miguel Angel Hermida Mogollon", welcomeMessage.getText()); 
 
    }
    /*
    @After
    public void tearDown() {
        driver.quit();
    }
    */
}
