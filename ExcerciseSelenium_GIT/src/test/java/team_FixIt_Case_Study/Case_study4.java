package team_FixIt_Case_Study;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Case_study4 
{
	WebDriverWait wait;
	WebDriver driver;
	
  @Test(priority=2)
  public void testLogin() throws InterruptedException {
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("SignIn")));
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.id("userName")).sendKeys("BgsHREE");
	  driver.findElement(By.id("password")).sendKeys("bgs123456");
	  driver.findElement(By.name("Login")).click();
	 	
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  wait=new WebDriverWait(driver, 30);
	  
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	 
  }

}
