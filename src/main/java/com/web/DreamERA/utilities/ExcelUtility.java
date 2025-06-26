package com.web.DreamERA.utilities;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility
{
 public FileInputStream fis;
 public XSSFWorkbook workbook;
 public XSSFSheet sheet;
 public XSSFRow row;
 public XSSFCell cell;
 
 String path;
 
 public ExcelUtility(String path)
 {
	 this.path=path;
 }
 
 public int  getrowcount(String sheetname) throws IOException
 {
	 fis=new FileInputStream(path);
	 workbook=new XSSFWorkbook(fis);
	 sheet=workbook.getSheet(sheetname);
	 int rowcount=sheet.getLastRowNum();
	 workbook.close();
	 fis.close();
	 return rowcount;
 }
 
 public int getcellcount(String sheetname, int rownum) throws IOException
 {
	 fis=new FileInputStream(path);
	 workbook=new XSSFWorkbook(fis);
	 sheet=workbook.getSheet(sheetname);
	 row=sheet.getRow(rownum);
	 int cellcount=row.getLastCellNum();
	 workbook.close();
	 fis.close();
	 return cellcount;
 }
 
 public String getCellData(String sheetname, int rownum, int colnum) throws IOException
 {
	 
	 fis=new FileInputStream(path);
	 workbook=new XSSFWorkbook(fis);
	 sheet=workbook.getSheet(sheetname);
	 row=sheet.getRow(rownum);
	 cell=row.getCell(colnum);
	 
	 DataFormatter fromatter=new DataFormatter();
	 String data;
	 try
	 {
		 data=fromatter.formatCellValue(cell);
	 }catch(Exception e) {
		 data="";
	 } 
	 
	 workbook.close();
	 fis.close();
	 return data;
}

}