package driverScript;

import java.io.InterruptedIOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandler {
	
	public static WebDriverWait wait = null;
	public static WebDriver driver = null;
	FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver)
			.withTimeout(60, TimeUnit.SECONDS)
			.pollingEvery(5, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);

	public static void main(String[] args) throws InterruptedIOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajuk\\workspace\\python\\Selenium\\drivers\\chromedriver.exe");

		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		

		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);

		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (String child : driver.getWindowHandles()) {

			if (!mainWindow.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);

				driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");

				driver.findElement(By.name("btnLogin")).click();

				// Closing the Child Window.
				driver.close();

			}
		}

		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(mainWindow);
		driver.close();
	}

}
