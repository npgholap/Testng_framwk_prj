package gproject.prac;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepg {
	
	public WebDriver driver;
Homepg(WebDriver driver)
	{
	this.driver=driver;
	}
By glink=By.linkText("Gmail");
By imglink=By.linkText("Images");
By signlink=By.linkText("Sign in");
By searchtxt= By.xpath("//input[@name='q']");



public WebElement gmaillink()
{
	return (driver.findElement(glink));

	
}

public WebElement imgslink()
{
	return (driver.findElement(imglink));

	
}

public WebElement signinlink()
{
	return (driver.findElement(signlink));

	
}

public WebElement searchtext()
{
	return (driver.findElement(searchtxt));

	
}
public List<String> searchtextlist() throws InterruptedException
{
	List<String> l= new ArrayList<String>();
	Thread.sleep(1000);
	int i=driver.findElements(By.xpath("//div[@class='wM6W7d']/span")).size();
	for(int j=0;j<i;j++)
	{
	
l.add(driver.findElements(By.xpath("//div[@class='wM6W7d']/span")).get(j).getText());
	}	
		
return l;




}


}

