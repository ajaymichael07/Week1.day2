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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class ProvidedCredentials {
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
	public void provideCredential() {
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
		   
		   driver.findElement(By.xpath("(//div[@class='roleMenu-item_text']/parent::a)[2]")).click();
		   
		   WebElement text=driver.findElement(By.xpath("(//h1[text()='Salesforce Architect']/following::div)[1]"));
		   String text1=text.getText();
		   System.out.println(text1);
		   
		  List<WebElement> certificate=driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		  for (WebElement webElement : certificate) {
			   String list=webElement.getText();
			System.out.println(list);
			
		}
		  driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		  List<WebElement>ll=driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		  for (WebElement webElement : ll) {
			String ll1=webElement.getText();
			System.out.println(ll1);
		}
	}
	@AfterTest
		  public void end() {
			  driver.quit();
		  }
		  
	}

