package clearTrip_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightSearchPage extends Base{
	
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	public void searchRoundTripFlight(String source, String destination) throws Exception{
		
		try {
			
			System.out.println("Driver value :: "+driver);
			
			driver.findElement(By.xpath("//form/nav/ul/li[2]/label/input[@value='RoundTrip']")).click();
			
			
			
			driver.findElement(By.xpath("//*[@id='FromTag']")).sendKeys(source);
			/*Thread.sleep(2000);*/
			
			
			driver.findElement(By.xpath(".//ul/li/a[text()='"+source+"']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='ToTag']")).sendKeys(destination);
			/*Thread.sleep(2000);*/
			
			driver.findElement(By.xpath(".//ul/li/a[text()='"+destination+"']")).click();
			Thread.sleep(2000);
			
			 //Find the date time picker control
			driver.findElement(By.xpath("//*[@id='DepartDate']")).click();
			
			//Departure date
			String date = "18-5";
			String splitter[] = date.split("-");
			String Day = splitter[0];
			String Month = splitter[1];
			
			
			System.out.println(Day+" "+Month);
			
			List<WebElement> element = driver.findElements(By.xpath(".//div[@class='ctDatePicker']"));
			
			for(int i=0; i<element.size();i++) {
				System.out.println(element.get(i).getText());
				
				if(element.get(i).equals(Month)) {
					
					List<WebElement> days = driver.findElements(By.xpath(".//div[@class='ctDatePicker']/div[@class='monthBlock first']["+i+1+"]/table/tbody/tr/td/span"));
					
					for(WebElement e : days) {
						
						System.out.println(e.getText());
						
						if(e.getText().equals(Day)) {
							e.click();
							return;
						}
					}
				}
			}
			
			/*//Find the date time picker control
					WebElement returnDate = driver.findElement(By.xpath("//*[@id='ReturnDate']"));
					
					//Departure date
					returnDate.sendKeys("05202018");
			
					
					driver.findElement(By.xpath("//*[@id='SearchBtn']")).click();
					Thread.sleep(2000);*/
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
