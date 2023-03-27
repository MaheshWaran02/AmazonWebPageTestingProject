package Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Phase1EndProject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement SearchBar = driver.findElement(By.id("twotabsearchtextbox"));
		SearchBar.sendKeys("samsung mobile");
		
		WebElement search = driver.findElement(By.id("nav-search-submit-button"));
		search.click();
		
		List <WebElement> PhoneName = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		List <WebElement> phoneprice  = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));
		List <WebElement> phonepricesymbol  = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		System.out.println("the total number of phone is : " + PhoneName.size());
		
		for(int i=0;i<PhoneName.size();i++) {
			System.out.println("the phone name is :" + PhoneName.get(i).getText() );
			
			System.out.println("the phone price is :" + phonepricesymbol.get(i).getText() + " " + phoneprice.get(i).getText());
		}
		TakesScreenshot tspage = (TakesScreenshot) driver;
		File fileObj = tspage.getScreenshotAs(OutputType.FILE);
		File Screenshotobj =new File ("Amzon.png");
		
		FileUtils.copyFile(fileObj, Screenshotobj);
		driver.close();
		
			
		}
		
	
	}


	


