package backgroundCheck.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * Utility created to reuse browser common tasks 
 * 
 * @author Rodrigo Moran
 */
public class BrowserUtils  extends TestBase{
	
	/**
	 * Open browser and navigate to specific site
	 * @param driver
	 */
	public static void launchSite(WebDriver driver){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Logger.logStep("Launching site");
		Logger.logStep(baseUrl);
		driver.get(baseUrl);
	}
	
	/**
	 * Close browser
	 * @param driver
	 */
	public static void closeSite(WebDriver driver) {
		driver.quit();
	}
}
