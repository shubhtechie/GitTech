package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}

	By emailID = By.cssSelector("input[id='user_email']");
	
	By enterPassword = By.cssSelector("input[id='user_password']");
	
	By loginButton = By.cssSelector("input[type='submit']");
	
	public WebElement getEmail()
	{
		return driver.findElement(emailID);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(enterPassword);
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(loginButton);
	}
}
