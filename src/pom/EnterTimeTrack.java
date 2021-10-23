package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class EnterTimeTrack {
	
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	@FindBy(xpath="(//div[@class='popup_menu_arrow'])[3]")
	private WebElement help;
	
	@FindBy(xpath="//a[text()='About actiTIME']")
	private WebElement AboutActiTime;
	
	@FindBy(xpath="//img[@title='Close']")
	private WebElement close;
	
	@FindBy(xpath="//span[contains(text(),'build')]")
	private WebElement BuildNumber;
	
	@FindBy(xpath="//td[text()='Enter Time-Track']")
	private WebElement trackforfield;
	
	@FindBy(xpath="//div[text()='TIME-TRACK']")
	private WebElement TIME_TRACK;
	

	SoftAssert s_a=new SoftAssert();
	
	public EnterTimeTrack(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickHelp()
	{
		help.click();
	}
	
	public void clickLogOutLink()
	{
		logoutLink.click();
	}
	
	public void clickAboutActiTime()
	{
		AboutActiTime.click();
	}
	
	public void clickClose()
	{
		close.click();
	}
	
	public void verifyBuidlNumber(SoftAssert s,String eBuildNumber)
	{
		String aBuildNumber=BuildNumber.getText();
		s.assertEquals(aBuildNumber, eBuildNumber);
		
	}
	
	public void validatelogoutbtn()
	{
		
		Assert.assertTrue(logoutLink.isDisplayed());
	}
	
	public void trackfor()
	{
		s_a.assertTrue(trackforfield.isDisplayed());
//		s_a.assertAll();
	}
	
	public void TIME_TRACK()
	{
		s_a.assertTrue(TIME_TRACK.isDisplayed());
//		s_a.assertAll();
	}
	

}
