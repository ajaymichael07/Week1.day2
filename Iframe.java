package week1.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframe {
	ChromeDriver driver;
	@BeforeMethod
	public void ch(){
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	    driver= new ChromeDriver(option);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public  void i_f( ) {
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.switchTo().alert().sendKeys("hi there");
		driver.switchTo().alert().accept();
		
		
		
	}

	@AfterMethod
	public void ed() {
		driver.quit();
	}
}
