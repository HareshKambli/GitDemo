package mmt.makeMyTrip;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.homePagePOM;
import Resources.base;

public class homePage extends base {
	
	@BeforeSuite
	public void initDriver() throws IOException {
		driver=initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void navigateHomePage(String site) throws IOException {
		//driver=initializeDriver();
		driver.get(site);
		homePagePOM hg = new homePagePOM(driver);
		hg.login().click();
		
		TakesScreenshot ss = ((TakesScreenshot)driver);
		File src =ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E://screenshot.png"));
		
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][1];
		data[0][0]="https://www.makemytrip.com/";
		//data[1][0]="https://www.google.com/";
		
		return data;
	}
	
	

}
