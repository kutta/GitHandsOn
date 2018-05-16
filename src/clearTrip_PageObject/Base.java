package clearTrip_PageObject;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver ;
	public static WebElement _WebElement = null;
	static DesiredCapabilities capabilities;
	public static WebDriverWait wait = null;


	public static WebDriver invokeBrowser(String browserName) throws Exception {

		try {

			if (browserName.equalsIgnoreCase("chrome")) {
				
				Map<String, Object> preferences = new Hashtable<String, Object>();
				
				preferences.put("profile.default_content_setting_values.notifications", 2);
				

				ChromeOptions options = new ChromeOptions();
				
				options.setExperimentalOption("prefs", preferences);

				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\KP\\git\\GitHandsOn\\drivers\\chromedriver.exe");

				driver = new ChromeDriver(options);

			}
			wait = new WebDriverWait(driver,Integer.parseInt("20"));
			driver.manage().window().maximize();

		} catch (Exception e) {

			throw (e);

		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void setup() throws Exception{
		
		try {
			
			invokeBrowser("chrome");
			driver.get("https://www.cleartrip.com/");
			Thread.sleep(2000);
		}catch(Exception e) {
			throw(e);
		}
	}
	
	public static void closeBrowser() {

		driver.quit();
		
		
	}

}
