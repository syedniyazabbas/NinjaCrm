package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/ninjacrmTest.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		fis.close();
		return value;
	}

}
