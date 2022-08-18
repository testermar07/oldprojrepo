package testscripts.regression;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class TC_104 extends BasePage {
	
	@Test(dataProvider="getTestData")
	public void testCase104(String username,String password,String location,String hotel,String roomType,String noOfRooms,String checkInDate,String checkOutDate,String adultsPerRoom,String childernPerRoom) throws InterruptedException
	{
		
		LoginPage	loginPage=new LoginPage(driver);
		loginPage.doLogin(username, password);
		loginPage.verifyLogin("Adactin.com - Search Hotel");
		
		SearchHotelPage searchHotelPage=new SearchHotelPage(driver);
		
		searchHotelPage.location(location);
		searchHotelPage.hotels(hotel);
		searchHotelPage.roomType(roomType);
		searchHotelPage.numberofRooms(noOfRooms);
		searchHotelPage.checkInDate(checkInDate);
		Thread.sleep(5000);
		searchHotelPage.checkOutDate(checkOutDate);
		Thread.sleep(5000);
		searchHotelPage.adultsperRoom(adultsPerRoom);
		searchHotelPage.childrenperRoom(childernPerRoom);
		searchHotelPage.search();
		
		searchHotelPage.verifySearch("Adactin.com - Select Hotel");
		
	}
	
	@DataProvider
	public Object[][] getTestData() throws IOException
	{
		
		return UtilKit.getData("com.adactin.hotelapp", "TC-104");
		
	}
	

}
