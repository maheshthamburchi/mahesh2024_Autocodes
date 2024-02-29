package demo_Codes;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDT_Interest_Calc {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://cleartax.in/s/simple-compound-interest-calculator");
		String file = System.getProperty("user.dir")+ "\\Test_Data\\Excel_Data.xlsx";
		int rows =Excel_utils.getRowCount(file, "Personal_Loan");
		
		//int col = Excel_utils.getCellCount(file, "Personal_Loan", rows);
		for(int r=1;r<=rows;r++)
		{
			//for(int c=0;c<col-2;c++)
			
				String interestType = Excel_utils.getCellData(file, "Personal_Loan", r, 0);
				String compFreq = Excel_utils.getCellData(file, "Personal_Loan", r, 1);
				String prinAmt = Excel_utils.getCellData(file, "Personal_Loan", r, 2);
				String annualRate = Excel_utils.getCellData(file, "Personal_Loan", r, 3);
				String periodUnt = Excel_utils.getCellData(file, "Personal_Loan", r, 4);
				String periodOpt = Excel_utils.getCellData(file, "Personal_Loan", r, 5);
				String ExpectedValue = Excel_utils.getCellData(file, "Personal_Loan", r, 6);
//				if(compFreq.isEmpty())
//				{
//					continue;
//				}
				Select intType = new Select(driver.findElement(By.id("a")));
				intType.selectByVisibleText(interestType);//3 times compound interest will select
				
				System.out.println(interestType);
				if(driver.findElement(By.id("b")).isDisplayed())
				{
					System.out.println("compound freqency displayed");
					Select comfre=new Select(driver.findElement(By.id("b")));
					comfre.selectByVisibleText(compFreq);
										
				}
				else {
					System.out.println("simple interest selected");
				}
				
				WebElement input = driver.findElement(By.xpath("//input[@id='c']"));
				input.clear();	
				input.sendKeys(prinAmt);
				
				WebElement input2 = driver.findElement(By.xpath("//input[@id='d']"));
				input2.clear();
				input2.sendKeys(annualRate);
				Select perdunit=new Select(driver.findElement(By.id("f")));
				perdunit.selectByVisibleText(periodUnt);
				
				WebElement input3 = driver.findElement(By.xpath("//input[@id='e']"));
				input3.clear();
				input3.sendKeys(periodOpt);
				
				String actValue = driver.findElement(By.xpath("(//div[@class='output']/span)[3]")).getText();
				String plain = actValue.replace("₹", "");
				String plainValue = plain.trim();
				System.out.println(plainValue+"     "+ExpectedValue);
				
				if(plainValue.equals(ExpectedValue))
				{
					System.out.println("Test Passed");
					Excel_utils.setCellData(file, "Personal_Loan", rows, 8, "Passed");
					Excel_utils.fillGreenColor(file, "Personal_Loan", rows, 8);
				}
				else
				{
					System.out.println("Test Failed");
					Excel_utils.fillRedColor(file, "Personal_Loan", rows, 8);
				}

				
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
