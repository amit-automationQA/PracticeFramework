package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase{
	public static String screenshotPath;
	public static String screenshotName;
	public static String captureScreenshot(String testcasename, WebDriver driver) throws IOException {
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		String destinationfile = System.getProperty("user.dir")+File.separator+"target"+File.separator+"surefire-reports"+File.separator+"html"+File.separator+testcasename+screenshotName;
		FileUtils.copyFile(scr, new File(destinationfile));
		return destinationfile;
	}
	
	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		String sheetName="test_suite";
		int rows =excel.getRowCount(sheetName);
		for(int rNum=2; rNum<=rows;rNum++) {
			String testcase = excel.getCellData(sheetName, "TCID", rNum);
			if(testcase.equalsIgnoreCase(testName)) {
				String runmode= excel.getCellData(sheetName, "Runmode", rNum);
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;		
			}
		}
		return false;
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		String sheetName =m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object [][] data= new Object[rows-1][1];
		Hashtable<String,String> table = null;
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			table = new Hashtable<String,String>();
			for(int colNum=0; colNum<cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1),excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0]=table;
			}
		}
		return data;
	}
}


