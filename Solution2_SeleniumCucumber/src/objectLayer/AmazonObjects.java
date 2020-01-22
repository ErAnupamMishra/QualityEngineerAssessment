/**Scenarios/Object file for Amazon E2E shopping
#Author: anupam.mishra13@gmail.com
#Version : 1.0 
#Status :Published
#Summary : Automation Framework in Selenium using Cucumber as BDD Tool for Amazon Shopping E2E Scenario 
*/
package objectLayer;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import cucumber.api.DataTable;
//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AmazonObjects {
	static WebDriver driver;

	static By searchTextBox = By.id("twotabsearchtextbox");
	static By searchBtn = By.xpath("//*[@id='nav-search']/form/div[2]/div/input");

	public AmazonObjects(WebDriver driver) {
		this.driver = driver;
	}

	public static void setSearchBox(String searchitem) {
		driver.findElement(searchTextBox).sendKeys(searchitem);
	}

	public static void clicksearchBtn() {
		driver.findElement(searchBtn).click();
	}
}
