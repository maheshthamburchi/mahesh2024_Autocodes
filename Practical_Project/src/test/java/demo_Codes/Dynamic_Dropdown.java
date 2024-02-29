package demo_Codes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Dropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://bing.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("hp laptop");
		
		List<WebElement> searchBox = driver.findElements(By.xpath("//span[@class='sa_tm_text']"));
		System.out.println(searchBox.size());
		
		for(int i=0; i<searchBox.size(); i++)
		{
			
			if (searchBox.get(i).getText().equals("hp laptop battery"))
			{
				searchBox.get(i).click();
				
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
		

	}

}
