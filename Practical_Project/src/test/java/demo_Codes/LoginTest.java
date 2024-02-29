package demo_Codes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
		WebDriver driver;
		LoginPage_Elements lp;
	@BeforeClass
	void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/");
		driver.findElement(By.linkText("PRACTICE")).click();
		driver.findElement(By.linkText("Test Login Page")).click();
	}
	
	@Test
	void testlogin()
	{
		lp=new LoginPage_Elements(driver);
		lp.setUserName("student");
		lp.setPassword("Password123");
		lp.clickButton();
		
		
	}
	
	@Test
	void validation()
	{
		if(lp.logoutValid())
		{
			System.out.println(lp.logOut_validation.getText());
		}
		else {
			System.out.println("program failed");
		}
	}
		
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
}
