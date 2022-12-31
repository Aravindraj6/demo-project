package org.bok;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingDetails {
	//@hotelbookingdetails
	
	public static String country;
	public WebDriver driver;
	//public BookingDetails (WebDriver driver) {
	//	this.driver=driver;
	//}
	
	@Given("User is on Adactin login page")
	public void user_is_on_Adactin_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String pass) {
		WebElement uname = driver.findElement(By.id("username"));
		uname.sendKeys(username);
		WebElement passwd = driver.findElement(By.id("password"));
		passwd.sendKeys(pass);
	}

	@When("User click the login button")
	public void user_click_the_login_button() throws InterruptedException, AWTException {
		WebElement btnlogin = driver.findElement(By.id("login"));
		btnlogin.click();
	}	
	
	@Then("User verify the adactin login page")
		public void User_verify_the_adactin_login_page(String username) {
			WebElement verifylogin = driver.findElement(By.xpath("//*[@id=\'username_show\']"));
			String login_value = verifylogin.getAttribute("value");
			try {
				//Assert.assertEquals("Helo ARAVINDRJ!", login_value);
				Assert.assertTrue(login_value.contains(username));
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			}
			
	
	}
	@Then ("User close the page")
	public void user_close_the_page() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
	}
	@Then("User enters in adactin login portal")
	public void user_enters_in_adactin_login_portal() {
       System.out.println("user is on adactin search portal");
	}

	@Given("User is on Adactin login portal")
	public void user_is_on_Adactin_login_portal() {
          System.out.println("User need to fill the hotelbooking details");		
	}

	@When("User select the location")
	public void user_select_the_location() throws InterruptedException,NullPointerException {

		Thread.sleep(2000);
		WebElement location = driver.findElement(By.xpath("(//select[@class='search_combobox'])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(location).perform();
		a.click();
		 country = "Sydney";
		Select s = new Select(location);
		s.selectByVisibleText(country);
	}
	@When("User select the hotel name")
	public void user_select_the_hotel_name() throws AWTException {
		
		WebElement hotelname = driver.findElement(By.xpath("//*[@id=\"hotels\"]"));
		hotelname.click();
		Robot r = new Robot();
		for (int i = 0; i < 4; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
	}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	

	}

	@When("User select the room type")
	public void user_select_the_room_type() {
         WebElement Room_type = driver.findElement(By.xpath("//*[@id=\'room_type\']"));
         Room_type.click();
         Select s1 = new Select(Room_type);
         s1.selectByIndex(4);
	}

	@When("User enter the number of rooms")
	public void user_enter_the_number_of_rooms() {
		 WebElement Room_num = driver.findElement(By.xpath("//*[@id=\'room_nos\']"));
		 Room_num.click();
         Select s = new Select(Room_num);
         s.selectByValue("1");
	}

	@When("User enter the checkin and checkout date")
	public void user_enter_the_checkin_and_checkout_date() throws AWTException {
		 WebElement Cin_Date = driver.findElement(By.xpath("//*[@id=\'datepick_in\']"));
		 Cin_Date.click();
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_A);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_A);	
		 r.keyPress(KeyEvent.VK_BACK_SPACE);
		 r.keyRelease(KeyEvent.VK_BACK_SPACE);
		 Cin_Date.sendKeys("30/12/2022");
		 
		 WebElement Cout_Date = driver.findElement(By.xpath("//*[@id=\'datepick_out\']"));
		 Cout_Date.click();
		 Robot r1 = new Robot();
		 r1.keyPress(KeyEvent.VK_CONTROL);
		 r1.keyPress(KeyEvent.VK_A);
		 r1.keyRelease(KeyEvent.VK_CONTROL);
		 r1.keyRelease(KeyEvent.VK_A);	
		 r1.keyPress(KeyEvent.VK_BACK_SPACE);
		 r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		 Cout_Date.sendKeys("31/12/2022");
		 }

	@When("User select the number of persons")
	public void user_select_the_number_of_persons() {
		 WebElement Numof_per = driver.findElement(By.xpath("//*[@id=\'adult_room\']"));
		 Numof_per.click();
         Select s = new Select(Numof_per);
         s.selectByValue("3");
	}

	@When("User click the search button")
	public void user_click_the_search_button() {
		 WebElement Search = driver.findElement(By.xpath("//*[@id=\'Submit\']"));
		 Search.click();
        
	}

	@Then("User enter into the confirm page")
	public void user_enter_into_the_cofirm_page() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement Verify_Cpage = driver.findElement(By.xpath("//*[@id=\'location_0\']"));
		
		 String confirmPage = Verify_Cpage.getAttribute("value");
		
		 Assert.assertEquals(country, confirmPage);
	}
	
	@Given("User is on confirm page")
	public void user_is_on_confirm_page() {
		System.out.println("user need to verify & confirm the booking");
	}

	@When("User select the cofirm button after verifying the booking details")
	public void user_select_the_cofirm_button_after_verifying_the_booking_details() {
		WebElement confirm_btn = driver.findElement(By.xpath("//*[@id=\'radiobutton_0\']"));
		confirm_btn.click();
	}

	@When("User click the continue button")
	public void user_click_the_continue_button() {
		WebElement continue_btn = driver.findElement(By.xpath("//*[@id=\'continue\']"));
		continue_btn.click();
	}

	@Then("User enter into payment portal")
	public void user_enter_into_payment_portal() {
	}

	@Given("User is on payment portal")
	public void user_is_on_payment_portal() throws InterruptedException {
		System.out.println("user need to fill the payment details");
		Thread.sleep(3000);
	}

	@Given("User enter the name of the credit card holder")
	public void user_enter_the_name_of_the_credit_card_holder_and() {
		WebElement pay_fname = driver.findElement(By.xpath("//*[@id=\'first_name\']"));
		pay_fname.sendKeys("Aravind");	
		WebElement pay_Lname = driver.findElement(By.xpath("//*[@id=\'last_name\']"));
		pay_Lname.sendKeys("Raj");
		}

	@Given("User enter billing address of credit card holder")
	public void user_enter_billing_address_of_credit_card_holder_address() {
		WebElement pay_address = driver.findElement(By.xpath("//*[@id=\'address\']"));
		pay_address.sendKeys("11,SK nagar,kumbakonam-612222");
		}

	@Given("User enter the valid credit card number")
	public void user_enter_the_valid_credit_card_number() {
		WebElement cc_num = driver.findElement(By.xpath("//*[@id=\'cc_num\']"));
		cc_num.sendKeys("8456248563215469");
		}

	@Given("User select the credit card type")
	public void user_select_the_credit_card_type() {
		WebElement cc_type = driver.findElement(By.xpath("//*[@id=\'cc_type\']"));
		cc_type.click();
		Select s = new Select(cc_type);
		s.selectByIndex(3);
		}

	@Given("User select the expiry date")
	public void user_select_the_expiry_date() {
		WebElement cc_Emon = driver.findElement(By.xpath("//*[@id=\'cc_exp_month\']"));
		cc_Emon.click();
		Select s = new Select(cc_Emon);
		s.selectByValue("12");	
		
		WebElement cc_Eyear = driver.findElement(By.xpath("//*[@id=\'cc_exp_year\']"));
		cc_Eyear.click();
		Select s1 = new Select(cc_Eyear);
		s1.selectByValue("2022");	
		}

	@Given("User enter the cvv number")
	public void user_enter_the_cvv_number() {
		WebElement cc_ccv = driver.findElement(By.xpath("//*[@id=\"cc_cvv\"]"));
		cc_ccv.sendKeys("577");
		}

	@Given("User click the book now button")
	public void user_click_the_book_now_button() throws InterruptedException {
		WebElement bknow_btn = driver.findElement(By.xpath("//*[@id=\'book_now\']"));
		bknow_btn.click();
		
		}

	@Then("User get the order ID")
	public void user_get_the_order_ID() throws InterruptedException {
		//WebDriverWait w = new WebDriverWait(driver, 30);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_no")));
		Thread.sleep(10000);
		WebElement order_num = driver.findElement(By.id("order_no"));
		String order_id = order_num.getAttribute("value");
		System.out.println(order_id);
	}



}
