package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import utilities.SeleniumUtils;

public class TaskPage 
{
	@FindBy(xpath = "//div[text()='Add New']")public WebElement addNewBtn;
	@FindBy(xpath = "//div[contains(text(),'New Customer')]")public WebElement newCustomerBtn;
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")public WebElement customerNameTextBox;
	@FindBy(xpath = "//div[text()='Create Customer']")public WebElement createcustomerBtm;
	
	public void createCustomer(String customerName)
	{
		SeleniumUtils.pageload(10);
		addNewBtn.click();
		Reporter.log("Add New Button Clicked......");
		newCustomerBtn.click();
		Reporter.log("New Customer Button Clicked......");
		SeleniumUtils.waitTillElementVisible(customerNameTextBox);
		SeleniumUtils.enterValue(customerNameTextBox, customerName);
		Reporter.log("Customer Name Entered Successfully......");
		createcustomerBtm.click();
		Reporter.log("New Customer Created......");
	}


}
