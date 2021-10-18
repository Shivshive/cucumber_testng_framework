package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import DriversConfig.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testutils.Logs;

public class Hooks {
	
	@Before
	public void beforeSc(Scenario sc) {
		Logs.getLogger().info(sc.getName()+" is started");
	}

	@After
	public void afterSc(Scenario sc) throws IOException {
		Logs.getLogger().info(sc.getName()+" is finished");
		sc.attach(getByteScreenshot(), "image/png", sc.getName()+"_"+new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date()));
		DriverFactory.getDriver().quit();
	}
	
	public static byte[] getByteScreenshot() throws IOException 
	{
	    File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
	    byte[] fileContent = FileUtils.readFileToByteArray(src);
	    return fileContent;
	}
}
