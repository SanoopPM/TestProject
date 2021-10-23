package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generics.Excel;
import pom.EnterTimeTrack;
import pom.LoginPage;

public class VerifyBuildNumber extends BaseTest
{
	@Test
	public void testVerifyBuildNumber() throws InterruptedException
	{
		String xlpath="./TestData/TestData.xlsx";
		String sheet2="ValidLogin";
		String sheet3="VerifyBuildNumber";
		String eBuildNumber=Excel.getCellValue(xlpath, sheet3, 1, 0);
		int rc=Excel.getRowCount(xlpath, sheet2);
		for(int i=1;i<=rc;i++)
		{
			String un=Excel.getCellValue(xlpath, sheet2, i, 0);
			String pwd=Excel.getCellValue(xlpath, sheet2, i, 1);			
		
		

		SoftAssert s = new SoftAssert();
		
		//enter user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		
		//enter valid password
		l.setPassword(pwd);
		
		//click on login button
		l.clickLoginButton();
		
		//click on Help
		Thread.sleep(1000);
		EnterTimeTrack e=new EnterTimeTrack(driver);
		e.clickHelp();
		
		//click on AboutActiTime 
		e.clickAboutActiTime();
		
		//verify Build Number
		e.verifyBuidlNumber(s,eBuildNumber );
		
		//click close
		e.clickClose();
		
		//click logout
		e.clickLogOutLink();
		
		s.assertAll();
		}
		
	}

}
