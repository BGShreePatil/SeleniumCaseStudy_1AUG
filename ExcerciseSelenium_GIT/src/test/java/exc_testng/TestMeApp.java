package exc_testng;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestMeApp{
	
	WebDriver driver;
	
  @Test
  public void f() {
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//a[@href='login.htm']")).click();
	  driver.findElement(By.xpath("//input[@type='text' and @name='userName']")).sendKeys("lalitha");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Assert.assertEquals("Home", driver.getTitle());
	  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver1.exe");
	  driver=new ChromeDriver();
	  driver.navigate().to("http://10.232.237.143:443/TestMeApp/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
