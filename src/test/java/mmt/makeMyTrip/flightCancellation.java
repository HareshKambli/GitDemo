package mmt.makeMyTrip;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Resources.base;

public class flightCancellation extends base{
	
	@BeforeSuite
	public void initDriver() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void flightTerms() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@id=\"Offers_Listing\"]/div[2]/div/div/div/div[1]/div/div/div")));
		
		driver.findElement(By.xpath("//*[@id='Offers_Listing']/div[2]/div/div/div/div[1]/div/div/div/p/span[2]/a")).click();
		/*Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@class='makeFlex column itemCard soCardHeight pointer']//following::p[1]/span/a"))).click().build().perform();*/
		Thread.sleep(10000);
		Set<String> tabs=driver.getWindowHandles();
		System.out.println(tabs);
		Iterator<String> ir = tabs.iterator();
		String parent=ir.next();
		String child=ir.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		driver.findElement(By.linkText("MakeMyTrip Home")).click();
		
		
	}
	
	@AfterSuite
	public void close() {
		driver.quit();
	}

}
