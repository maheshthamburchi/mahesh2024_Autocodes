package demo_Codes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Calender {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		Actions act=new Actions(driver);
		driver.findElement(By.xpath("//span[@class='ng-tns-c57-8 ui-autocomplete ui-widget']/input")).sendKeys("SECUNDERABAD JN - SC (SECUNDERABAD)");
		act.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']//input")).sendKeys("GADWAL JN - GWD");
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']//input")).click();
			 
		
		String myMonth="May";
		String myYear= "2024";
		String myDate="26";

		while (true)
		{		 
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month ng-tns-c58-10 ng-star-inserted']")).getText();
			String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year ng-tns-c58-10 ng-star-inserted']")).getText();

			
			if(month.equals(myMonth) && year.equals(myYear))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10']")).click();
		}
		
		List<WebElement> alldates = driver.findElements(By.xpath("//tbody[@class='ng-tns-c58-10']//tr//td"));
		System.out.println(alldates.size());
		for(int d=0;d<alldates.size();d++)
		{
			String ad = alldates.get(d).getText();
			System.out.println(ad);
			if(ad.equals(myDate))
			{
				alldates.get(d).click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[@class='search_btn train_Search']")).click();
		Thread.sleep(6000);
		driver.quit();
		
		
		}
	
	
	

}
