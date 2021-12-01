package pros.unicam.spm2021.practice.HeadlessBrowsers;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


class HtmlUnitDriverTest {
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
	
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
		java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
	}
	
//WebClient
	@Test
	@Disabled
	void webClient() throws Exception {
		
	try (final WebClient webClient = new WebClient()) {
		
		
        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        System.out.println(page.getTitleText());
        Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

        final String pageAsXml = page.asXml();
        //System.out.println(pageAsXml);
        Assert.assertTrue(pageAsXml.contains("<a href=\"http://www.sourceforge.net/projects/htmlunit\" class=\"externalLink\" title=\"Project Page\">"));

        final String pageAsText = page.asText();
        Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
    }
}


	@Test
	@Disabled
	void htmUnitDriver() throws Exception {
	
	HtmlUnitDriver driver = new HtmlUnitDriver();
	
	driver.get("http://htmlunit.sourceforge.net");
		
	System.out.println("Title is: "+driver.getTitle());
	
	driver.quit();
	
	//Emulate other Browsers
	HtmlUnitDriver driverEmulator = new HtmlUnitDriver(BrowserVersion.CHROME);
	
	driverEmulator.get("http://htmlunit.sourceforge.net");
	
	System.out.println("Title is: "+driverEmulator.getTitle());
	
	//WebClient webClient = (WebClient) get(driverEmulator, "webClient");
	
	System.out.println("Browser Version is: "+driverEmulator.getBrowserVersion());
	System.out.println("Is Browser Chrome? : "+driverEmulator.getBrowserVersion().isChrome());
	System.out.println("Is Browser Firefox? : "+driverEmulator.getBrowserVersion().isFirefox());
	
    System.out.println(driverEmulator.getTitle());
    Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", driverEmulator.getTitle());

    final String pageAsXml = driverEmulator.getPageSource();
    Assert.assertTrue(pageAsXml.contains("<a href=\"http://www.sourceforge.net/projects/htmlunit\" class=\"externalLink\" title=\"Project Page\">"));
    
	driverEmulator.quit();

		
}

}
