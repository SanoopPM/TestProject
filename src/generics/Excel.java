package generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getCellValue(String xlpath,String sheet,int row,int cell)
	{
		String v =" ";
		try
		{
			FileInputStream fis=new FileInputStream(xlpath);
			Workbook wb=WorkbookFactory.create(fis);
			v=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			
		}
		return v;
		
	}
	
public static int getRowCount(String xlpath,String sheet)
{
	int rc=0;
	try
	{
		FileInputStream fis=new FileInputStream(xlpath);
		Workbook wb=WorkbookFactory.create(fis);
		rc=wb.getSheet(sheet).getLastRowNum();
	}
	catch(Exception e)
	{
		
	}
	return rc;
}

public static void setCellValue(String xlpath,String sheet,int row,int cell, String Result)
{

	try
	{
		FileInputStream fis=new FileInputStream(xlpath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(Result);
		
		
		FileOutputStream fos = new FileOutputStream(xlpath);
	    wb.write(fos);
	    
	    
	}
	catch(Exception e)
	{
		
	}
	
}

}
