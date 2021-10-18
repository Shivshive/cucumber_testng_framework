package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static ConfigReader reader = null;
	
	private ConfigReader() {
		
	}
	
	public static ConfigReader initialize() {
		if(reader == null) {
			reader = new ConfigReader();
		}
		return reader;
	}
		
	public Properties getProperties(String propName) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = new FileInputStream(new File(classLoader.getResource(propName).getFile()));
		Properties prop = new Properties();
		prop.load(is);
		System.out.println(prop.toString());
		return prop;
	}

}
