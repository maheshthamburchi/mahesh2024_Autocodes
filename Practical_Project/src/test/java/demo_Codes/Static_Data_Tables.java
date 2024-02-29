package demo_Codes;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Static_Data_Tables {

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		/*int tableR = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int tableCol=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Row_Count"+tableR+"    "+"Col_Count"+tableCol);
		for (int r = 2; r <= tableR; r++) 
		{
			for (int c = 1; c < tableCol; c++) 
			{
				String data =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data+"\t"+"\t");
			}System.out.println();
		}
		System.out.println("Specific candidate Name:   "+driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[2]")).getText());
		*/
		
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr/td[3]")).size();
		System.out.println(rows);
		for (int r=2;r<=rows+1;r++) 
		{
			String name=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			
			
			if (name.equals("Amit"))
			{
				
		String outpt=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
			System.out.println(outpt);	
			}
//			System.out.println("Author names   "+name);
			
			}
		
		// int price = driver.findElements(By.xpath("//table[@name='BookTable']//tr/td[4]")).size();
		int sum=0;	
		for (int p=2;p<=rows+1;p++)
			{
				String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+p+"]/td[4]")).getText();
			sum=sum+Integer.parseInt(price);
			
			}System.out.println("Total price    "+sum);
		 driver.quit();
		
	}

}
