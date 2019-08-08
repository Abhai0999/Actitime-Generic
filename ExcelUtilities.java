package com.actitime.generic;
import java.awt.font.NumericShaper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
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
/**
 * @author Abhishek
 * @param sheetname
 * @param row
 * @param cell
 * @return String
 */

public  String ReadData(String sheetname,int row,int cell)
{
	String value=null;
try {
	
	FileInputStream fis =new FileInputStream(new File(filepath));
	Workbook wb = WorkbookFactory.create(fis);
	Cell cl = wb.getSheet(sheetname).getRow(row).getCell(cell);
	switch (cl.getCellType()) 
	{
	case STRING:
		value=cl.getStringCellValue();
		//System.out.println(value);
		break;
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cl)) 
		{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");	
		value=sdf.format(cl.getDateCellValue());
		}
		else
		{
			Long longvalue = (long) cl.getNumericCellValue();
			value=Long.toString(longvalue);	
		}
		break;
	case BOOLEAN:
		boolean bool = cl.getBooleanCellValue();
		value=Boolean.toString(bool);
		break;
	default:
		break;
	}
} 
catch (EncryptedDocumentException e) 
{

}
catch (IOException e) {
}
return value;

}}
