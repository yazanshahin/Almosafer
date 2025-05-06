package almosafer;

import java.awt.im.InputContext;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class MyTestCases extends MyTestData {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@BeforeTest
	public void mySetup() {

		driver.get("https://www.almosafer.com/en?ncr=1");

		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = false)
	public void ChesckTheLanguage() {
		String CheckLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(CheckLanguage, ExpectedLanguage);

	}

	@Test(priority = 2, enabled = false)
	public void CheckDefultCurrency() {

		WebElement Currency = driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG"));
		String ActualCurrency = Currency.getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3, enabled = false)
	public void CheckPhoneNumber() {

		WebElement Element = driver.findElement(By.xpath("//a[@href='https://wa.me/966554400000']"));
		String ActualNumber = Element.getText();
		Assert.assertEquals(ActualNumber, ExpectedNumber);

	}

	@Test(priority = 4, enabled = false)
	public void QitafLogo() throws InterruptedException {
		WebElement Footer = driver.findElement(By.tagName("footer"));
		WebElement QitafLogo = Footer.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR"));

		Boolean ActualResultQitaf = QitafLogo.isDisplayed();

		Assert.assertEquals(ActualResultQitaf, ExpectedLogo);

	}

	@Test(priority = 6, enabled = false)
	public void CheckingFlightDeparture() {

		List<WebElement> Monthspans = driver.findElements(By.cssSelector(".sc-eSePXt.ljMnJa"));
		List<WebElement> dayspans = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		List<WebElement> nameDayspans = driver.findElements(By.cssSelector(".sc-aewfc.dPjtTY"));

		String Month = Monthspans.get(0).getText();
		String day = dayspans.get(0).getText();
		String DayName = nameDayspans.get(0).getText();

		String ActualLeaving = Month + " " + day + "," + " " + DayName;
		Assert.assertEquals(ActualLeaving, ExpectedLeavingDate);

	}

	@Test(priority = 7, enabled = false)
	public void CheckingFlightReturn() {
		List<WebElement> Monthspans = driver.findElements(By.cssSelector(".sc-eSePXt.ljMnJa"));
		List<WebElement> dayspans = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		List<WebElement> nameDayspans = driver.findElements(By.cssSelector(".sc-aewfc.dPjtTY"));

		String Month = Monthspans.get(1).getText();
		String day = dayspans.get(1).getText();
		String DayName = nameDayspans.get(1).getText();

		String ActualReturn = Month + " " + day + "," + " " + DayName;
		Assert.assertEquals(ActualReturn, ExpectedReturnDate);

	}

	@Test(priority = 8, enabled = false)
	public void CheckHotelTab() {
		WebElement Hotels = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		Boolean ActualHotelsTab = Hotels.isSelected();

		Assert.assertEquals(ActualHotelsTab, ExpectedHotelsTab);
	}

	@Test(priority = 9, enabled = false)
	public void CahngeTheLanguage() {
		driver.get(Language);
		String CheckLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		System.out.println(Language);
	}

	@Test(priority = 10, enabled = true)
	public void hotelSearch() throws InterruptedException {

		WebElement HotelsSerach = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelsSerach.click();
		WebElement SerchPar = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
		SerchPar.click();
		String CheckLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		if (CheckLanguage.equals("en")) {
			SerchPar.sendKeys(City);
			TimeUnit.SECONDS.sleep(2);
			SerchPar.sendKeys(Keys.ARROW_DOWN);
			SerchPar.sendKeys(Keys.ENTER);

		} else {
			SerchPar.sendKeys(CityInArabic);
			TimeUnit.SECONDS.sleep(2);
			SerchPar.sendKeys(Keys.ARROW_DOWN);
			SerchPar.sendKeys(Keys.ENTER);
		}
		WebElement SearchButton = driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk"));
		SearchButton.click();
		Thread.sleep(2000);
		WebElement roomInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("mui-1")));
		roomInput.click();

		driver.findElement(By.id("mui-1")).click();
		driver.findElement(By.cssSelector("[data-testid='" + HotelRoom + "']")).click();
		System.out.println(HotelRoom);
		WebElement ButtonSearch = driver.findElement(By.id("mui-2"));
		ButtonSearch.click();

	}

	@Test(priority = 11, enabled = true)
	public void PageFullyLoaded() throws InterruptedException {

		boolean expectedResult = true;
		Thread.sleep(10000);
		String results = driver
				.findElement(By.cssSelector(
						".MuiTypography-root.MuiTypography-heading4SemBld.__ds__comp.undefined.muiltr-13ipltw"))
				.getText();

		boolean ActualResult = results.contains("مكان") || results.contains("found");

		Assert.assertEquals(ActualResult, expectedResult);

	}

}
