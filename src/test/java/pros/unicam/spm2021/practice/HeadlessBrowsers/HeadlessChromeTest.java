package pros.unicam.spm2021.practice.HeadlessBrowsers;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
//import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HeadlessChromeTest
{
	
	static String browser;
	static String projectPath;
	static String pathToMacDrivers;
	static String address;
	
	static WebDriver driver;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 projectPath = System.getProperty("user.dir");
		 
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		if(System.getProperty("os.name").equals("Mac OS X")) {
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/mac/chromedriver");
		address="http://localhost:8080/spm2021";
		}
		if(System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\windows\\chromedriver.exe");
			address="http://localhost/spm2021";
		}
	    
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
	    chromeOptions.addArguments("--start-maximized");
	    //https://www.whatismybrowser.com/detect/what-is-my-user-agent
	    chromeOptions.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");
	    driver = new ChromeDriver(chromeOptions);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	

  @Test
  @Disabled
  public void createChromeDriverHeadless() throws IOException
  {
      
	  driver.navigate().to("https://www.seleniumhq.org/");
      System.out.println("Title is: "+driver.getTitle());
      assertTrue(driver.getTitle().contains("Selenium"));
  }
  
  @Test
  @Disabled
  void testMyAppTitle() {
	  driver.navigate().to(address);
	  System.out.println("Title is: "+driver.getTitle());
	  assertTrue(driver.getTitle().contains("SPM 2020"));
  }
  


}