package testscripts.regression;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;

public class ValidateLogin extends BasePage {
	
	
	
	@Test
	public void validateLoginTest()
	{
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.username("reyaz0617");
		
		loginPage.password("reyaz123");
		
		loginPage.login();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		
	}
	

}
