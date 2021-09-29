package Primus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PrimusLogin {
	public WebDriver driver;
	
	@Given  ("^launch browser \"(.*)\" and  .exe file \\\"(.*)\\\" path$")
	public void browser(String Brow,String Path)
	{
		System.setProperty(Brow,Path);
		driver=new ChromeDriver();
		
	}
	
	@Given ("^user enter \"(.*)\" Url$")
	public void url(String Url)
	{
		driver.get(Url);
	}
	@When ("^user select branch$")
	public void selectBranch() throws InterruptedException
	{
		Thread.sleep(3000L);
		Select S=new Select(driver.findElement(By.xpath("//select[@name='drlist']")));
		S.selectByValue("Nashik");
	}
	@When ("^user enter (.+) as user id$")
	public void id(String id)
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='txtuId']")).sendKeys(id);
	}
	@When ("^user enter (.+) as password$")
	public void password(String password) throws InterruptedException
	{
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//input[@name='txtPword']")).sendKeys(password);
		
	}
	@When ("^user click on login$")
	public void loginclick() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(2000L);
	}
	@Then ("^user get msg as \"(.*)\"$")
	public void textcheck(String expected) throws InterruptedException
	{ 
		Thread.sleep(3000L);
		try {
			
		String actual=driver.findElement(By.xpath("//font[@size='3']")).getText();
		}
		
		finally {
			driver.close();
			}
		
	
	}
	
	@Then ("^user get emsg as \"(.*)\"$")
	public void etextcheck(String expected) throws InterruptedException
	{   
		String actual=expected;
		Thread.sleep(3000L);
	try {
		driver.switchTo().alert().dismiss();
		if(actual.equals(driver.findElement(By.xpath("(//*[text()='Banker Login'])[1]")).getText()))
		{
			System.out.println("Test Pass");
		}
	}
	finally {
		driver.close();
		}
	}

	
}
