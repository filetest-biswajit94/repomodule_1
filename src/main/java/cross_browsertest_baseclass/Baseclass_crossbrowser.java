package cross_browsertest_baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass_crossbrowser {

	public static WebDriver driver ;

	@Parameters("browser")
	@BeforeTest

	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
			System.out.println("Browser Started: " + browser);
			
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
			System.out.println("Browser Started: " + browser);
			
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
			System.out.println("Browser Started: " + browser);
			
		} else {
			throw new Exception("Incorrect Browser");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

	}

	@AfterTest

	public void closeBrowser() throws IOException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.quit();
	}

}
