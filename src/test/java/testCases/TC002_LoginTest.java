package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"sanity","master"})
	public void verify_login()
	{
		logger.info("**** Starting TC002_LoginTest *****");	
	
		try
		{
	//HomePage hp=new HomePage(driver);
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
	
	lp.setPassword(p.getProperty("password"));
	
	lp.clickLogin();
	
	MyAccountPage mcc=new MyAccountPage(driver);
	boolean targetPage=mcc.isMyAccountPageExists();
	
	Assert.assertTrue(targetPage); //Assert.assertEquals(true,"Login failed");
	
	}
	catch (Exception e) 
	{
		Assert.fail();
	}
	
	logger.info("**** Finished TC002_LoginTest ******");
	}
	

	
}
