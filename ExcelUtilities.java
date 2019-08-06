package com.actitime.generic;

import java.awt.font.NumericShaper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Abhishek
 * @Date 06/08/2019 @time 16:50:32
 *
 */
public class ExcelUtilities 
{
String filepath;
public ExcelUtilities(String filepath)
{
	this.filepath=filepath;
}

public void ReadData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
{
String value=null;
FileInputStream fis =new FileInputStream(new File(filepath));
Workbook wb = WorkbookFactory.create(fis);
Cell cl = wb.getSheet(sheetname).getRow(row).getCell(cell);
switch (cl.getCellType()) 
{
case STRING:
	
	
	break;
case NUMERIC:
	
	
	break;
case BOOLEAN:
	
	
	break;

default:
	break;
}
}
}
