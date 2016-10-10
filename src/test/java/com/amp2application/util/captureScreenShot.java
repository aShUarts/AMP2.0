package com.amp2application.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class captureScreenShot {

	
public static void screenshots(WebDriver driver,String Screenshotname,String Foldername)
{	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(source, new File("C:\\Users\\ashutosh.kumar\\workspace\\AMP2\\src\\test\\resources\\"+Foldername+"\\"+Screenshotname+".png"));
	} catch (IOException e) {
		System.out.println(e);
	}
		
		
	}
}
