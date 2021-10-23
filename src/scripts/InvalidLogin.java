package scripts;

import org.testng.annotations.Test;
import generics.Excel;
import pom.LoginPage;

public class InvalidLogin extends BaseTest
{
	@Test
	public void testInvalidLogin() throws InterruptedException
	{
		String xlpath="./TestData/TestData.xlsx";
		String sheet1="InvalidLogin";
		int rc=Excel.getRowCount(xlpath, sheet1);
		for(int i=1;i<=rc;i++)
		{
			String un=Excel.getCellValue(xlpath, sheet1, i, 0);
			String pwd=Excel.getCellValue(xlpath, sheet1, i, 1);			
				
		//enter invalid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		
		//enter invalid password
		l.setPassword(pwd);
		
		//click on login
		l.clickLoginButton();
		
		//verify err msg
		Thread.sleep(1000);
		l.validateErrMsg();
		
		}
	}
}
