package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.BasePage;

public class UtilKit extends BasePage{
	
	
	static String reourceFolder ="src\\test\\resources\\";
	
	public void initTest()
	{
		
		
	}
	
	public void closeTest()
	{
		
		driver.quit();
	}
	
	
	public static Object[][] getData(String appName,String testcase) throws IOException
	{
		
		FileInputStream fis=new FileInputStream(reourceFolder+"MasterTestData.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet(appName);
		
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		testCaseRows = findRows(ws,testcase);	
		
		System.out.println(testCaseRows.size());
		
		System.out.println(testCaseRows.get(1).getLastCellNum());
		
		Object[][] obj=new Object[testCaseRows.size()-1][testCaseRows.get(0).getLastCellNum()-1];
		
		for(int i=0;i<testCaseRows.size()-1;i++)
		{
			for(int j=0;j<testCaseRows.get(0).getLastCellNum()-1;j++)
			{
			obj[i][j]=testCaseRows.get(i+1).getCell(j+1).toString();
			System.out.println("["+i+"]"+"["+j+"]"+"===="+obj[i][j]+"\t");
			}
			System.out.println();
		}
		
		return obj;
		
		
	}
	
	
	public static ArrayList<Row> findRows(Sheet ws,String testCase)
	{
		
		ArrayList<Row> rows=new ArrayList<Row>();
		
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		System.out.println(ws.getPhysicalNumberOfRows());
		
		System.out.println(ws.getLastRowNum());
		
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(!(ws.getRow(i)==null))
					{
				
				rows.add(ws.getRow(i));
					}
			
		}
		
		System.out.println(rows.size());
		
		
		for(int i=0;i<rows.size();i++)
		{
			
			if(rows.get(i).getCell(0).getStringCellValue().equals(testCase))
			{
				testCaseRows.add(rows.get(i));
				
			}
			
		}
		
		
		return testCaseRows;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
