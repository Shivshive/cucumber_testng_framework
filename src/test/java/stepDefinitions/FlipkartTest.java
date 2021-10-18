package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import DriversConfig.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartTest {

	@Given("user open Flipkart url")
	public void user_open_flipkart_url() {
		DriverFactory.initliaze();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DriverFactory.getDriver().get("https://www.flipkart.com/");
		if(DriverFactory.getDriver().findElement(By.xpath("//button[contains(text(),\"✕\")]")).isDisplayed()) {
			DriverFactory.getDriver().findElement(By.xpath("//button[contains(text(),\"✕\")]")).click();
		}
	}

	@Then("user check title is Flipkart.com")
	public void user_check_title_is_flipkart_com() {
		Assert.assertEquals(DriverFactory.getDriver().getTitle().toLowerCase(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!".toLowerCase());
	}

	@When("user search ipad on Flipkart")
	public void user_search_ipad_on_flipkart() {
		DriverFactory.getDriver().findElement(By.name("q")).click();
		DriverFactory.getDriver().findElement(By.name("q")).clear();
		DriverFactory.getDriver().findElement(By.name("q")).sendKeys("ipad");
		DriverFactory.getDriver().findElement(By.cssSelector("._2M8cLY")).submit();
	}

	@Then("ipad is visible on Flipakrt")
	public void ipad_is_visible_on_flipakrt() {
		Assert.assertEquals(DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).getText().toLowerCase().contains("APPLE iPad Air (4th Gen) 64 GB ROM 10.9 inch".toLowerCase()),true );
	}

}
