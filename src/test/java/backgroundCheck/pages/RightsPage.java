package backgroundCheck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RightsPage extends Page{

	public RightsPage(WebDriver driver) {
		super(driver);		
	}
	
	public StatusBar getStatusBar() {  
		return PageFactory.initElements(driver, StatusBar.class);
	}	
	
	@FindBy(how = How.TAG_NAME, using = "h2")
	  @CacheLookup
	  public WebElement header;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-kjoXOD UNtpk']/div/div[2]/div[3]/div[2]/div/h2[@class='sc-jzJRlG gqcyfL']/following-sibling::div[1]")
	  @CacheLookup
	  public WebElement summaryOfYourRights;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-kjoXOD UNtpk']/div/div[2]/div[3]/div[2]/div/h2[@class='sc-jzJRlG gqcyfL']/following-sibling::div[2]/div/input")
	@CacheLookup
	public WebElement iHaveReadCheck;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-kjoXOD UNtpk']/div/div[2]/div[3]/div[2]/div/h2[@class='sc-jzJRlG gqcyfL']/following-sibling::div[2]/div/div/label")
	@CacheLookup
	public WebElement iHaveReadMessage;
	
	@FindBy(how = How.XPATH, using  = "(//button[contains(.,'Back')])[1]")
	@CacheLookup
	public WebElement backButton;
	
	@FindBy(how = How.XPATH, using  = "(//button[contains(.,'Next Document')])[1]")
	@CacheLookup
	public WebElement nextDocumentButton;
}
