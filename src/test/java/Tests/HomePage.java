package Tests;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import Login.LoginPage;
import PageObjects.LandingPage;
import Posts.AddNewPost;
import resources.Base;

public class HomePage extends Base {

	
	public WebDriver driver;

	@BeforeSuite
	public void TestSetup() throws IOException
	{
		driver = initialiseDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		WebElement displaymsg = driver.findElement(By.xpath("//*[@id=\"login\"]/h1/a"));
		assertEquals("Powered by WordPress",displaymsg.getText());
	}
	
	@Test(dataProvider = "loginData",priority =1)
	public void basepageLogin(String email,String password) 
	{
		
		//login to dashboard
		LoginPage LogIn = new LoginPage(driver);
		LogIn.LOGin(email, password);
		
	}
	
	@Test(dataProvider = "newPostinfo",priority =2)
	public void DashboardTest(String name,String Text,String filepath) throws AWTException
	{
		AddNewPost newpostinfo = new AddNewPost(driver);
		newpostinfo.FillPostinfo(name,Text,filepath);
		
	}
	
		//data to login
		 @DataProvider(name = "loginData")

		  public static Object[][] getdata() {

		        return new Object[][] {{ "admin", "demo123"}};

		  }
		 
		 //data to addmediafile
		 @DataProvider(name = "newPostinfo")

		  public static Object[][] newpost() {

		        return new Object[][] {{ "hello", "what's up?","C:\\Users\\pratik poudel\\Documents\\demo1.jpg"}};

		  }
		 
		 
		
		
		
@AfterSuite
public void teardown()
{
	//driver.close();
}
		
		
	
}

