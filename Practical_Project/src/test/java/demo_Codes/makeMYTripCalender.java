package demo_Codes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class makeMYTripCalender {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Actions act= new Actions(driver);


		driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chTrains']")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//div[@role='combobox']/input")).sendKeys("sc");
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).perform();
		//driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//div[@role='combobox']/input")).sendKeys("gwd");
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		//driver.findElement(By.xpath("//input[@class='rsw_inputField font20 date']")).click();
		String myMonth = "May 2024";
		String myDate="10";

		while(true)
		{
			String month=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			System.out.println(month);
			if(month.equals(myMonth))
			{
				break;
			}
			else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

			}
		}
		
		List<WebElement> date = driver.findElements(By.xpath("//div[@class='DayPicker-Week']//div"));
		for(int d=0; d<=date.size(); d++)
		{
			
				String dates = date.get(d).getText();
				//System.out.println(dates);	
					
			
			if(dates.equals(myDate))
			{
				date.get(d).click();
				break;
			}
		
		}
		List<WebElement> seat = driver.findElements(By.xpath("//ul[@class='travelForPopup']//li"));
		for(WebElement st:seat)
		{
			String sit = st.getText();
			System.out.println(sit);
			if(sit.equals("First AC"))
			{
				st.click();
				break;
			}
		}
			driver.findElement(By.xpath("//p[@class='makeFlex vrtlCenter']//a")).click();
		/*List<WebElement> sugList = driver.findElements(By.xpath("//div[@class='calc50']"));
		for(int s=0; s<sugList.size(); s++)
		{
			String list=sugList.get(s).getText();
			System.out.println(list);
			if(list.equals("Hyderabad"))
			{
				sugList.get(s).click();
				break;
			}
		}*/
		
		
		Thread.sleep(9000);
		driver.quit();

	}

}
