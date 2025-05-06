package almosafer;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MyTestData {
	Random random = new Random();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, EEEE");

	String ExpectedLanguage = "en";
	String ExpectedNumber = "+966554400000";
	String ExpectedCurrency = "SAR";
	Boolean ExpectedLogo = true;
	LocalDate LeavingDate = LocalDate.now().plusDays(1);
	String ExpectedLeavingDate = LeavingDate.format(formatter);
	LocalDate ExpectedComeingDate = LocalDate.now().plusDays(2);
	String ExpectedReturnDate = ExpectedComeingDate.format(formatter);
	Boolean ExpectedHotelsTab = false;
	String[] languages = { "'https://www.almosafer.com/en?ncr=1\'", "https://www.almosafer.com/ar?ncr=1" };

	int index = random.nextInt(languages.length);
	String Language = languages[index];

	String[] StateInEnglish = { "Dubai", "Jeddah", "Riyadh" };
	String[] StateInArabic = { "دبي", "جدة"};
	
	int indexForStateArabic = random.nextInt(StateInArabic.length);
	String CityInArabic = StateInEnglish[indexForStateArabic];

	int indexForState = random.nextInt(StateInEnglish.length);
	String City = StateInEnglish[indexForState];
	//HotleRoom
	String[] Room = { "DesktopSearchWidget_Guests_Reservation_Option_Test_Id_A_0", "DesktopSearchWidget_Guests_Reservation_Option_Test_Id_B_1" };
	int RandomIndexForRoom= random.nextInt(Room.length);
	String HotelRoom = Room[RandomIndexForRoom];

	
	Boolean expectedResult = true;
}
