package gproject.prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpg {
	
	public WebDriver driver;
Loginpg (WebDriver driver)
{
this.driver=driver;
}
By signlink=By.linkText("Sign in");
By email=By.xpath("//input[@type='email']");
By button=By.xpath("//span[text()='Next']");
By button2=By.xpath("//span[text()='Create account']");

By accountmyself=By.xpath("//li[@jsname='RZzeR']");

public WebElement signinlink()
{
	return (driver.findElement(signlink));

	
}
public WebElement createaccnlink()
{
	return (driver.findElement(button2));

	
}
public WebElement emailtext()
{
	return (driver.findElement(email));

	
}

public WebElement nxtbutton()
{
	return (driver.findElement(button));

	
}
public WebElement createaccount()
{
	return (driver.findElement(accountmyself));
}
}
