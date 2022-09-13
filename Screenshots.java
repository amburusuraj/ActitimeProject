package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshots implements ITestListener
{
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String name=result.getMethod().getMethodName();
		EventFiringWebDriver efd=new EventFiringWebDriver(BaseClass.driver);
		File src=efd.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\ambur\\OneDrive\\Desktop\\myjavaproject\\PassedScreenshots\\"+name+System.currentTimeMillis()+".png");
		try
		{
			FileUtils.copyFile(src, des);
		}
		catch(IOException e)
		{
			System.out.println("Screenshot not copied");
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		ITestListener.super.onTestFailure(result);
		String name=result.getMethod().getMethodName();
		EventFiringWebDriver efd=new EventFiringWebDriver(BaseClass.driver);
		File src=efd.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\ambur\\OneDrive\\Desktop\\myjavaproject\\FailesScreenshots\\"+name+System.currentTimeMillis()+".png");
		try
		{
			FileUtils.copyFile(src, des);
		}
		catch(IOException e)
		{
			System.out.println("Screenshot not copied");
			e.printStackTrace();
		}
	}

}
