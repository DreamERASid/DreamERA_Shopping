package com.web.DreamERA.utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;


public class Dataproviders
{
	
	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException
	{
		
		String path="C:\\Users\\skk\\Desktop\\TestData.xlsx";
		
		ExcelUtility e=new ExcelUtility(path);
		
		int totalrows=e.getrowcount("sheet1");
		int totalcols=e.getcellcount("sheet1",1);
		
		String logindata[][]=new  String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<=totalcols-1;j++)
			{
				logindata[i-1][j]=e.getCellData("sheet1", i, j);
			}
		}
		
		return logindata;
	}
	
 }
