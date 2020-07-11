package backgroundCheck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AlternativeConfirmationPage extends Page{

	public AlternativeConfirmationPage(WebDriver driver) {
		super(driver);		
	}
	
	public StatusBar getStatusBar() {  
		return PageFactory.initElements(driver, StatusBar.class);
	}	
		
	@FindBy(how = How.TAG_NAME, using = "h2")
	@CacheLookup
	public WebElement header;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-kjoXOD UNtpk']/div/div[2]/div[3]/div[5]/div/h2[@class='sc-jzJRlG gqcyfL']/following-sibling::div[1]")
	@CacheLookup
	public WebElement confirmationDescription;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'First Name')]")
	@CacheLookup
	public WebElement firstNameLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'First Name')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement firstNameValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Last Name')]")
	@CacheLookup
	public WebElement lastNameLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Last Name')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement lastNameValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Middle Name')]")
	@CacheLookup
	public WebElement middleNameLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Middle Name')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement middleNameValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Email')]")
	@CacheLookup
	public WebElement emailLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Email')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement emailValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Phone Number')]")
	@CacheLookup
	public WebElement phoneNumberLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Phone Number')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement phoneNumberValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Date of Birth')]")
	@CacheLookup
	public WebElement dateOfBirthLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Date of Birth')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement dateOfBirthValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'SSN')]")
	@CacheLookup
	public WebElement ssnLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'SSN')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement ssnValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Gender')]")
	@CacheLookup
	public WebElement genderLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Gender')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement genderValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Zip Code')]")
	@CacheLookup
	public WebElement zipCodeLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Zip Code')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement zipCodeValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Drivers License Number')]")
	@CacheLookup
	public WebElement driversLicenseNumberLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Drivers License Number')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement driversLicenseNumberValue;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Drivers License State')]")
	@CacheLookup
	public WebElement driversLicenseStateLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sc-fjdhpX lbAayS']/span[contains(text(),'Drivers License State')]/parent::div/following-sibling::div")
	@CacheLookup
	public WebElement driversLicenseStateValue;
	
	@FindBy(how = How.XPATH, using  = "//span[contains(.,'Edit')]")
	@CacheLookup
	public WebElement editFormButton;
	
	@FindBy(how = How.XPATH, using  = "(//div[@class='sc-TOsTZ iTLWsy'])[3]/div/div/input")
	@CacheLookup
	public WebElement iCertifyItsMe;
	
	@FindBy(how = How.XPATH, using  = "(//div[@class='sc-TOsTZ iTLWsy'])[3]/p")
	@CacheLookup
	public WebElement iCertifyItsMeMessage;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-TOsTZ cScYKh']")
	@CacheLookup
	public WebElement agreeTermsConditionsPrivacyPolicyText;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-TOsTZ cScYKh']/p/a")
	@CacheLookup
	public WebElement termsAndConditionsLink;
	
	@FindBy(how = How.XPATH, using  = "//div[@class='sc-TOsTZ cScYKh']/p/a[2]")
	@CacheLookup
	public WebElement PrivacyPolicyLink;
	
	@FindBy(how = How.XPATH, using  = "//label[@for='name']/following-sibling::div/div/input")
	@CacheLookup
	public WebElement nameToConfirmText;
	
	@FindBy(how = How.ID, using = "signature-pad")
	@CacheLookup
	public WebElement signaturePad;
	
	@FindBy(how = How.XPATH, using  = "//button[contains(.,'Clear')]")
	@CacheLookup
	public WebElement clearSignatureButton;
	
	@FindBy(how = How.XPATH, using  = "//button[contains(.,'Edit')]")
	@CacheLookup
	public WebElement editButton;
	
	@FindBy(how = How.XPATH, using  = "//button[contains(.,'Submit')]")
	@CacheLookup
	public WebElement SubmitButton;
}
