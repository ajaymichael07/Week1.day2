package week1.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsHandling {
	ChromeDriver driver;
	@BeforeMethod
	public void log() {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	    driver= new ChromeDriver(option);
	    driver.get("https://www.leafground.com/window.xhtml");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
	}
	@Test
    public void handling() {
		
		driver.findElement(By.xpath("(//div[@class='card']//button)[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
//		for (String string : windowHandles) {
//			System.out.println(string);
//		}
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		String title=driver.getTitle();
		System.out.println(" the number of opened tabs = "+title);

	}
	@Test
	public void handling2() {
     driver.findElement(By.xpath("(//div[@class='card']//button)[2]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		int num=window.size();
		System.out.println("the number of opened tabs = "+num);
		driver.close();
	}
	@Test
	public void handling3() {
		driver.findElement(By.xpath("(//div[@class='card']//button)[3]")).click();
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		driver.close();
		
	}
	@Test
	public void handling4() {
		driver.findElement(By.xpath("(//div[@class='card']//button)[4]")).click();
		
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	}

