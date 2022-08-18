package testscripts.regression;

import java.io.IOException;

import utils.UtilKit;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Object[][] obj=UtilKit.getData("com.adactin.hotelapp", "Book");
		
		System.out.println(obj.length);
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
			System.out.print(obj[i][j]+"\t");
			}
			System.out.println();
		}

	}

}
