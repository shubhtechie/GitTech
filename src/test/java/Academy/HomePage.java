package Academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.navigateToLoginPage;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage extends base{
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException, InterruptedException
	{
		driver = IntitializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		navigateToLoginPage login = new navigateToLoginPage(driver);
		
	Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
		}
		
		login.getLogin().click();
		
		LoginPage log = new LoginPage(driver);
		
		log.getEmail().sendKeys(username);
		
		log.getPassword().sendKeys(password);
		
		log.clickLogin().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0]="user1";
		data[0][1]="pwd1";
		
		data[1][0]="user2";
		data[1][1]="pwd2";
		
		return data;
	
	}

}
