package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import utils.UtilKit;

public class BasePage {

	public static WebDriver driver;
	
	public UtilKit util;

	public FileInputStream fis1;
	public Properties pr1 ;

	@BeforeTest
	public void fileSetUp() throws IOException {
		

	}

	@BeforeMethod
	public void setUp() throws IOException {
		
	fis1 = new FileInputStream("Properties\\config.properties");
	pr1 = new Properties();
	pr1.load(fis1);

	String browser=pr1.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		
		driver=new ChromeDriver();
		
		}
	
	driver.get(pr1.getProperty("url"));
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Long.parseLong(pr1.getProperty("implicitWait")), TimeUnit.SECONDS);

		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.close();
	}

}
