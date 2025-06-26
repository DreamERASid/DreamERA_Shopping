package com.web.DreamERA.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.web.DreamERA.TestBase.TestBase;

public class HomePage extends TestBase
{
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Page Factory 
	
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement loginLink;

	@FindBy(xpath = "//h2[normalize-space()='Category']")
	WebElement category;
	
	
	public void click()
	{
		loginLink.click();
	}
	
	public boolean categoryvisibility()
	{
		boolean status=category.isDisplayed();
		
		return status;
	}
}
