package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	
	@FindBy(xpath="//title")
	WebElement title;
	
	
	public void username(String usernameText)
	{
		username.sendKeys(usernameText);
	}
	
	public void password(String passwordText)
	{
		password.sendKeys(passwordText);
	}
	
	public void login()
	{
		
		login.click();
	}
	
	public String getTitle()
	{
		return title.getText();
	}

	
	public void doLogin(String usernameText,String passwordText)
	{
		username.sendKeys(usernameText);
		password.sendKeys(passwordText);
		login.click();
	}
	
	
	public boolean verifyLogin(String expTitle)
	{
		
		return getTitle().equalsIgnoreCase(expTitle);
	}
	
	
	
	
	
	
	
}
