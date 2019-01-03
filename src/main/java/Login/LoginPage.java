package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import PageObjects.LandingPage;



public class LoginPage extends LandingPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}

	
	@FindBy(how=How.XPATH, using="//*[@id=\"user_login\"]")
	private WebElement eUserName;
	@FindBy(how=How.XPATH, using="//*[@id=\"user_pass\"]")
	private WebElement eUserPWD;
	@FindBy(how=How.XPATH, using="//*[@id=\"wp-submit\"]")
	private WebElement LOGIN;



private void loginVerify(String email,String password)
{
	eUserName.sendKeys(email);
	eUserPWD.sendKeys(password);
	
}

private void clickLogin()
{
	LOGIN.click();
	}
	
public LoginPage LOGin(String email,String password)
{
	this.loginVerify(email,password);
	this.clickLogin();
	return new LoginPage(driver);
	}
	
}
