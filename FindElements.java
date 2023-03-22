package week1.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElements {
	
	ChromeDriver driver;
	@BeforeMethod
	public void log() {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	    driver= new ChromeDriver(option);
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
	}
	@Test
	public void printElements() {
		List<WebElement>name=driver.findElements(By.xpath("//div[@class='frameSectionBody']//li"));
		for (WebElement each : name) {
			String attribute=each.getText();
			System.out.println(attribute);
			 
		}
		
			
		
	}

}
