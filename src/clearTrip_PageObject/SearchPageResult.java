package clearTrip_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageResult extends Base{
	
	public void searchFlighResult() throws Exception{
		
		String max;
		
		List<WebElement> row = driver.findElements(By.xpath(".//div/nav/ul/li/div/label/table/tbody"));
		for(int i=0; i<row.size(); i++) {
			
			max = driver.findElement(By.xpath("(.//nav/ul/li/div/label/table/tbody/tr/th[6])")).getText();
			
			System.out.println(max);
		}
	}

}
