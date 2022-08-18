package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage {

	public SearchHotelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='location']")
	WebElement location;
	@FindBy(xpath = "//select[@name='hotels']")
	WebElement hotels;
	@FindBy(xpath = "//select[@id='room_type']")
	WebElement roomType;
	@FindBy(xpath = "//select[@id='room_nos']")
	WebElement numberofRooms;
	@FindBy(xpath = "//input[@name='datepick_in']")
	WebElement checkInDate;
	@FindBy(xpath = "//input[@name='datepick_out']")
	WebElement checkOutDate;
	@FindBy(xpath = "//select[@name='adult_room']")
	WebElement adultsperRoom;
	@FindBy(xpath = "//select[@name='child_room']")
	WebElement childrenperRoom;
	@FindBy(xpath = "//input[@name='Submit']")
	WebElement search;
	@FindBy(xpath="//span[@id='checkin_span']")
	WebElement checkinError;
	@FindBy(xpath="//title")
	WebElement title;
	
	
			

	public void location(String locationText) {

		new Select(location).selectByVisibleText(locationText);

	}

	public void hotels(String hotelText) {
		new Select(hotels).selectByVisibleText(hotelText);
	}

	public void roomType(String roomTypeText) {
		new Select(roomType).selectByVisibleText(roomTypeText);
	}

	public void numberofRooms(String numberofRoomsText) {
		new Select(numberofRooms).selectByVisibleText(numberofRoomsText);
	}

	public void checkInDate(String checkInDateText) {
		
		checkInDate.clear();
		checkInDate.sendKeys(checkInDateText);
	}

	public void checkOutDate(String checkOutDateText) {
		checkOutDate.clear();
		checkOutDate.sendKeys(checkOutDateText);
	}

	public void adultsperRoom(String adultsperRoomText) {
		new Select(adultsperRoom).selectByVisibleText(adultsperRoomText);
	}

	public void childrenperRoom(String childrenperRoomText) {
		new Select(childrenperRoom).selectByVisibleText(childrenperRoomText);
	}

	
	public void search() {
		search.click();
	}
	
	public String checkinError()
	{
		return checkinError.getText();
	}

	public String getTitle()
	{
		return title.getText();
	}
	
	public boolean verifySearch(String expTitle)
	{
		
		return getTitle().equalsIgnoreCase(expTitle);
	}
	
}
