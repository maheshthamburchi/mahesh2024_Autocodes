package demo_Codes;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtoETest_LowPrice {

	public static <E> void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		 List<WebElement> fromPort = driver.findElements(By.xpath("//select[@name='fromPort']/option"));
		List<WebElement> toPort = driver.findElements(By.xpath("//select[@name='toPort']/option"));
		System.out.println(fromPort.size());
		System.out.println(toPort.size());
		for(int f=0;f<fromPort.size();f++)
		{
			if(fromPort.get(f).getText().equals("San Diego"))
			{
				fromPort.get(f).click();
				break;
			}
		}
		
		for(int to=0;to<toPort.size();to++)
		{
			if(toPort.get(to).getText().equals("Rome"))
			{
				toPort.get(to).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> price = driver.findElements(By.xpath("//table[@class='table']//tr//td[6]"));
		String pricearr[]=new String[price.size()];
		for(int p=1;p<=price.size();p++)
		{
			String price_data=driver.findElement(By.xpath("//table[@class='table']//tr["+p+"]//td[6]")).getText();
			//System.out.println(price_data);
			//String clean = price_data.replace("$","");
			pricearr[p-1]=price_data;
			
		}
		Arrays.sort(pricearr);
//		for(String arraVal:pricearr)
//		{
//			System.out.println(arraVal);
//		}	
		String lowestPrice = pricearr[0];
		System.out.println(lowestPrice);
		for(int p=1;p<=price.size();p++)
		{
			String price_data = driver.findElement(By.xpath("//table[@class='table']//tr["+p+"]//td[6]")).getText();
			//String clean = price_data.replace("$","");
			//System.out.println(price_data);
			if(price_data.equals(lowestPrice))
			{
				driver.findElement(By.xpath("//table[@class='table']//tr["+p+"]//td[1]//input")).click();
			break;	
			}
		}
		String msg=driver.findElement(By.xpath("//div[@class='container']//h2")).getText();
		String confmsg = "Your flight from TLV to SFO has been reserved.";
				if(msg.equals(confmsg))
				{
					System.out.println("Program successfully completed");
				}
				else 
				{
					System.out.println("Program failed");
				}
		
		Thread.sleep(3000);
		driver.quit();
		
	

        
	
}
}
