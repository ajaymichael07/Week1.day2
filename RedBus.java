package week1.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RedBus {
	ChromeDriver driver;
	@BeforeMethod
	
	public void redBus() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("start-maximized");
	    driver=new ChromeDriver(option);
	    driver.get("https://www.redbus.in/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void log() {
		Actions action =new Actions(driver);
		WebElement from=driver.findElement(By.id("src"));
		from.sendKeys("Chennai");
		WebElement koyambedu=driver.findElement(By.xpath("(//li[@class='sub-city'])[1]"));
		action.moveToElement(koyambedu).click(koyambedu).perform();
		
		WebElement To=driver.findElement(By.id("dest"));
		To.sendKeys("Bangalore");
		WebElement Bangalore=driver.findElement(By.xpath("(//li[@class='sub-city'])[1]"));
		action.moveToElement(Bangalore).click(Bangalore).perform();
		
		driver.findElement(By.xpath("//table//tr[6]//td[5]")).click();
		
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		List<WebElement> buses=driver.findElements(By.xpath("//div[@class='travels lh-24 f-bold d-color']"));
		for (WebElement webElement : buses) {
			String names=webElement.getText();
			System.out.println(names);
		}
		driver.findElement(By.xpath("//label[text()='SEATER']")).click();
		WebElement second=driver.findElement(By.xpath("//div[text()='Sri Sugam Bus Tours and Travels']"));
		String print=second.getText();
		System.out.println("the name of the second resulting bus " +print);
		
		System.out.println(driver.getTitle());
	}

}
