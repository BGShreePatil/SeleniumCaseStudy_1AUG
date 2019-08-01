package exc_testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Demo2_FethchAllLink {
	WebDriver driver;
  @Test
  public void f() {
	  
	 List<WebElement> links=driver.findElements(By.tagName("a"));
	 int counter=0;
	 for(WebElement we:links) {
		 System.out.println("Link : "+ we.getText()+" - "+we.getAttribute("href"));
		 counter++;
	 }
	 System.out.println("Total no of links are : "+counter);
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
