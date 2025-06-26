package com.web.DreamERA.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestBase
{
	public static Properties prop;  // Global
	public static WebDriver  driver;
	
	public TestBase()  // Property file read
	{
		try
		{
			prop=new Properties();
					
			FileInputStream fis=new FileInputStream("C:\\Users\\skk\\eclipse-workspace\\com.web.DreamERA\\src\\main\\java\\com\\web\\DreamERA\\config\\config.properties");
			
			prop.load(fis);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

	public void Initilization()
	{
		String browsername=prop.getProperty("browser");
						
		if(browsername.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else 
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));		
	}
}
