package cross_browsertest_test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import cross_browsertest_baseclass.Baseclass_crossbrowser;

public class Testcheck_crossbrowser extends Baseclass_crossbrowser {

	//public WebDriver driver ;

	@Test
	public void invalidLoginTest() {

		System.out.println("Test Case1");
		
		System.out.println("case1");
		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		System.out.println("driver = " + driver);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		String expectedError = driver
				.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
		Assert.assertTrue(expectedError.contains("Invalid credentials"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test

	public void verifyAssignleaveicon() {

		System.out.println("Test Case2");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		System.out.println("driver = " + driver);
		Boolean AssignleaveIcon = driver.findElement(By.xpath("//div[@title = 'Assign Leave']")).isEnabled();
		assertTrue(AssignleaveIcon);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test

	public void validLoginTest() {

		// --> //div[@class = 'oxd-alert-content oxd-alert-content--error']

		System.out.println("Test Case3");

		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		System.out.println("driver = " + driver);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		String expectedTitle = driver.getTitle();
		Assert.assertTrue(expectedTitle.contains("dashboard"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

}
