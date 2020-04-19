package clearTrip_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends Base {

	
	public void searchRoundTripFlight(String source, String destination) throws Exception {

		try {

			System.out.println("Driver value :: " + driver);

			driver.findElement(By.xpath("//form/nav/ul/li[2]/label/input[@value='RoundTrip']")).click();

			driver.findElement(By.xpath("//*[@id='FromTag']")).sendKeys(source);
			/* Thread.sleep(2000); */

			driver.findElement(By.xpath(".//ul/li/a[text()='" + source + "']")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='ToTag']")).sendKeys(destination);
			/* Thread.sleep(2000); */

			driver.findElement(By.xpath(".//ul/li/a[text()='" + destination + "']")).click();
			Thread.sleep(2000);

			// Find the date time picker control
			driver.findElement(By.xpath("//*[@id='DepartDate']")).sendKeys("Thu, 17 May, 2018", Keys.TAB);

			driver.findElement(By.xpath("//*[@id='ReturnDate']")).sendKeys("Thu, 25 May, 2018", Keys.TAB);

			Thread.sleep(2000);

			Select adults = new Select(driver.findElement(By.xpath(".//*[@id='Adults']")));

			adults.selectByValue("2");

			driver.findElement(By.xpath("//*[@id='SearchBtn']")).click();
			Thread.sleep(2000);

		} catch (Exception e) {
			throw (e);
		}

	}

}
