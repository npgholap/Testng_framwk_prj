package gproject.prac;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OneTest extends Baseclass{
public WebDriver driver;
public Homepg homepg;
public static Logger log= LogManager.getLogger(Baseclass.class.getName());

@BeforeTest(alwaysRun=true)

public void init() throws IOException, InterruptedException
{
	driver=driverinit();
log.info("driver initialiaed");
	
	driver.get("https://www.google.com");
log.info("navigated to home page");	
	homepg = new Homepg(driver);
	
	
}

@Test(groups={"Regression"})
public void gmaillinktest()
{
	homepg.gmaillink().click();
	
	System.out.println(	driver.getTitle());
	System.out.println("successfully validated gmail link");	
	driver.navigate().back();
}


@Test(groups={"Regression"})
public void imglinktest()
{
	homepg.imgslink().click();
	
	System.out.println(	driver.getTitle());
	System.out.println("successfully validated image link");	
	driver.navigate().back();
}

@Test(groups= {"Smoke"})
public void signinlinktest()
{
	homepg.signinlink().click();
	
	System.out.println(	driver.getTitle());
	log.info("successfully validated sign in link link");	
	driver.navigate().back();
}

@Test(priority=-1)
public void searchtexttest() throws InterruptedException
{
	homepg.searchtext().sendKeys("flowers");
	List<String> lt= new ArrayList<String>();
	//lt.addAll(homepg.searchtextlist());
	lt=homepg.searchtextlist();
	Iterator<String> it=lt.iterator();
	while(it.hasNext())
	{System.out.println(it.next());
	}
	log.debug("checked drop down listof search textbar");
	}
	
	@AfterTest(alwaysRun=true)
	
	public void Teardown()
	{
		driver.close();
		
	}
	
	
	
}



