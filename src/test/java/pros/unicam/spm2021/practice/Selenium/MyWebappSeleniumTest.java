package pros.unicam.spm2021.practice.Selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class MyWebappSeleniumTest {


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
		address="http://localhost:8080/spmn2020NewProject";
		}
		if(System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\studente\\Documents\\BrowserDriver\\chromedriver.exe");
			address="http://localhost/spmn2020NewProject";
		}
	    
		ChromeOptions chromeOptions = new ChromeOptions();
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
	void testMyAppTitle() {
		  driver.navigate().to(address);
	      System.out.println("Title is: "+driver.getTitle());
	      assertTrue(driver.getTitle().contains("SPM"));
	}

}
