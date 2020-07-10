package mmt.makeMyTrip;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjectModel.homePagePOM;
import Resources.base;


public class SearchFlight extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeSuite
	public void initDriver() throws IOException {
		driver=initializeDriver();
		log.info("intiliazing driver");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@Parameters({"source"})
	@Test(priority=0)
	public void source(String sourceCity) throws IOException {
		//driver=initializeDriver();
		homePagePOM hg = new homePagePOM(driver);
		WebElement source=hg.source();
		source.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		log.info("source");
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(sourceCity);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='From']")).getText().contains("Mumbai"));
	}
	
	@Test(priority=1,enabled=true)
	public void dest() throws InterruptedException {
		homePagePOM hg = new homePagePOM(driver);
		WebElement dest=hg.destination();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@placeholder='To']"))));
		dest.click();
		wait.until(ExpectedConditions.elementToBeClickable(dest));
		driver.findElement(By.xpath("//input[@placeholder='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("pun");
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Keys.ENTER);
	}
	
	@Test(priority=2)
	public void departure() {
		homePagePOM hg = new homePagePOM(driver);
		WebElement dep = hg.departure();
		dep.click();
		while(!driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText().contains("Sept")) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Wed Sep 02 2020']")).click();
	}
	
	@Test(priority=3)
	public void returnDate() {
		homePagePOM hg = new homePagePOM(driver);
		WebElement returnDate = hg.returnDate();
		returnDate.click();
		while(!driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText().contains("Sept")) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Wed Sep 30 2020']")).click();
	}
	
	@Test(priority=4)
	public void travellerClass() {
		homePagePOM hg = new homePagePOM(driver);
		hg.travellerClass().click();
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		System.out.println(driver.findElement(By.xpath("//li[@data-cy='adults-2' and @class='selected']")).getText());
		
		driver.findElement(By.xpath("//li[@data-cy='children-1']")).click();
		System.out.println(driver.findElement(By.xpath("//li[@data-cy='children-1' and @class='selected']")).getText());
		
		driver.findElement(By.xpath("//li[@data-cy='travelClass-1']")).click();
		System.out.println(driver.findElement(By.xpath("//li[@data-cy='travelClass-1' and @class='selected']")).getText());
		
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
	}
	
	@Test(priority=5)
	public void search() {
		homePagePOM hg = new homePagePOM(driver);
		hg.search().click();
	}
	
	@Test(priority=6)
	public void action() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[@class='chNavText']")))
		.moveToElement(driver.findElement(By.xpath("//a[@data-cy='submenu_InternationalFlights']"))).click().build().perform();
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
