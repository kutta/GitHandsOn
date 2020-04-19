package seleniumHandsOn;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class WindowsHandler {
	
	public static WebDriverWait wait = null;
	public static WebDriver driver = null;
	FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver)
			.withTimeout(60, TimeUnit.SECONDS)
			.pollingEvery(5, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);
	
	
	public static void main(String[] args) throws IOException, ParseException{
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Projects\\UDT\\Git-SourceCode\\HandsOn\\drivers\\chromedriver.exe");

		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		 windowsHandler(); 
		/* dynamicValuesHandler(); */
		/* dynamicValuesMaxPrice(); */
		
		/*getAllValuesfromTable();*/
		
		/*isFrameSamp();*/
		 takeScreenshot(); 
		
	}

	
	public static void windowsHandler() throws InterruptedIOException {

		

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
	
	/*Fetch cell value of a particular row and column of the Dynamic Table*/
	public static void dynamicValuesHandler() throws IOException{
		
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa?");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement baseTable = driver.findElement(By.tagName("table"));
		
		WebElement rowCount = baseTable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
		
		WebElement rowCountText = baseTable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[1]"));
		
		String rowText = rowCountText.getText();
		
		System.out.println("Row text :: "+ rowText);
		
		WebElement columnCount = rowCount.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[2]"));
		
		String columnText = columnCount.getText();
		System.out.println("Cell Value is :: "+columnText);
		
		driver.close();
	}

	/*Get Maximum of all the Values in a Column of Dynamic Table*/
	public static void dynamicValuesMaxPrice() throws IOException, ParseException {
		
		String max;
		double m =0, n =0;

		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa?");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> row = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		
		System.out.println("Row count size :: "+ row.size());
		
		List<WebElement> col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));

		System.out.println("Column count size ::" + col.size());
		
		for(int i = 1; i<row.size();i++) {
			
			max = driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
			
			NumberFormat nf = NumberFormat.getNumberInstance();
			
			Number num = nf.parse(max);
			
			max = num.toString();
			
			m = Double.parseDouble(max);
			
			if(m > n) {
				
				n = m;
			}
		}
		
		System.out.println("Maximum current price is : "+ n);

		
		driver.close();
	}
	
	
	/*Get all the values of a Dynamic Table*/
	public static void getAllValuesfromTable() throws IOException{
		
		driver.get("http://demo.guru99.com/test/table.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
		
		List<WebElement> row = table.findElements(By.tagName("tr"));
		
		int rowCount = row.size();
		
		for(int r=0; r<rowCount; r++) {
			
			List<WebElement> column = row.get(r).findElements(By.tagName("td"));
			
			int colCount = column.size();
			
			
			for(int i=0; i <colCount; i++ ) {
				
				String getText = column.get(i).getText();
				
				System.out.println("cell value of row number "+r+ " and column number "+i+ " is "+getText);
				
				
			}
			
			System.out.println("--------------------------------------------------");
			
			
		}
		
		driver.close();
		
	
		
	}

	
	public static void isFrameSamp() throws IOException{
		
		
		driver.get("https://www.softwaretestingmaterial.com/generate-extent-reports/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		int iFramesize = driver.findElements(By.tagName("iframe")).size();
		
		
		System.out.println("iFrames Count :: "+iFramesize);
		
		driver.switchTo().frame("aswift_0");
		
		System.out.println("********We are switched to the iframe*******");
		
		driver.close();
	}
	
	public static void takeScreenshot() throws IOException{
		
		driver.get("http://demo.guru99.com/test/table.html");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File("C:\\Users\\KP\\git\\GitHandsOn\\testdata\\screenshot.png"));
		
		driver.close();
		
	}
}
