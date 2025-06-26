package com.web.DreamERA.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.DreamERA.TestBase.TestBase;
import com.web.DreamERA.TestPages.HomePage;

public class HomePageTest extends TestBase
{
	public HomePage home;
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	void init()
	{
		Initilization();
		home=new HomePage();
	}
	
	@AfterMethod
	void teardown()
	{
		driver.quit();
	}
	
	@Test
	void verifyloadloginpage()
	{
		home.click();
		
		String acutalurl=driver.getCurrentUrl();
		
		String expected="https://www.automationexercise.com/login2";
		
		Assert.assertEquals(acutalurl,expected);
		
	}
	
	@Test
	void verifycategoryVisible()
	{
		Assert.assertEquals(true,home.categoryvisibility());
	}
	
	
}
