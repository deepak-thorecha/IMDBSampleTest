package test.IMDB.Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static final String HOME_URL = "http://www.imdb.com/";
	public static final String FORCE_LOGOUT_URL = "https://www.imdb.com/registration/logout?ref_=nv_usr_lgout_6";

	public static final String USERDETAILS_FILEPATH = System.getProperty("user.dir")+"/UserDetails.properties";

	private static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(String browser) {
		
		boolean isMac = true;
		if(System.getProperty("os.name").startsWith("Windows"))
			isMac = false;
		
		if(browser.contentEquals("CHROME")) {
			if(isMac)
				System.setProperty("webdriver.chrome.driver", "chromedriver");
			else
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			if(isMac)
				System.setProperty("webdriver.gecko.driver", "geckodriver");
			else
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static String timeStamp() {
		return System.currentTimeMillis()+"";
	}

	public static Map<String, String> readPropertiesFor(String filePath){

		File file = new File(filePath);
		Properties prop = new Properties();
		Map<String, String> data = new HashMap<String, String>();
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(file.getPath()));

			Set<Object> keys = properties.keySet();
			Iterator<Object> iterateKeys = keys.iterator();

			while(iterateKeys.hasNext()){
				String key = iterateKeys.next().toString();
				data.put(key, properties.getProperty(key));
			}
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
