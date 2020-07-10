package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePagePOM {
	
	public WebDriver driver;
	
	public homePagePOM(WebDriver driver) {
		this.driver=driver;
	}
	
	By login = By.xpath("//*[@id='SW']/div[2]/div[1]/ul/li[6]/div/p");
	By source = By.xpath("//label[@for='fromCity']");
	By destination = By.xpath("//input[@id='toCity']");
	By departure = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span");
	By returnDate = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[4]/div/label/span");
	By travellerClass = By.xpath("//label[@for='travellers']");
	By search = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a");
	
	public WebElement login() {
		return driver.findElement(login);
	}
	
	public WebElement source() {
		return driver.findElement(source);
	}
	
	public WebElement destination() {
		return driver.findElement(destination);
	}
	
	public WebElement departure() {
		return driver.findElement(departure);
	}
	
	public WebElement returnDate() {
		return driver.findElement(returnDate);
	}
	
	public WebElement travellerClass() {
		return driver.findElement(travellerClass);
	}
	
	public WebElement search() {
		return driver.findElement(search);
	}
}
