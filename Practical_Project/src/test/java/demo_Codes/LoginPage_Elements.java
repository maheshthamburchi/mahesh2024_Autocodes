package demo_Codes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Elements {

		WebDriver driver;
		//constructor
		public LoginPage_Elements(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		//Web element locators
		@FindBy (id = "username") WebElement txt_userName;
		@FindBy (id = "password") WebElement txt_password;
		@FindBy (id = "submit") WebElement btn_submit;
		@FindBy (xpath = "//p[@class='has-text-align-center']/strong") WebElement logOut_validation;
		
		//Action methods
		public void setUserName(String usename)
		{
			txt_userName.sendKeys(usename);
		}
		public void setPassword(String password)
		{
		txt_password.sendKeys(password);		
		}
		public void clickButton()
		{
			btn_submit.click();
		}
		public boolean logoutValid()
		{
			boolean status = logOut_validation.isDisplayed();
			return status;
		}

}
