package com.amp2application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.amp2application.util.Login;
import com.amp2application.util.RandomGenerator;
import com.amp2application.util.captureScreenShot;

public class crm {
	
//	public static WebDriver driver=Login.driver;
	
	public static void list()
			{
		/*Login.alllogin();
		driver.findElement(By.id(id))*/
		
    }
     @Test
	public static void add()
	{  
		Login.alllogin();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriver driver=Login.driver;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[href*='#'][data-original-title1='CRM']")).click();
		captureScreenShot.screenshots(driver,"1.NavigatetoCRM","CRM");
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}*/
    	driver.findElement(By.linkText("Add")).click();
		RandomGenerator rg= new RandomGenerator();  //Defining Random Generated Function
        String a1=rg.generateRandomChars("QWERTYUIOPASDFGHJKLZXCVBNM", 5);//Defining input to select in the RGF
        String a2=rg.generateRandomChars("0123456789111213", 5);
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
    	
        driver.findElement(By.id("company_name")).sendKeys(prop.getProperty("CompanyName")+" "+a1+" Pvt.Ltd");
        Select industry_type_dropdown=new Select(driver.findElement(By.id("id_industry_master")));
        System.out.println(industry_type_dropdown.getOptions());
        industry_type_dropdown.selectByVisibleText(prop.getProperty("IndustryType"));
        driver.findElement(By.id("crm_cudtomer_email_id")).sendKeys(prop.getProperty("CompanyEmail")+a1+"@mailinator.com");
        Select country_dropdown= new Select(driver.findElement(By.id("corporate_country")));
        country_dropdown.selectByVisibleText(prop.getProperty("Country"));
        captureScreenShot.screenshots(driver,"2.CustomerDetailsFill1","CRM");
        Select country_prefix_dropdown= new Select(driver.findElement(By.id("corporate_country_prefix")));
        country_prefix_dropdown.selectByVisibleText(prop.getProperty("Countryprefix"));
        driver.findElement(By.id("corporate_contact_no")).sendKeys(prop.getProperty("CCorporateNo")+a2); 
        driver.findElement(By.id("corporate_address1")).sendKeys(prop.getProperty("CAddress1")+a1);
        driver.findElement(By.id("corporate_city")).sendKeys(prop.getProperty("CCity")+a1);
        driver.findElement(By.id("corporate_address2")).sendKeys(prop.getProperty("CAddress2")+a1);
        driver.findElement(By.id("corporate_state")).sendKeys(prop.getProperty("CState")+a1); 
        driver.findElement(By.id("corporate_pincode")).sendKeys(prop.getProperty("CPincode"));
        driver.findElement(By.id("corporate_address3")).sendKeys(prop.getProperty("CAddress3")+a1);
        captureScreenShot.screenshots(driver,"3.CustomerDetailsFill2","CRM");
        driver.findElement(By.id("crm_cpd_person_name")).sendKeys(prop.getProperty("ContactPerson")+a1);
        Select country_code_dropdown= new Select(driver.findElement(By.id("crm_cpd_country_code")));
        country_code_dropdown.selectByVisibleText(prop.getProperty("CountryCode"));
        driver.findElement(By.id("crm_cpd_contact_no")).sendKeys(prop.getProperty("CContactNo")+a2);
        driver.findElement(By.id("crm_cpd_email_id")).sendKeys(prop.getProperty("CEmailID")+a1+"@mailinator.com");
        Select contactperson_designation_dropdown= new Select(driver.findElement(By.id("crm_cpd_designation")));
        contactperson_designation_dropdown.selectByVisibleText(prop.getProperty("Designation"));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        captureScreenShot.screenshots(driver,"4.SubmitCustomer","CRM");		
		//driver.quit();
	}
	
	public static void upload()
	{
		
		
		
	}
}
