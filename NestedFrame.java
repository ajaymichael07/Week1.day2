package week1.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrame {
    ChromeDriver driver;
    @BeforeMethod
	
	public void website() {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	    driver= new ChromeDriver(option);
		driver.get("https://www.leafground.com/frame.xhtml;jsessionid=node01keday8jq7gb1omdapc2tzilf171813.node0");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
	}
    @Test
    public void nframe() {
    	WebElement frame=driver.findElement(By.xpath("(//div[@class='card']/iframe)[3]"));
    	driver.switchTo().frame(frame);
    	
    	WebElement findElement = driver.findElement(By.xpath("//body/iframe"));
    	driver.switchTo().frame(findElement);
    	
    	driver.findElement(By.id("Click")).click();
    	
    }
    
    @AfterMethod
    public void end() {
    	driver.quit();
    }
}
