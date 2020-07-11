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
import backgroundCheck.pages.InformationPage;
import backgroundCheck.pojo.InformationFormData;
import backgroundCheck.utils.BrowserUtils;
import backgroundCheck.utils.ElementUtils;
import backgroundCheck.utils.ExcelHelper;
import backgroundCheck.utils.FlowUtils;
import backgroundCheck.utils.Logger;
import backgroundCheck.utils.TestBase;
import backgroundCheck.utils.TestListener;

@Listeners({TestListener.class})
public class TC00004_TC000016_verifyInformationPageRequiredInputs extends TestBase{
	
	@DataProvider(name="TC00004_TC00016_E2E")
	public Object[][] loadFileData() throws Exception{
		Logger.logStep("Loading data");
		return ExcelHelper.getDataFromXls("TICKET002_TC04_TC16_E2E_InformationStage_DataValidation.xlsx"); //return Object containing data from excel source file
	}
	
	@Test(dataProvider="TC00004_TC00016_E2E",
			groups = { "priority4", "e2e", "legacy" })
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
		
		InformationPage informationPage = PageFactory.initElements(driver, InformationPage.class);
		Assert.assertFalse(informationPage.continueButton.isEnabled()); //If required params are not filled user should not be able to move fordwards
		Logger.comparingLogStep(informationPage.continueButton.isEnabled(), false);
	}
	
	@AfterMethod
	public void closeConnections() {
		Logger.logStep("Exiting site");
		BrowserUtils.closeSite(driver); //Close browser after completing each test (avoid this would cause slowness of execution)
	}
}
