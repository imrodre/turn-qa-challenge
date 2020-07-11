package backgroundCheck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class InformationPage extends Page {

	public InformationPage(WebDriver driver) {
		    super(driver);
		  }

	  public StatusBar getStatusBar() {  
		return PageFactory.initElements(driver, StatusBar.class);
	}

	@FindBy(how = How.TAG_NAME, using = "h2")
	  @CacheLookup
	  public WebElement header;
	
	@FindBy(how = How.XPATH, using = "//h2/parent::div/p")
	@CacheLookup
	public WebElement pageDescription;
	
	@FindBy(how = How.XPATH, using = "//h2/parent::div/p[2]")
	@CacheLookup
	public WebElement formDescription;
	
	@FindBy(how = How.XPATH, using = "//h2/parent::div/p[3]")
	@CacheLookup
	public WebElement requiredFields;
	
	@FindBy(how = How.ID, using  = "firstName")
	@CacheLookup
	public WebElement firstName;
	
	@FindBy(how = How.ID, using  = "lastName")
	@CacheLookup
	public WebElement lastName;

	@FindBy(how = How.ID, using  = "middleName")
	@CacheLookup
	public WebElement middleName;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-fjdhpX gfENbg'][1]/div/input")
	@CacheLookup
	public WebElement iDoNotHaveMiddleNameCheck;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-fjdhpX gfENbg'][1]/div/div")
	@CacheLookup
	public WebElement iDoNotHaveMiddleNameMessage;
	
	@FindBy(how = How.XPATH, using  = "//label[@for='date']/following-sibling::div/div[1]")
	@CacheLookup
	public WebElement month;
	
	@FindBy(how = How.XPATH, using  = "//label[@for='date']/following-sibling::div/div[2]")
	@CacheLookup
	public WebElement day;
	
	@FindBy(how = How.XPATH, using  = "//label[@for='date']/following-sibling::div/div[3]")
	@CacheLookup
	public WebElement year;
	
	@FindBy(how = How.XPATH, using  = "//label[@for='gender']/following-sibling::div/div")
	@CacheLookup
	public WebElement gender;
	
	@FindBy(how = How.ID, using  = "ssn")
	@CacheLookup
	public WebElement ssn;
	
	@FindBy(how = How.ID, using  = "zipcode")
	@CacheLookup
	public WebElement zipCode;
	
	@FindBy(how = How.ID, using  = "email")
	@CacheLookup
	public WebElement email;
	
	@FindBy(how = How.ID, using  = "phone")
	@CacheLookup
	public WebElement phone;
	
	@FindBy(how = How.XPATH, using  = "//label[@for='driversLicenseState']/following-sibling::div/div")
	@CacheLookup
	public WebElement driverLicenseState;

	@FindBy(how = How.ID, using  = "driversLicenseNumber")
	@CacheLookup
	public WebElement driverLicenseNumber;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-TOsTZ iTLWsy'][1]/div")
	@CacheLookup
	public WebElement iCertifyCheck;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-TOsTZ iTLWsy'][1]/p")
	@CacheLookup
	public WebElement iCertifyMessage;
	
	@FindBy(how = How.XPATH, using  = "//button[contains(.,'Continue')]")
	@CacheLookup
	public WebElement continueButton;
}
