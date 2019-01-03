package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	


	public WebDriver initialiseDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Selenium project\\E2Eproject\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
	
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium project\\E2Eproject\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium project\\E2Eproject\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}


	
}
