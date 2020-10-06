package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlRequest;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlResponse;
import utils.PropertyHelper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;

public class Base extends PropertyHelper {

	final static Logger Log = Logger.getLogger(Base.class.getName());

	// ThreadLocal will keep local copy of driver
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	 public static WebDriver driver = null; 
	/* public static RemoteWebDriver driver = null; */
	public static DesiredCapabilities capabilities = null;

	public void invokeGridSetup(String browser) throws Exception, MalformedURLException {
		String hubUrl = "http://192.168.0.104:4445/wd/hub";

		boolean headLess = false;

		try {

			if (browser.equals("chrome")) {

				ChromeOptions co = new ChromeOptions();
				co.setHeadless(headLess);

				capabilities = DesiredCapabilities.chrome();
				capabilities.setPlatform(Platform.LINUX);
				capabilities.setJavascriptEnabled(false);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				co.addArguments("--disable-extensions");
				co.addArguments("start-maximized");
				co.addArguments("disable-infobars");

				co.merge(capabilities);
				driver = new RemoteWebDriver(new URL(hubUrl), co);

			} else if (browser.equals("firefox")) {

				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setJavascriptEnabled(true);

				FirefoxOptions fo = new FirefoxOptions();
				fo.setHeadless(headLess);
				fo.merge(capabilities);
				driver = new RemoteWebDriver(new URL(hubUrl), fo);

			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

	}

	@BeforeTest
	@Parameters("browser")
	public static void invokeBrowser(String browser) throws MalformedURLException {

		try {
			if (browser.equals("chrome")) {

				Map<String, Object> preferences = new Hashtable<String, Object>();
				preferences.put("profile.default_content_settings.popups", 0);
				preferences.put("download.prompt_for_download", "false");

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				options.addArguments("start-maximized");
				options.addArguments("disable-infobars");
				options.setExperimentalOption("prefs", preferences);

				capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				options.merge(capabilities);

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);

			} else if (browser.equals("firefox")) {

				FirefoxOptions foptions = new FirefoxOptions();
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setJavascriptEnabled(true);

				foptions.merge(capabilities);

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(foptions);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDown() {
		try {

			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void invokeAWSDeviceFarm(String browser) throws IOException {

		AwsSessionCredentials awsSessionCred = AwsSessionCredentials.create(readProperty("accessKey"),
				readProperty("secretAccessKey"), readProperty("sessionToken"));
		DeviceFarmClient client = DeviceFarmClient.builder()
				.credentialsProvider(StaticCredentialsProvider.create(awsSessionCred)).region(Region.US_WEST_2).build();
		CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder().expiresInSeconds(300)
				.projectArn(readProperty("myProjectARN")).build();

		URL testGridUrl = null;
		try {
			CreateTestGridUrlResponse response = client.createTestGridUrl(request);
			testGridUrl = new URL(response.url());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (browser.equals("chrome")) {
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("browserName", "chrome");
				capabilities.setCapability("browserVersion", "latest");
				capabilities.setCapability("platform", "windows");
				driver = new RemoteWebDriver(testGridUrl, capabilities);
			} else if (browser.equals("firefox")) {
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("browserName", "firefox");
				capabilities.setCapability("browserVersion", "latest");
				capabilities.setCapability("platform", "windows");
				driver = new RemoteWebDriver(testGridUrl, capabilities);
			} else if (browser.equals("internet explorer")) {
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("browserName", "internet explorer");
				capabilities.setCapability("browserVersion", "latest");
				capabilities.setCapability("platform", "windows");
				driver = new RemoteWebDriver(testGridUrl, capabilities);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
