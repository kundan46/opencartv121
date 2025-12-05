package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

/* Data is valid  - login successful -test pass -logout
 * Data is valid - login failed - test fail - no logout
 * Data is invalid -login successful -test fail -logout
 * data is invalid -login unsuccessful -test pass - no logout
 * data is partially valid - login unsuccessful -test pass - no logout
 * data is empty -login unsuccessful -test pass - no logout
 * data is valid but account is locked - login unsuccessful -test pass -no logout
 * data is valid but password expired - login unsuccessful - test pass - no logout
 * data is valid but user not activated - login unsuccessful - test pass - no logout
 * data is valid but user role is incorrect - login unsuccessful - test pass - no logout
 * */

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=utilities.DataProviders.class,groups="DataDriven")
public void verify_LoginDDT(String email,String password,String exp) {
	
		logger.info("**** starting TC003_LoginDDT *****");
		
		try {
			//HomePage
		//HomePage hp=new HomePage(driver);
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
	//Login

		LoginPage lp=new LoginPage(driver);
				lp.setEmail(email);
		
		lp.setPassword(password);
		
	
		lp.clickLogin();
		
		System.out.println("Email from Excel = " + email);
		System.out.println("Password from Excel = " + password);
		System.out.println("Expected result = " + exp);
		
	//MyAccountPage
		MyAccountPage mcc=new MyAccountPage(driver);
		boolean targetPage=mcc.isMyAccountPageExists();
	
		if (exp.equals("Valid")) {
			if (targetPage==true) {
				
				mcc.clickLogoutLink();
				Assert.assertTrue(true);
				
				
			}
			else
			{
				Assert.assertTrue(false);
				
			}
		}
		if (exp.equalsIgnoreCase("Invalid"))
		{
			if (targetPage==true) {
				
				mcc.clickLogoutLink();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}catch (Exception e) 
	{
		Assert.fail();
	}
		
		logger.info("**** Fininshed TC003_LoginDDT *****");
		
}
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
}
