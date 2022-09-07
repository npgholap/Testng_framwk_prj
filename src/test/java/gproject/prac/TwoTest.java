	package gproject.prac;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoTest extends Baseclass {
	public WebDriver driver;
	public Loginpg loginpg;
	
	public static Logger log= LogManager.getLogger(Baseclass.class.getName());	

	@BeforeTest(alwaysRun=true)

	public void init1() throws IOException
	{
		driver=driverinit();
		driver.get("https://www.google.com");
		
		loginpg = new Loginpg(driver);
		
		
	}
	
	@Test(priority=-1,enabled=true,groups= {"Smoke"})
	public void signin()
	{
		loginpg.signinlink().click();
		
		System.out.println(	"sign in from twotest");
	}
	
	@Test(priority=2, dataProvider="getData")
	public void emailtxt(String url1) throws InterruptedException
	{Thread.sleep(1000);
		loginpg.emailtext().sendKeys(url1);
		Thread.sleep(1000);
		loginpg.nxtbutton().click();
	Thread.sleep(2000);
	
		driver.navigate().back();
		loginpg.emailtext().clear();
	}
	
	@DataProvider
	public Object[] getData()
	{
		Object[] o=new Object[2];
				o[0]="nishapgholap@gmail.com";
						o[1]="golap.nish@gmail.com";
						return o;
						
	}
	
	@Test(priority=3, enabled=true)
	public void createaccount() throws InterruptedException
	{
		loginpg.createaccnlink().click();
		log.info("successfully validated createaccount button clicked");	
	
		loginpg.createaccount().click();
//boolean b=	loginpg.createaccount().isDisplayed();
Assert.fail();

		log.error("stop test");
	}
	

@AfterTest(alwaysRun=true)
	
	public void Teardown()
	{
		driver.close();
		
	}
}
