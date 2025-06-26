package com.web.DreamERA.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.web.DreamERA.TestBase.TestBase;

public class dashboard extends TestBase
{
	public dashboard()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//b[normalize-space()='Siddhant']")
	WebElement username;
	
	public String loggedinuser()
	{
		String uname= username.getText();
		return uname;
	}
	
}
