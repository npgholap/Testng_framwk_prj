package gproject.prac;
//import java.util.concurrent.TimeU;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baseclass {

	
	public WebDriver driver;
public	Properties prop;
String url1;
	public WebDriver driverinit() throws IOException
	{
		
		 prop= new Properties();
		
		FileInputStream fis= new FileInputStream("C:\\javaworkspace\\prac\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);
		String str=prop.getProperty("browser");
		System.out.println(str);
		
	String url1=prop.getProperty("url");
		System.out.println(url1);
		
		ChromeOptions op = new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		
	if (str.equalsIgnoreCase("chrome"))
{	
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		driver= new ChromeDriver(op);
		
}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
		return driver;
		
	}

	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile =System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
				
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}
}

