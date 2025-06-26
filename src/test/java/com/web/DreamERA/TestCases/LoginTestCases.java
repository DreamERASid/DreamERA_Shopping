package com.web.DreamERA.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.web.DreamERA.TestBase.TestBase;
import com.web.DreamERA.TestPages.HomePage;
import com.web.DreamERA.TestPages.LoginPage;
import com.web.DreamERA.TestPages.dashboard;

public class LoginTestCases extends TestBase
{
	
	HomePage home;
	LoginPage login;
	dashboard dash;
	LoginTestCases()
	{
		super();
	}
	
	@BeforeMethod
	void init()
	{
		Initilization();
		home=new HomePage();
		login=new LoginPage();
		dash=new dashboard();
	}
	
	@AfterMethod
	void teardown()
	{
		driver.quit();
	}
	
	@Test
	void verify_valid_login()
	{
		home.click();
		login.enterusername("siddhant@test.com");
		login.enterpassword("123");
		login.clicklogin();
		
		String expecteduser=dash.loggedinuser();
		
		assertEquals(expecteduser, "Siddhant");
		
	}
	
	@Test(dataProvider = "LoginData", dataProviderClass =com.web.DreamERA.utilities.Dataproviders.class)
	void verify_Excel_login(String user,String psw)
	{
		home.click();
		login.enterusername(user);
		login.enterpassword(psw);
		login.clicklogin();
		
		String expecteduser=dash.loggedinuser();
		
		assertEquals(expecteduser, "Siddhant");
		
	}
}
