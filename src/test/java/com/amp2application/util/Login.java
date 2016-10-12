package com.amp2application.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login {
	
	public static WebDriver driver;	
	
	@Test
	public static void alllogin(){
		
	Properties prop = new Properties();
	FileInputStream fis=null;
	try {
		fis = new FileInputStream("C:\\Users\\ashutosh.kumar\\workspace\\AMP2\\src\\test\\resources\\application.properties");
	} catch (FileNotFoundException e) {
		
		System.out.println(e);
	}
	
	try {
		prop.load(fis);
	} catch (IOException e) {
		
		System.out.println(e);
	}
	
	if(prop.getProperty("Browser").equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
	}else if(prop.getProperty("Browser").equals("Firefox"))
	{
		driver =new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(prop.getProperty("URL"));
	captureScreenShot.screenshots(driver, "1.LaunchURL", "Screenshot");
	driver.findElement(By.id("email")).sendKeys(prop.getProperty("Username"));
	captureScreenShot.screenshots(driver,"2.EnterUsername","Screenshot");
	driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password"));
	captureScreenShot.screenshots(driver,"3.Enterpassword","Screenshot");
	driver.findElement(By.id("submit")).click();
	captureScreenShot.screenshots(driver,"4.Successfulllogin","Screenshot");
//	driver.findElement(By.cssSelector("a[href*='#'][data-original-title1='CRM']")).click();
	//driver.quit();
	
	
	
	}
   
	
	
}
