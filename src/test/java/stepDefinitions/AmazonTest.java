package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import DriversConfig.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonTest {
	
	@Given("user open amazon url")
	public void user_open_amazon_url() {
		DriverFactory.initliaze();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DriverFactory.getDriver().get("https://www.amazon.in");
	}

	@Then("user check title is amazon.in")
	public void user_check_title_is_amazon_in() {
	  Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}


	@When("user search ipad")
	public void user_search_ipad() {
		DriverFactory.getDriver().findElement(By.id("twotabsearchtextbox")).click();
		DriverFactory.getDriver().findElement(By.id("twotabsearchtextbox")).clear();
		DriverFactory.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("ipad");
		DriverFactory.getDriver().findElement(By.id("nav-search-bar-form")).submit();
	}

	@Then("ipad is visible")
	public void ipad_is_visible() {
		Assert.assertEquals(DriverFactory.getDriver().findElement(By.xpath("//div[@data-component-type=\"s-search-result\"][1]//descendant::span[contains(@class,\"a-text-normal\")]")).getText().toLowerCase(), "2020 Apple iPad Air with A14 Bionic chip (10.9-inch/27.69 cm, Wi-Fi, 64GB) - Green (4th Generation)".toLowerCase());
	}

}
