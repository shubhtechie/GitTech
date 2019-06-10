package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public Properties prop;
	public static  WebDriver driver;
	public WebDriver IntitializeDriver() throws IOException
	{
		prop = new Properties();
		
		FileInputStream in = new FileInputStream("C:\\Users\\hp\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(in);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "G:\\seleniumm\\gecko\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "G:\\seleniumm\\chromedriver_win32(1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "G:\\seleniumm\\chromedriver_win32(1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		}
	
	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File ("G:\\"+result+"Screenshot.png"));

	}
}
