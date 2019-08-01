package exc_testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Module5_EXC 
{	
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver1.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://10.232.237.143:443/TestMeApp/");
	}

	@Test
	public void f() throws InterruptedException {
		
	
		driver.findElement(By.xpath("//a[contains(.,'SignIn')]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("lalitha");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");;
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		WebElement txtSearch=driver.findElement(By.xpath("//input[@type='text']"));
		Actions act=new Actions(driver);
		act.moveToElement(txtSearch).click();
		act.sendKeys("w").pause(1000).sendKeys("e").pause(1000).sendKeys("a").pause(1000).perform();
		
		driver.findElement(By.xpath("(//div[contains(.,'Summer wear')])[4]")).click();
		
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(.,'Summer wear')]")).getText(), "Summer wear");
		//a[@class='btn btn-success btn-product']
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
		//a[@href='displayCart.htm']
		driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		//a[@href='checkout.htm']
		driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
		//input[@value='Proceed to Pay']
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		Thread.sleep(5000);
		//label[contains(.,'Andhra Bank')]
		WebElement andhra=driver.findElement(By.xpath("//input[@value='Andhra Bank' and @name='radio1']"));
		act.moveToElement(andhra).click();
		driver.findElement(By.xpath("//a[@id='btn']")).click();
		
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("12456");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Trans@456");
	}
	

	@AfterTest
	public void afterTest() {
	}

}
