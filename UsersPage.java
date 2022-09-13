package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import utilities.BaseClass;
import utilities.SeleniumUtils;

public class UsersPage 
{
	@FindBy(xpath ="//div[text()='Users']" )public WebElement usersTab;
	@FindBy(xpath ="//span[text()='List of Users']")public WebElement listOfUsers;
	@FindBy(xpath ="//div[text()='New User']" )public WebElement newUser; 
	@FindBy(xpath ="//div[text()='Add User']")public WebElement addUser;
	@FindBy(xpath ="//input[@id='createUserPanel_firstNameField']" )public WebElement customerFirstName;
	@FindBy(xpath ="(//input[@placeholder='Last Name'])[3]")public WebElement customerLastName;
	@FindBy(xpath ="(//input[@name='email'])[2]" )public WebElement customerEmail;
	@FindBy(xpath ="//div[text()='Save & Send Invitation']" )public WebElement savedSendInvitation;
	@FindBy(xpath ="//span[text()='Invite one more user']" )public WebElement inviteOneMoreUser;
	@FindBy(xpath ="//span[text()='Invite one more user']")public WebElement closeBtn;
	@FindBy(xpath ="//div[@class='closeButton hideButton_panelContainer']")public WebElement crossBtn;
	
	
	public void inviteCustomer()
	{
		SeleniumUtils.pageload(10);
		usersTab.click();
		Reporter.log("User tab Clicked......");
		SeleniumUtils.waitTillElementVisible(listOfUsers);
		newUser.click();
		Reporter.log("New User Button Clicked and Navigated to Next Page......");
		SeleniumUtils.waitTillElementVisible(addUser);
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(customerFirstName).sendKeys("abcdefgh").perform();
		Reporter.log("Customer First Name Entered......");
		act.moveToElement(customerLastName).sendKeys("alphabits").perform();
		Reporter.log("Customer Last Name Entered......");
		act.moveToElement(customerEmail).sendKeys("abdfg@gmail.com").perform();
		Reporter.log("Customer Email Entered......");
		savedSendInvitation.click();
		Reporter.log("Clicked on Saved Send Invitaion......");
		
		if(closeBtn.isDisplayed())
		{
			closeBtn.click();
			Reporter.log("Closed Button Clicked Successfully......");	
		}
		else
		{
			crossBtn.click();
			Reporter.log("Cancel cross Button clicked Successfully......");
		}
		
	}

}
