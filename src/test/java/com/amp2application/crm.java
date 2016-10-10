package com.amp2application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.amp2application.util.Login;
import com.amp2application.util.RandomGenerator;
import com.amp2application.util.captureScreenShot;

public class crm {
	
	public static WebDriver driver=Login.driver;
	
	public static void list()
			{
		/*Login.alllogin();
		driver.findElement(By.id(id))*/
		
    }
     @Test
	public static void add()
	{
		Login.alllogin();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> leftpanel= Login.driver.findElements(By.xpath("//span[@class='nav-label']"));
		
		System.out.println(leftpanel.size());
		
		
		leftpanel.get(1).click();
    	captureScreenShot.screenshots(driver,"1.NavigatetoCRM","CRM");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
    	driver.findElement(By.linkText("Add")).click();
		RandomGenerator rg= new RandomGenerator();  //Defining Random Generated Function
        String a=rg.generateRandomChars("QWERTYUIOPASDFGHJKLZXCVBNM", 5);//Defining input to select in the RGF
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
    	
        driver.findElement(By.id("company_name")).sendKeys(prop.getProperty("CompanyName"+a+"Pvt.Ltd"));
        Select industry_type_dropdown=new Select(driver.findElement(By.id("id_industry_master")));
        System.out.println(industry_type_dropdown.getOptions());
        industry_type_dropdown.selectByVisibleText(prop.getProperty("IndustryType"));
        driver.findElement(By.id("crm_cudtomer_email_id")).sendKeys(prop.getProperty("CompanyEmail"+a+"Pvt.Ltd"));
        Select country_dropdown= new Select(driver.findElement(By.id("select2-chosen-1")));
        country_dropdown.selectByVisibleText(prop.getProperty("Country"));
        Select country_prefix_dropdown= new Select(driver.findElement(By.id("corporate_country_prefix")));
        country_prefix_dropdown.selectByVisibleText(prop.getProperty("Countryprefix"));
        driver.findElement(By.id("corporate_address1")).sendKeys(prop.getProperty("CAddress1"));
        driver.findElement(By.id("corporate_city")).sendKeys(prop.getProperty("CCity"));
        driver.findElement(By.id("corporate_address2")).sendKeys(prop.getProperty("CAddress2"));
        driver.findElement(By.id("corporate_state")).sendKeys(prop.getProperty("CState")); 
        driver.findElement(By.id("corporate_pincode")).sendKeys(prop.getProperty("CPincode"));
        driver.findElement(By.id("corporate_address3")).sendKeys(prop.getProperty("CAddress3"));
        captureScreenShot.screenshots(driver,"1.CustomerDetailsFill","CRM");
        
        
		
		
	}
	
	public static void upload()
	{
		
		
		
	}
}
