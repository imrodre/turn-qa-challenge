package backgroundCheck.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import backgroundCheck.pages.LoadingPage;

/**
 * Use this to perform common task of waiting for elements
 * page to fully load
 * element to be visible by driver
 * element to be invisible by driver
 * element to be clickable
 * element until found
 * 
 * @author Rodrigo Moran
 */
public class WaitHelper {
		
	public void waitForPageToLoad(WebDriver driver) {
		
		LoadingPage loadingPage  = PageFactory.initElements(driver, LoadingPage.class);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.visibilityOf(loadingPage.pleaseWait));
		wait.until(ExpectedConditions.visibilityOf(loadingPage.description));
	}
	    
    public void elementToBeVisible(WebDriver driver, WebElement element) {
    	WebDriverWait wait =new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void elementToBeInvisible(WebDriver driver, WebElement element) {
    	WebDriverWait wait =new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    public void elementToBeClickable(WebDriver driver, WebElement element) {
    	WebDriverWait wait =new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void waitUntilFound(WebDriver driver, WebElement element) {
    	
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
    			.withTimeout(Duration.ofSeconds(5))
    			.pollingEvery(Duration.ofSeconds(5))
    			.ignoring(NoSuchElementException.class, TimeoutException.class);
    	wait.until(ExpectedConditions.visibilityOf(element));  
    }
}
