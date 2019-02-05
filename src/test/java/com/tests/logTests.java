package com.tests;

//import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class logTests { 
	
	WebDriver driver;
	
	@BeforeMethod
	public void Setup(){
		Logger logger= Logger.getLogger("logTests");
		PropertyConfigurator.configure("D://Selenium Training//SeleniumWork/Generate.Logs//src//main//resources//log4j.properties");
		
		System.setProperty("webdriver.chrome.driver","D:\\SETUP\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Browser Opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http:www.freecrm.com");
	}
	
	@Test(priority=1)
	public void freecrmTitle1(){
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		
	}
	
	@Test(priority=2)
	public void freecrmLogoTest(){
		boolean b = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
