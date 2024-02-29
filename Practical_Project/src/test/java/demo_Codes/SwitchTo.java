package demo_Codes;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchTo {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.className("wikipedia-search-button")).click();
		List<WebElement> WinIDs = driver.findElements(By.xpath("//a[contains(text(),'Selenium')]"));
		System.out.println(WinIDs.size());
		for(int i=0;i<WinIDs.size();i++)
		{
			//System.out.println(WinIDs.get(i).getText());
			WinIDs.get(i).click();
		}
		Thread.sleep(2000);
		Set<String> winHandles = driver.getWindowHandles();
		for (String winHndl : winHandles) 
		{
			String pageTitle=driver.switchTo().window(winHndl).getTitle();
			if (pageTitle.equals("Selenium in biology - Wikipedia") || pageTitle.equals("Selenium (software) - Wikipedia"))
			{
				System.out.println("Present opened Window"+driver.getTitle());
				driver.findElement(By.linkText("Talk")).click();
				driver.close();
				//System.out.println(driver.findElement(By.xpath("//span[@class='mw-page-title-main']")).getText());
				//driver.findElement(By.xpath("//span[text()='hide']")).click();
				
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
