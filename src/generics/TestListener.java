package generics;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import scripts.BaseTest;


public class TestListener implements ITestListener {

	
	WebDriver driver;

	DateFormat df = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ssaa");
	Date dateobj=new Date();
	
    @Override
    public void onTestFailure(ITestResult result) {

    	
    	String sysdate = df.format(dateobj);
    	String filePath = ".\\Results\\"+sysdate+"\\failure\\";
    	
    	System.out.println("Date   " +sysdate);
    	System.out.println("file path    " +filePath);
    	this.driver=((BaseTest)result.getInstance()).driver;
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	takeScreenShot(methodName,filePath);
    }
    
    public void takeScreenShot(String methodName, String filpa) {
//    	String sysdate = df.format(dateobj);
//    	String filePath = ".\\Results\\"+sysdate+"\\";
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(filpa+methodName+".png"));
				System.out.println("***Placed screen shot in "+filpa+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {
    	String sysdate = df.format(dateobj);
    	String filePath = ".\\Results\\"+sysdate+"\\Success\\";
    	this.driver=((BaseTest)result.getInstance()).driver;
    	System.out.println("***** Success "+result.getName()+" test has Success *****");
    	String methodName=result.getName().toString().trim();
    	takeScreenShot(methodName, filePath);
    }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  