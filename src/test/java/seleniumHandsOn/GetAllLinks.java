package seleniumHandsOn;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllLinks {
	
	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Projects\\UDT\\Git-SourceCode\\HandsOn\\drivers\\chromedriver.exe");

		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://artoftesting.com/selenium-tutorial.html");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for(WebElement e : allLinks) {
			
			System.out.println(e.getText() + " - " + e.getAttribute("href"));
		}
		
		
		driver.close();
		
	}
	

}
