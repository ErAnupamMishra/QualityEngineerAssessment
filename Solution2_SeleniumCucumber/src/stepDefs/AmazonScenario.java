/**Scenarios/Step Definition file for Amazon E2E shopping
#Author: anupam.mishra13@gmail.com
#Version : 1.0 
#Status :Published
#Summary : Automation Framework in Selenium using Cucumber as BDD Tool for Amazon Shopping E2E Scenario 
*/
package stepDefs;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import cucumber.api.DataTable;
//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonScenario {
	WebDriver driver;

	@Given("^I want to open \"([^\"]*)\" and launch Amazon URL$")
	public void I_want_to_open_and_launch_Amazon_URL(String arg1) throws Throwable {
		// To open Google Chrome for Amazon shopping
		try {
			// check for Browser as Chrome
			if (arg1.equalsIgnoreCase("chrome")) {
				// "./folderName/chromedriver.exe"
				// C:\\Anupam\\chromedriver_win32\\chromedriver.exe
				System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				// configure for other browsers if required
			}
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com.au/");
			System.out.println("Browser is open as expected");
		} catch (Exception e) {
			throw e;
		}
	}

	@And("^I click on Sign-In button$")
	public void I_click_on_Sign_In_button() throws Throwable {
		// Clicking on Sign in page for Amazon
		try {
			driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']")).click();
			driver.findElement(By.xpath("//*[@id='hmenu-customer-name']")).click();
			System.out.println("Sign In Button Clicked");
		} catch (Exception e) {
			throw e;
		}
	}

	@And("^I enter Username with Password$")
	public void I_enter_Username_with_Password() throws Throwable {
		// To Enter Username and Password on Amazon Login Page
		try {
			driver.findElement(By.id("ap_email")).sendKeys("anupam.mishra13@gmail.com");
			driver.findElement(By.id("continue")).click();

			driver.findElement(By.id("ap_password")).sendKeys("amazon&07");

			driver.findElement(By.id("signInSubmit")).click();
			System.out.println("Username and Password is added");
		} catch (Exception e) {
			throw e;
		}

	}

	@When("^I search for an item$")
	public void I_search_for_an_item() throws Throwable {
		// Search for item here it is The Bhagvad Gita Book
		try {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("The Bhagavad Gita");
			driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
			System.out.println("Book is Searched");
		} catch (Exception e) {
			throw e;
		}
	}

	@And("^I select the item$")
	public void I_select_the_item() throws Throwable {
		// Select the required Bhagvad gita book from displayed results
		try {
			driver.findElement(By
					.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-normal') and contains(text(),'The Bhagavad Gita')]"))
					.click();
			System.out.println("Book is Selected");
		} catch (Exception e) {
			throw e;
		}
	}

	@And("^I click on Add to Cart button$")
	public void I_click_on_Add_to_Cart_button() throws Throwable {
		try {
			// Adding the item to cart
			driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
			driver.findElement(By.xpath("//*[@id='hlb-ptc-btn-native']")).click();
			System.out.println("Book is added to Cart as expected");
		} catch (Exception e) {
			throw e;
		}
	}

	@Then("^I validate the Title \"([^\"]*)\"$")
	public void I_validate_the_Title(String arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		try {
			if (driver.getTitle().contains(arg1)) {
				System.out.println(driver.getTitle());
				System.out.println("Title is Verified as expected");
			}

			else {
				System.out.println(driver.getTitle());
				System.out.println("Title is not as expected");
			}
		} catch (Exception e) {
			throw e;
		}

	}

	@And("^I click on Proceed to Checkout button$")
	public void I_click_on_Proceed_to_Checkout_button() throws Throwable {
		try {
			// Selecting Delivery address in Checkout
			driver.findElement(By.id("shipToThisAddressButton")).click();
			System.out.println("Shipping Address is Selected");
		} catch (Exception e) {
			throw e;
		}
	}

	@And("^I Enter the Card Details$")
	public void I_Enter_the_Card_Details() throws Throwable {
		// Providing Dummy Card details for transaction, it will fail here
		// Treating as Last step for Code
		try {

			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@name='addCreditCardNumber']")).click();
			driver.findElement(By.xpath("//*[@name='addCreditCardNumber']")).sendKeys("1234567912345678");
			driver.findElement(By.xpath("//*[@name='ppw-accountHolderName']")).click();
			driver.findElement(By.xpath("//*[@name='ppw-accountHolderName']")).sendKeys("Anupam Mishra");

			Thread.sleep(2000);
			Select expireDate = new Select(driver.findElement(By.xpath("//*[@name='ppw-expirationDate_month']")));
			Thread.sleep(2000);
			expireDate.selectByValue("4");
			Select expireYear = new Select(driver.findElement(By.xpath("//*[@name='ppw-expirationDate_year']")));
			Thread.sleep(2000);
			expireYear.selectByVisibleText("2024");
			driver.findElement(By.xpath("//*[@name='ppw-widgetEvent:AddCreditCardEvent']")).click();
			System.out.println("Dummy Card Details are added... End of Code!!");
		} catch (Exception e) {
			throw e;
		}

	}
	/*
	 * Other features can be used as follows : Log Out of Amazon Successfully
	 * (if transaction is Successful) Success in step Failure in step
	 */
	/*
	 * @And("^I log out of Amazon successfully$") public void
	 * I_log_out_of_Amazon_successfully() throws Throwable { // Express the
	 * Regexp above with the code you wish you had throw new PendingException();
	 * }
	 * 
	 * @Then("^I verify the success in step$") public void
	 * I_verify_the_success_in_step() throws Throwable { // Express the Regexp
	 * above with the code you wish you had throw new PendingException(); }
	 * 
	 * @Then("^I verify the Fail in step$") public void
	 * I_verify_the_Fail_in_step() throws Throwable { // Express the Regexp
	 * above with the code you wish you had throw new PendingException(); }
	 */
}
