package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage
{
	
	@FindBy(id="username")
	private WebElement unTextBox;
	
	@FindBy(name="pwd")
	private WebElement pwTextBox;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[contains(text(),'invalid')]")
	private WebElement errmsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String UN)
	{
		unTextBox.sendKeys(UN);
	}
	
	public void setPassword(String PWD)
	{
		pwTextBox.sendKeys(PWD);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void validateErrMsg()
	{
		Assert.assertTrue(errmsg.isDisplayed());
		Reporter.log("12345646", true);
	}

	          
}
