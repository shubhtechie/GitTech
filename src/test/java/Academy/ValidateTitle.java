package Academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.navigateToLoginPage;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidateTitle extends base {
	 public static Logger log =LogManager.getLogger(base.class.getName());
	
@BeforeTest
public void start() throws IOException
{
	driver = IntitializeDriver();
	driver.get(prop.getProperty("url"));
	 log.info("Driver is initialized");
			
}
	@Test
	public void basePageNavigation() throws IOException
	{
		
		navigateToLoginPage login = new navigateToLoginPage(driver);
		
		if(driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
		}
		
		String t = driver.getTitle();
		
		System.out.println(t);
		System.out.println(t);
		
		Assert.assertEquals(t, "aaaa");
		
	//	Assert.assertEquals(login.getTitle().getText(), "FEATURED COURSE");
		
		
	}
	
	@AfterTest
	public void stop()
	{
		driver.close();
	}
	
}
