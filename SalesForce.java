package week1.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class SalesForce {
	ChromeDriver driver;
	@BeforeTest
	public void log() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("start-maximized");
	    driver=new ChromeDriver(option);
	    driver.get("https://login.salesforce.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	    driver.findElement(By.id("password")).sendKeys("Leaf@123");
	    driver.findElement(By.id("Login")).click();
	}
	@Test
	public void certifications() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		
		Shadow shadow =new Shadow (driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		
		Actions action = new Actions(driver);
		WebElement trailhead=shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
	    action.moveToElement(trailhead).perform();
	    
	   WebElement certifi=shadow.findElementByXPath("//a[text()='Salesforce Certification']");
	   action.scrollToElement(certifi).click(certifi).perform();
	   
       driver.findElement(By.xpath("(//div[@class='roleMenu-item_text']/parent::a)[1]")).click();
	   System.out.println(driver.getTitle());
	   
	   List<WebElement> certificates=driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
	   for (WebElement webElement : certificates) {
		   String list=webElement.getText();
		   System.out.println(list);
		   }
	   }
	  @AfterMethod
	   public void end() {
		  driver.quit();
	  
	}
}
