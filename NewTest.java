package testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ReportsPage;
import pageObjects.TaskPage;
import pageObjects.UsersPage;
import utilities.BaseClass;
import utilities.ExcelLib;
import utilities.Screenshots;

@Listeners(Screenshots.class)
public class NewTest extends BaseClass
{
 
  @Test(priority=1)
  public void createCustomerTest() throws Exception
	{
		HomePage hp=PageFactory.initElements(BaseClass.driver, HomePage.class);
		hp.navigateToTasksTab();
		Reporter.log("Navigation to Tasks Tab is Success",true);
		ExcelLib exe=new ExcelLib();
		String customerName=exe.readStringData("customer", 6, 0);
		TaskPage tp=PageFactory.initElements(BaseClass.driver, TaskPage.class);
		tp.createCustomer(customerName);
		Reporter.log("Customer Created Success",true);
		
	}
  
  @Test(priority=2)
  public void createReportTest()
  {
	  ReportsPage rp=PageFactory.initElements(BaseClass.driver, ReportsPage.class);
	  rp.createReport();
	  Reporter.log("Report Created Successfully",true);
	  
  }
  
  @Test(priority=3)
  public void createUsersTest()
  {
	  UsersPage up=PageFactory.initElements(BaseClass.driver, UsersPage.class);
	  up.inviteCustomer();
	  Reporter.log("User Created Successfully",true);
	  
  }
}
