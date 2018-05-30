package com.actitime.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.actitime.base.TestBase;

public class Utility extends TestBase{

	
// ######################### ##################    Data Driven Implementation    ###############################################################

		String path="D:\\java\\New Eclipse\\WebAdminTest\\ActiTime_Regression_Automation\\src\\main\\java\\com\\actitime\\testdata\\ActiTimeTestData.xlsx";
		
		Workbook workbook;
		  Sheet sheet;
	public  Object[][] getTestData(String sheetname)
	{
	
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(path);
			workbook=WorkbookFactory.create(fis);
		System.out.println("success3");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetname);

		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
		
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
	
			}
			
		}
		
	

		return data;
		
	}
	
	public static boolean getInputResult(String val)
	{
		if(val.equalsIgnoreCase("pass"))
			return true;
		else
			return false;
		
	}
	
//################################################ Taking Screenshot  ################################################################
	
	public static void takeScreenshotAtEndOfTest() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		}
		
		
		
	
	
	
	
}
