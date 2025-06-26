package com.web.DreamERA.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.web.DreamERA.TestBase.TestBase;

public class LoginPage extends TestBase
{
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement userid;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginbutton;
  
	
	public void enterusername(String uname)
	{
		userid.sendKeys(uname);
	}
	
	public void enterpassword(String upsw)
	{
		password.sendKeys(upsw);
	}
	
	public void clicklogin()
	{
		loginbutton.click();
	}
	
}
