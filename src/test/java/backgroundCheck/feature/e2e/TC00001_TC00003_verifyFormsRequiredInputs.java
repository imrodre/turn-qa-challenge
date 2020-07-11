package backgroundCheck.feature.e2e;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import backgroundCheck.enums.STAGES;
import backgroundCheck.pages.AlternativeConfirmationPage;
import backgroundCheck.pages.ConfirmationPage;
import backgroundCheck.pojo.InformationFormData;
import backgroundCheck.utils.BrowserUtils;
import backgroundCheck.utils.ElementUtils;
import backgroundCheck.utils.ExcelHelper;
import backgroundCheck.utils.FlowUtils;
import backgroundCheck.utils.Logger;
import backgroundCheck.utils.TestBase;
import backgroundCheck.utils.TestListener;

@Listeners({TestListener.class})
public class TC00001_TC00003_verifyFormsRequiredInputs extends TestBase{
	
	@DataProvider(name="TC00001_TC00003_E2E")
	public Object[][] loadFileData() throws Exception{
		Logger.logStep("Loading data");
		return ExcelHelper.getDataFromXls("TICKET001_TC01_TC03_E2E_ConfirmationStage_DataValidation.xlsx"); //return Object containing data from excel source file
	}
	
	@Test(dataProvider="TC00001_TC00003_E2E",
			groups = { "priority1", "e2e", "legacy", "regression" })
	public void verifyFormRequiredInputs(
			String tcId, String stg, 
			String fstName, String lstName, 
			String midName,	String hasMidName, 
			String dayOfBdy, String monthOfBdy,
			String yearOfBdy, String gender, 
			String ssn, String zipCode, 
			String email, String phoneNum, 
			String driverLicenseSt, String driverLicenseNum) throws InterruptedException{
		
		Logger.logStep("Executing test: " + tcId);
		
		//Create new instance of InformationFormData to handle all data related to InformationPage
		InformationFormData informationData = new InformationFormData(fstName, lstName, midName, hasMidName, dayOfBdy, monthOfBdy, yearOfBdy, gender, ssn, zipCode, email, phoneNum, driverLicenseSt, driverLicenseNum);
		
		BrowserUtils.launchSite(driver); //Open browser and navigate to site
		
		new FlowUtils().reachStage(STAGES.valueOf(stg), informationData, driver); //Reach flow stage needed to do verifications
		
		verifyUserInputAgainstConfirmationPage(informationData); //Do ConfirmationPage actual vs expected(Input coming from InformationData) comparisons
	}
	
	@AfterMethod
	public void closeConnections() {
		Logger.logStep("Exiting site");
		BrowserUtils.closeSite(driver); //Close browser after completing each test (avoid this would cause slowness of execution)
	}
	
	private void verifyUserInputAgainstConfirmationPage(InformationFormData informationData) {
		
		Logger.logStep("Verifying data matches"); //Start doing test verifications
		
		ConfirmationPage confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
			
		if(new ElementUtils().isAlternativeConfirmationPage(driver, confirmationPage)) { //verifies if its alternative ConfirmationPage view
			Logger.logStep("Is Alternative Confirmation Page");
			compareAlternativeConfirmationPageData(informationData, PageFactory.initElements(driver, AlternativeConfirmationPage.class)); //Do data comparison for ConfirmationPage alternative view
			return;
		}
		
		compareConfirmationPageData(informationData, confirmationPage); //Do data comparision for ConfirmationPage normal view
	}

	private void compareConfirmationPageData(InformationFormData informationData, ConfirmationPage confirmationPage) {
		 
		Assert.assertEquals(confirmationPage.firstNameValue.getText(), informationData.firstName()); //Assertion actual value vs expected value
			Logger.comparingLogStep(confirmationPage.firstNameValue.getText(), informationData.firstName()); //Print comparison (informative only)
		
		Assert.assertEquals(confirmationPage.lastNameValue.getText(), informationData.lastName()); 
			Logger.comparingLogStep(confirmationPage.lastNameValue.getText(), informationData.lastName());
		
		if(informationData.hasMiddleName()) {
			Assert.assertEquals(confirmationPage.middleNameValue.get(0).getText(), informationData.middleName());
				Logger.comparingLogStep(confirmationPage.middleNameValue.get(0).getText(), informationData.middleName());
		}else {
			Assert.assertTrue(confirmationPage.middleNameLabel.isEmpty());
				Logger.comparingLogStep(confirmationPage.middleNameLabel.isEmpty(), true);
		}

		Assert.assertEquals(confirmationPage.emailValue.getText(), informationData.email());
			Logger.comparingLogStep(confirmationPage.emailValue.getText(), informationData.email());
		
		Assert.assertEquals(confirmationPage.phoneNumberValue.getText(), informationData.phoneNumber());
			Logger.comparingLogStep(confirmationPage.phoneNumberValue.getText(), informationData.phoneNumber());
		
		Assert.assertEquals(confirmationPage.dateOfBirthValue.getText(), informationData.dateOfBirth());
			Logger.comparingLogStep(confirmationPage.dateOfBirthValue.getText(), informationData.dateOfBirth());
		
		Assert.assertEquals(confirmationPage.ssnValue.getText(), informationData.ssn());
			Logger.comparingLogStep(confirmationPage.ssnValue.getText(), informationData.ssn());
		
		Assert.assertEquals(confirmationPage.genderValue.getText(), informationData.gender());
			Logger.comparingLogStep(confirmationPage.genderValue.getText(), informationData.gender());
		
		Assert.assertEquals(confirmationPage.zipCodeValue.getText(), informationData.zipCode());
			Logger.comparingLogStep(confirmationPage.zipCodeValue.getText(), informationData.zipCode());
		
		Assert.assertEquals(confirmationPage.driversLicenseNumberValue.getText(), informationData.driverLicenseNumber());
			Logger.comparingLogStep(confirmationPage.driversLicenseNumberValue.getText(), informationData.driverLicenseNumber());
		
		Assert.assertEquals(confirmationPage.driversLicenseStateValue.getText(), informationData.driverLicenseState());
			Logger.comparingLogStep(confirmationPage.driversLicenseStateValue.getText(), informationData.driverLicenseState());
	}
	
	private void compareAlternativeConfirmationPageData(InformationFormData informationData, AlternativeConfirmationPage confirmationPage) {
		
		Logger.comparingLogStep(confirmationPage.firstNameValue.getText(), informationData.firstName()); //Assertion actual value vs expected value
			Assert.assertEquals(confirmationPage.firstNameValue.getText(), informationData.firstName()); //Print comparison (informative only)
		
		Logger.comparingLogStep(confirmationPage.lastNameValue.getText(), informationData.lastName());
			Assert.assertEquals(confirmationPage.lastNameValue.getText(), informationData.lastName());
		
		if(informationData.hasMiddleName()) {
			Assert.assertEquals(confirmationPage.middleNameValue.getText(), informationData.middleName());
				Logger.comparingLogStep(confirmationPage.middleNameValue.getText(), informationData.middleName());
		}else {
			Assert.assertTrue(confirmationPage.middleNameValue.getText().isEmpty());
				Logger.comparingLogStep(confirmationPage.middleNameValue.getText().isEmpty(), true);
		}
		
		Assert.assertEquals(confirmationPage.emailValue.getText(), informationData.email());
			Logger.comparingLogStep(confirmationPage.emailValue.getText(), informationData.email());
		
		Assert.assertEquals(confirmationPage.phoneNumberValue.getText(), informationData.phoneNumber());
			Logger.comparingLogStep(confirmationPage.phoneNumberValue.getText(), informationData.phoneNumber());
		
		Assert.assertEquals(confirmationPage.dateOfBirthValue.getText(), informationData.dateOfBirth());
			Logger.comparingLogStep(confirmationPage.dateOfBirthValue.getText(), informationData.dateOfBirth());
		
		Assert.assertEquals(confirmationPage.ssnValue.getText(), informationData.ssn());
			Logger.comparingLogStep(confirmationPage.ssnValue.getText(), informationData.ssn());
		
		Assert.assertEquals(confirmationPage.genderValue.getText(), informationData.gender());
			Logger.comparingLogStep(confirmationPage.genderValue.getText(), informationData.gender());
		
		Assert.assertEquals(confirmationPage.zipCodeValue.getText(), informationData.zipCode());
			Logger.comparingLogStep(confirmationPage.zipCodeValue.getText(), informationData.zipCode());
		
		Assert.assertEquals(confirmationPage.driversLicenseNumberValue.getText(), informationData.driverLicenseNumber());
			Logger.comparingLogStep(confirmationPage.driversLicenseNumberValue.getText(), informationData.driverLicenseNumber());
		
		Assert.assertEquals(confirmationPage.driversLicenseStateValue.getText(), informationData.driverLicenseState());
			Logger.comparingLogStep(confirmationPage.driversLicenseStateValue.getText(), informationData.driverLicenseState());
	}
}
