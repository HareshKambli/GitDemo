package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
	    prop.load(fi);
	    String browser = prop.getProperty("browser");
	    System.out.println(browser);
	    if (browser.contains("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "E:\\Haresh\\Eclipse\\Selenium\\Driver\\New folder\\chromedriver.exe");
	    	driver=new ChromeDriver();
	    }
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    return driver;
	}

}
