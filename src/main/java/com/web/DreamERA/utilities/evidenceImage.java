package com.web.DreamERA.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.web.DreamERA.TestBase.TestBase;

public class evidenceImage extends TestBase
{

	public String CaptureScreen(String tname) throws IOException
	{
		
		  String timestamp=new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
		  
		  TakesScreenshot shot=(TakesScreenshot)driver;
		  
		  File src=shot.getScreenshotAs(OutputType.FILE);
		  
		  String target=System.getProperty("user.dir")+"\\Sreenshots\\"+tname+"_"+timestamp+".png";
		  
		  File f=new File(target);
		  
		  //src.renameTo(f);
		  
		 FileUtils.copyFile(src, f);
		  
		 return target;
	}
	
}
