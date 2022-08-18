package testscripts.regression;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;
import utils.UtilKit;

public class TC_101 extends BasePage {
	
	@Test(dataProvider="getTestData")
	public void simpleLogin(String username,String password,String expTitle)
	{
		
	   LoginPage 	loginPage=new LoginPage(driver);
	   loginPage.doLogin(username, password);
	   
	   loginPage.verifyLogin(expTitle);
	   
	}
	
	
	@DataProvider
	public Object[][] getTestData() throws IOException
	{
		
		return UtilKit.getData("com.adactin.hotelapp", "Login");
		
	}
	

}
