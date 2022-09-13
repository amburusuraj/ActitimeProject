package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import utilities.SeleniumUtils;

public class ReportsPage 
{
	@FindBy(xpath = "//div[text()='Reports']") public WebElement reportsTab;
	@FindBy(xpath = "//span[text()='New Report']") public WebElement newBtn;
	@FindBy(xpath = "//td[text()='Reports Dashboard']") public WebElement ReportsDashboard;
	@FindBy(xpath = "(//div[text()='Time-Track In Detail'])[2]") public WebElement timeTrackBtn;
	@FindBy(xpath = "//div[text()='Configure Report Parameters']") public WebElement configureReportParameters;
	@FindBy(id = "joinComments") public WebElement joinCheckBox;
	
	public void createReport()
	{
		SeleniumUtils.pageload(10);
		reportsTab.click();
		Reporter.log("Reports tab Clicked......");
		SeleniumUtils.waitTillElementVisible(ReportsDashboard);
		newBtn.click();
		Reporter.log("New Button Clicked and Navigated to Next Page......");
		timeTrackBtn.click();
		Reporter.log("Time Track Button Clicked......");
		SeleniumUtils.waitTillElementVisible(configureReportParameters);
		configureReportParameters.click();
		Reporter.log("Configuration Reports Parameters Clicked......");
		joinCheckBox.click();
		Reporter.log("Check Box Clicked......");
	}

}
