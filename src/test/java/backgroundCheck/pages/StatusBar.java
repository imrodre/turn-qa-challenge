package backgroundCheck.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StatusBar{

	@FindBy(how = How.XPATH, using = "//div[text()='Information']")
	@CacheLookup
	public WebElement information;
	  
	@FindBy(how = How.XPATH, using = "//div[text()='Rights']")
	@CacheLookup
	public WebElement rigths;
	  
	@FindBy(how = How.XPATH, using = "//div[text()='Disclosure']")
	@CacheLookup
	public WebElement disclosure;
	
	@FindBy(how = How.XPATH, using = "//div[text()='State Rights']")
	@CacheLookup
	public WebElement stateRights;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Authorization']")
	@CacheLookup
	public WebElement authorization;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Confirmation']")
	@CacheLookup
	public WebElement confirmation;
}
