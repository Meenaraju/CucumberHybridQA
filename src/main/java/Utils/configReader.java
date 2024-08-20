package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	
	public Properties initializeProperties() {
		
		Properties prop = new Properties();
		File path = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Config\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return prop;
	}

}
