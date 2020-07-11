package backgroundCheck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage extends Page{

	public AuthorizationPage(WebDriver driver) {
		super(driver);		
	}
	
	public StatusBar getStatusBar() {  
		return PageFactory.initElements(driver, StatusBar.class);
	}	
	
	@FindBy(how = How.TAG_NAME, using = "h2")
	  @CacheLookup
	  public WebElement header;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-kjoXOD UNtpk']/div/div[2]/div[3]/div[4]/div/h2[@class='sc-jzJRlG gqcyfL']/following-sibling::div[1]")
	@CacheLookup
	public WebElement summaryOfAuthorization;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-kjoXOD UNtpk']/div/div[2]/div[3]/div[4]/div/h2[@class='sc-jzJRlG gqcyfL']/following-sibling::div[2]/div/div/input")
	@CacheLookup
	public WebElement iAgreeCheck;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-kjoXOD UNtpk']/div/div[2]/div[3]/div[4]/div/h2[@class='sc-jzJRlG gqcyfL']/following-sibling::div[2]/div/div/div/label")
	@CacheLookup
	public WebElement iAgreeMessage;
	
	@FindBy(how = How.XPATH, using  = "(//button[contains(.,'Back')])[4]")
	@CacheLookup
	public WebElement backButton;
	
	@FindBy(how = How.XPATH, using  = "//button[contains(.,'Review My Data')]")
	@CacheLookup
	public WebElement reviewMyDataButton;
}
