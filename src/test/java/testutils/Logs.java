package testutils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.model.Log;

public class Logs {
	
	private static Logger logger = Logger.getLogger(Logs.class);
	private static Logs log= null;
	
	static {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("date.now", format.format(new Date()));
	}
	
	private Logs() {
		PropertyConfigurator.configure(readLog4j());
	}

	public static Logger getLogger() {
		if(log==null) {
			log=new Logs();
		}
		return logger;
	}

	private static Properties readLog4j() {
		Properties log4j = null;
		try {
			log4j = ConfigReader.initialize().getProperties("log4j.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return log4j;
	}
	
}
