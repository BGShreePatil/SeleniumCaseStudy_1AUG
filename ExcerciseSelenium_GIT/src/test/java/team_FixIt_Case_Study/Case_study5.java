package team_FixIt_Case_Study;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Case_study5 {
	WebDriverWait wait;
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver1.exe");
		driver=new ChromeDriver();

		driver.get("http://10.232.237.143:443/TestMeApp/");
		wait=new WebDriverWait(driver, 30);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	@Test(priority=2)
	public void testLogin() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("SignIn")));
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("BgsHREE");
		driver.findElement(By.id("password")).sendKeys("bgs123456");
		driver.findElement(By.name("Login")).click();

	}


	@Test(priority=3)
	public void testCart() throws InterruptedException {

		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.name("products")));
		driver.findElement(By.name("products")).click();
		act.sendKeys("B").pause(2000).sendKeys("a").pause(1000).sendKeys("g").build().perform();
		driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]/div[2]")).click();


		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String product=driver.findElement(By.xpath("//h4[contains(.,'Hand bag')]")).getText();

		//check same product diplaying as searched
		Assert.assertEquals(product, "Hand bag","Error : Product Is not Same As Searched");

		driver.findElement(By.xpath("//a[@href='#'][contains(.,'Add to cart')]")).click();
		driver.findElement(By.partialLinkText("Cart")).click();

		String text=driver.findElement(By.xpath("//h4[@class='nomargin'][contains(.,'Hand bag')]")).getText();

		//Check same product added to card as selected
		Assert.assertEquals(text, "Hand bag","Error : Product Is not Same As Seleccted");

	}

	@Test(priority=4)
	public void testPayment() throws InterruptedException {
		//Click on Checkout Button
		driver.findElement(By.xpath("//a[@href='checkout.htm'][contains(.,'Checkout')]")).click(); 
		//Click on proceed to pay button
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click(); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(.,'Andhra Bank')]")).click();
		driver.findElement(By.id("btn")).click(); 
		
		//Enter bank caredentials
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456"); 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pass@456"); 
 
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click(); 
		Thread.sleep(2000);
		
		//Enter Transaction Password

		driver.findElement(By.xpath("//input[contains(@name,'transpwd')]")).sendKeys("Trans@456");; 
		
		driver.findElement(By.xpath("//input[@type='submit' and value='PayNow']")).click(); 
	
	}
}
