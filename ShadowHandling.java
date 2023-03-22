package week1.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class ShadowHandling {

	ChromeDriver driver;
	@BeforeMethod
	public void log() {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	    driver= new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
	}
	@Test
	public void shadow() {
		Shadow shadow =new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='kils']").sendKeys("Ajay");
		
//		
		WebElement iframe=shadow.findElementByXPath("//iframe[@id='pact1']");
		driver.switchTo().frame(iframe);
		
		WebElement jj=shadow.findElementByXPath("//input[@id='glaf']");
				jj.sendKeys("Ajay");
				
		
//		driver.findElement(By.xpath("//input[@id='glaf']")).sendKeys("Aj");
		
		
	}
}
