package team_FixIt_Case_Study;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Case_study3 
{
	WebDriver driver;
	WebDriverWait wait;
	
  @Test(priority=1)
  public void testRegistration() throws InterruptedException {
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignUp")));
	  driver.findElement(By.linkText("SignUp")).click();
	  
	  
	  driver.findElement(By.name("userName")).sendKeys("BgsHREE");
	  
	  driver.findElement(By.name("firstName")).sendKeys("Bhagyshri");
	  
	 String status= driver.findElement(By.id("err")).getText();
	 Thread.sleep(5000);
	 Assert.assertEquals(status, "Available","UserName Is not Available");
	  driver.findElement(By.name("lastName")).sendKeys("Surose");
	  driver.findElement(By.name("password")).sendKeys("bgs123456");
	  driver.findElement(By.name("confirmPassword")).sendKeys("bg123456");
	  
	  driver.findElement(By.xpath("//input[@name='gender' and @value='Female']")).click();
	  driver.findElement(By.id("emailAddress")).sendKeys("BgsPatil@mail.com");
	  driver.findElement(By.id("mobileNumber")).sendKeys("8945561223");
	  driver.findElement(By.id("dob")).sendKeys("01/26/1998");
	  driver.findElement(By.id("address")).sendKeys(" surat surat surat");
	  
	  WebElement que=driver.findElement(By.id("securityQuestion"));
	  
	  Select securityQue=new Select(que);
	  securityQue.selectByValue("411012");
	  driver.findElement(By.id("answer")).sendKeys("Bugudu");
	  driver.findElement(By.name("Submit")).sendKeys(" surat surat surat");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver1.exe");
	  driver=new ChromeDriver();
	  
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  wait=new WebDriverWait(driver, 30);
	  
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }

}
