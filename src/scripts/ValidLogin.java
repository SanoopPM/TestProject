package scripts;

import org.testng.annotations.Test;
import generics.Excel;
import pom.EnterTimeTrack;
import pom.LoginPage;

public class ValidLogin extends BaseTest
{

	@Test
	public void testValidLogin()
	{
		LoginPage l=new LoginPage(driver);
		EnterTimeTrack e=new EnterTimeTrack(driver);

		String xlpath="./TestData/TestData.xlsx";
		String sheet1="ValidLogin";
		//		int rc=Excel.getRowCount(xlpath, sheet1);
		int i=1;

		String un=Excel.getCellValue(xlpath, sheet1, i, 0);
		String pwd=Excel.getCellValue(xlpath, sheet1, i, 1);


		//enter valid user name
		l.setUserName(un);

		//enter valid password
		l.setPassword(pwd);

		//click on login button
		l.clickLoginButton();

		//click on logout
		e.validatelogoutbtn();

	}

	@Test (dependsOnMethods={"testValidLogin"})
	public void validatepage1()
	{
		EnterTimeTrack e=new EnterTimeTrack(driver);
		e.trackfor();
	}

	@Test (dependsOnMethods={"testValidLogin"})
	public void validatepage2()
	{
		EnterTimeTrack e=new EnterTimeTrack(driver);
		e.TIME_TRACK();
	}

}
