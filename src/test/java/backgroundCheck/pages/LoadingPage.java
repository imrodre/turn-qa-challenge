package backgroundCheck.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoadingPage {

	@FindBy(how = How.TAG_NAME, using = "h2")
	@CacheLookup
	public WebElement pleaseWait;
		
	@FindBy(how = How.XPATH, using = "//h2/parent::div/p")
	@CacheLookup
	public WebElement description;
}
