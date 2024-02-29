package demo_Codes;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination_DynamicDataTable {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement table = driver.findElement(By.xpath("//h2[text()='Pagination Table']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", table);
		Thread.sleep(3000);
		 int total_pages = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
		 for(int i=1;i<=total_pages;i++)
		 {
			 if (total_pages>1)
			 {
				 ////ul[@class='pagination']//a[text()="+i+"]
				  WebElement active_Page = driver.findElement(By.xpath("//ul[@id='pagination']/li["+i+"]"));
				  System.out.println("Present Active Page is "+active_Page.getText());
				  active_Page.click();
			 }
			 int noOfRows = driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
			 for(int r=1;r<noOfRows;r++)
			 {
				String product = driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td[2]")).getText();
				String price = driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td[3]")).getText();

				System.out.println(product+"   The price is"+price);
				 
			 }
			 
		 }
		 driver.quit();
		 
		 
		 
		 
		 
	}

}
