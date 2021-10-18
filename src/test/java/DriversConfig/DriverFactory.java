package DriversConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static void initliaze() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}

}
