package demo_Codes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));
		System.out.println(checkboxes.size());
		
		for(int i=0; i<checkboxes.size(); i++)
		{
			checkboxes.get(i).click();
		}
		
//		for(WebElement chkbx:checkboxes)
//		{
//			chkbx.click();
//			System.out.println(chkbx.getText());
//		}
		
		driver.findElement(By.id("country")).click();
		List<WebElement> country = driver.findElements(By.xpath("//select[@id='country']/option"));
		System.out.println(country.size());
		
		for(int i=0; i<country.size(); i++)
		{
			System.out.println(country.get(i).getText());
			if (country.get(i).getText().equals("France")) {
				country.get(i).click();
			}
		}
		
		Thread.sleep(3000);
		//driver.quit();
}
}
