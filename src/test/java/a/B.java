package a;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class B {
	
	WebDriver driver;
	@Before()
	public void launch()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
	}
	@Test()
	public void m1()
	{
		 driver.findElement(By.id("email-input")).sendKeys("login@codility.com");
	     driver.findElement(By.id("password-input")).sendKeys("password");
	     driver.findElement(By.id("login-button")).click();
	      //webDriver.findElement(By.linkText("Welcome to Codility")).isDisplayed();
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message success']")).isDisplayed());
	    System.out.println(driver.findElement(By.xpath("//div[@class='message success']")).getText());
	}
	@Test
	public void m2()
	{
		driver.findElement(By.id("email-input")).sendKeys("unknown@codility.com");
	      driver.findElement(By.id("password-input")).sendKeys("password");
	     driver.findElement(By.id("login-button")).click();
	      //webDriver.findElement(By.linkText("Welcome to Codility")).isDisplayed();
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message error']")).isDisplayed());
	    System.out.println(driver.findElement(By.xpath("//div[@class='message error']")).getText()); 
	}
	@Test
	public void m3()
	{
		driver.findElement(By.id("email-input")).sendKeys("unknown@codilit");
	      driver.findElement(By.id("password-input")).sendKeys("password");
	     driver.findElement(By.id("login-button")).click();
	      //webDriver.findElement(By.linkText("Welcome to Codility")).isDisplayed();
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='validation error']")).isDisplayed());
	    System.out.println(driver.findElement(By.xpath("//div[@class='validation error']")).getText());
	}
	@Test
	public void m4()
	{
		driver.findElement(By.id("email-input")).sendKeys("");
	      driver.findElement(By.id("password-input")).sendKeys("");
	     driver.findElement(By.id("login-button")).click();
	    Assert.assertTrue(driver.findElement(By.id("messages")).isDisplayed());
	    System.out.println(driver.findElement(By.id("messages")).getText());
	}
	@After
	public void tear()
	{
		driver.close();
	}

}
