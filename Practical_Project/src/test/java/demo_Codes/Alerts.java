package demo_Codes;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@onclick='myFunctionPrompt()']")).click();
		Thread.sleep(3000);
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.sendKeys("maheshSrilatha");
		Thread.sleep(2000);
		alt.accept();
		Thread.sleep(3000);
		String actText=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		String expText = "Hello MaheshSrilatha! How are you today?";
		
		if (actText.equals(expText))
		{
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test failed");
		}
		
		
		driver.quit();
		
	}

}
