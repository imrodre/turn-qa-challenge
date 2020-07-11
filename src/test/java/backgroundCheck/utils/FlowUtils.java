package backgroundCheck.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import backgroundCheck.enums.STAGES;
import backgroundCheck.pages.AuthorizationPage;
import backgroundCheck.pages.AuthorizationPageStateRigthsFlow;
import backgroundCheck.pages.ConfirmationPage;
import backgroundCheck.pages.DisclosurePage;
import backgroundCheck.pages.InformationPage;
import backgroundCheck.pages.RightsPage;
import backgroundCheck.pages.StateRightsPage;
import backgroundCheck.pojo.InformationFormData;

/**
 * Use it to navigate among Turn io site
 * Fill parameterized forms
 * Reach parameterized stages of the flow
 * 
 * @author Rodrigo Moran
 *
 */
public class FlowUtils {
	
	ElementUtils elementUtils = new ElementUtils();
	WaitHelper wait = new WaitHelper();
	
	/**
	 * method takes user to argument STAGES defined Page
	 * 
	 * @param stage, flow stage of the site
	 * @param informationData, data to fill Information page
	 * @param driver
	 * @throws InterruptedException
	 */
	public void reachStage(STAGES stage, InformationFormData informationData, WebDriver driver) throws InterruptedException {
				
		switch (stage) {
		case INFORMATION:
			reachAndFillInformationStg(driver, informationData);
			break;
		case RIGHTS:
			reachFillAndMoveInformationStg(driver, informationData, true);
			break;
		case DISCLOSURE:
			reachFillAndMoveRightsStg(driver, informationData, true);
			break;
		case STATE_RIGHTS:
			reachFillAndMoveDisclosureStg(driver, informationData, true);
		break;
		case AUTHORIZATION:
			reachFillAndMoveDisclosureStg(driver, informationData, true);
		break;
		case CONFIRMATION:
			reachFillAndMoveAuthorizationStg(driver, informationData, true);
		break;
		default:
			break;
		}
	}
	
	/**
	 * It helps decide user either to move back or forward after reaching any flow stage
	 * @param driver
	 * @param stage
	 * @param backOrForward
	 * @throws InterruptedException
	 */
	public void moveBackOrForwards(WebDriver driver, STAGES stage, boolean backOrForward) throws InterruptedException {
		
		WebElement move = null;
		
		switch (stage) {
		case INFORMATION:
			move = PageFactory.initElements(driver, InformationPage.class).continueButton;
		break;
		case RIGHTS:
			move = (backOrForward)  ?  PageFactory.initElements(driver, RightsPage.class).nextDocumentButton : PageFactory.initElements(driver, RightsPage.class).backButton;
			break;
		case DISCLOSURE:
			move = (backOrForward)  ?  PageFactory.initElements(driver, DisclosurePage.class).nextDocumentButton : PageFactory.initElements(driver, DisclosurePage.class).backButton;
			break;
		case AUTHORIZATION:
			move = (backOrForward)  ?  PageFactory.initElements(driver, AuthorizationPage.class).reviewMyDataButton : PageFactory.initElements(driver, DisclosurePage.class).backButton;
		break;
		case CONFIRMATION:
			
		break;
		default:
			break;
		}
		
		move.click();
	}
	
	public void reachAndFillInformationStg(WebDriver driver, InformationFormData informationData) throws InterruptedException{
		
		Logger.logStep("Current page: " + STAGES.INFORMATION);
		
		InformationPage informationPage = PageFactory.initElements(driver, InformationPage.class);
		wait.elementToBeVisible(driver, informationPage.getStatusBar().information); //Wait page to load
		
		Logger.logStep("Filling values"); //Start filling values for Information Page based on InformationData
		elementUtils.inputText(driver, informationPage.firstName, informationData.firstName()); Logger.logStep("First name: " + informationData.firstName());
		elementUtils.inputText(driver, informationPage.lastName, informationData.lastName()); Logger.logStep("Last name: " + informationData.lastName());
		
		Logger.logStep("It has Middle Name: " + informationData.hasMiddleName());
		if(informationData.hasMiddleName()) {
			elementUtils.inputText(driver, informationPage.middleName, informationData.middleName()); Logger.logStep("Middle name: " + informationData.middleName());
		}else {
			elementUtils.checkBox(driver, informationPage.iDoNotHaveMiddleNameCheck); Logger.logStep("I don't have a Middle Name  CheckBox checked: " + true);
		}
		
		elementUtils.selectValueFromDropdownMenu(driver, 
				informationPage.month, 
				informationData.monthOfBirthday());
		
		elementUtils.selectValueFromDropdownMenu(driver,
				informationPage.day,
				informationData.dayOfBirthday());
		
		elementUtils.selectValueFromDropdownMenu(driver,
				informationPage.year,
				informationData.yearOfBirthday());
		Logger.logStep("Date Of Birthday: " + informationData.dateOfBirth());
		
		elementUtils.selectValueFromDropdownMenu(driver,
				informationPage.gender,
				informationData.gender()); Logger.logStep("Gender: " + informationData.gender());
		
		elementUtils.inputText(driver, informationPage.ssn, informationData.ssn());	Logger.logStep("SSN: " +informationData.ssn());
		
		elementUtils.inputText(driver, informationPage.zipCode, informationData.zipCode());	Logger.logStep("Zip Code: " +informationData.zipCode());
		
		elementUtils.inputText(driver, informationPage.email, informationData.email()); Logger.logStep("Email: " +informationData.email());
		
		elementUtils.inputText(driver, informationPage.phone, informationData.phoneNumber()); Logger.logStep("Phone Number: " +informationData.phoneNumber());
		
		elementUtils.selectValueFromDropdownMenu(driver,
				informationPage.driverLicenseState,
				informationData.driverLicenseState()); Logger.logStep("Driver License State: " +informationData.driverLicenseState());
		
		elementUtils.inputText(driver, informationPage.driverLicenseNumber, informationData.driverLicenseNumber());	Logger.logStep("Driver License Number: " +informationData.driverLicenseNumber());
		
		elementUtils.checkBox(driver, informationPage.iCertifyCheck); Logger.logStep("I certify that it's me CheckBox checked: " + true);
		
	}

	public void reachFillAndMoveInformationStg(WebDriver driver, InformationFormData informationData, boolean moveBackOrForwards) throws InterruptedException{
		reachAndFillInformationStg(driver, informationData);
		
		if(moveBackOrForwards)
			moveBackOrForwards(driver, STAGES.INFORMATION, true);
	}
	
	public void reachAndFillRightsStg(WebDriver driver, InformationFormData informationData, boolean iHaveRead) throws InterruptedException{
		reachFillAndMoveInformationStg(driver, informationData, true);
		
		Logger.logStep("Current page: " + STAGES.RIGHTS);
		
		RightsPage rightsPage = PageFactory.initElements(driver, RightsPage.class);
		wait.elementToBeVisible(driver, rightsPage.getStatusBar().rigths);
		
		if(iHaveRead)
			elementUtils.checkBox(driver, rightsPage.iHaveReadCheck);
		Logger.logStep("I have read summary of rights CheckBox checked: " + true);
	}
	
	public void reachFillAndMoveRightsStg(WebDriver driver, InformationFormData informationData, boolean moveBackOrForwards) throws InterruptedException{
		
		reachAndFillRightsStg(driver, informationData, true);
		
		moveBackOrForwards(driver, STAGES.RIGHTS, moveBackOrForwards);
	}
	
	public void reachAndFillDisclosureStg(WebDriver driver, InformationFormData informationData, boolean iHaveRead) throws InterruptedException{
		
		reachFillAndMoveRightsStg(driver, informationData, true);
		
		Logger.logStep("Current page: " + STAGES.DISCLOSURE);
		
		DisclosurePage disclosurePage = PageFactory.initElements(driver, DisclosurePage.class);
		wait.elementToBeVisible(driver, disclosurePage.getStatusBar().disclosure);
		
		if(iHaveRead)
			elementUtils.checkBox(driver, disclosurePage.iHaveReadCheck);
		Logger.logStep("I have read the Disclosure CheckBox checked: " + true);
	}
	
	public void reachFillAndMoveDisclosureStg(WebDriver driver, InformationFormData informationData, boolean moveBackOrForwards) throws InterruptedException{
		
		reachAndFillDisclosureStg(driver, informationData, true);
		
		moveBackOrForwards(driver, STAGES.DISCLOSURE, moveBackOrForwards);
	}
	
	public void fillStateRightsStg(WebDriver driver, boolean iWantToGetAcopy, boolean iHaveRead) {
		
		Logger.logStep("Current page: " + STAGES.STATE_RIGHTS);
		
		StateRightsPage stateRightsPage = PageFactory.initElements(driver, StateRightsPage.class);
		
		elementUtils.checkBox(driver, stateRightsPage.iWantToGetACopyCheck);
		Logger.logStep("I want ot get a copy CheckBox checked: " + true);
		elementUtils.checkBox(driver, stateRightsPage.iHaveReadCheck);
		Logger.logStep("I have read Summary of my State Rights CheckBox checked: " + true);
		
		elementUtils.clickElement(driver, stateRightsPage.nextDocumentButton);
	}
	
	public void reachAndFillAuthorizationStg(WebDriver driver, InformationFormData informationData, boolean iAgree) throws InterruptedException{
		
		reachFillAndMoveDisclosureStg(driver, informationData, true);
		
		StateRightsPage stateRightsPage = PageFactory.initElements(driver, StateRightsPage.class);
				
		if(elementUtils.isElementPresent(driver, stateRightsPage.getStatusBar().stateRights)) {
			fillStateRightsStg(driver, false, true);
			Logger.logStep("Current page: " + STAGES.AUTHORIZATION);
			AuthorizationPageStateRigthsFlow authorizationPageRightsStateFlow = PageFactory.initElements(driver, AuthorizationPageStateRigthsFlow.class);
			wait.elementToBeVisible(driver, authorizationPageRightsStateFlow.getStatusBar().authorization);
		
			if(iAgree)
				elementUtils.checkBox(driver, authorizationPageRightsStateFlow.iAgreeCheck);
			Logger.logStep("I indicate my agreement CheckBox checked: " + true);
			return;
		}
		
		Logger.logStep("Current page: " + STAGES.AUTHORIZATION);
			
		AuthorizationPage authorizationPage = PageFactory.initElements(driver, AuthorizationPage.class);	
		wait.elementToBeVisible(driver, authorizationPage.getStatusBar().authorization);
		
		if(iAgree)
			elementUtils.checkBox(driver, authorizationPage.iAgreeCheck);
		Logger.logStep("I indicate my agreement CheckBox checked: " + true);
	}
	
	public void reachFillAndMoveAuthorizationStg(WebDriver driver, InformationFormData informationData, boolean moveBackOrForwards) throws InterruptedException{
		reachAndFillAuthorizationStg(driver, informationData,  true);
		
		moveBackOrForwards(driver, STAGES.AUTHORIZATION, moveBackOrForwards);
		wait.elementToBeVisible(driver, PageFactory.initElements(driver, ConfirmationPage.class).getStatusBar().confirmation);
		
		Logger.logStep("Current page: " + STAGES.CONFIRMATION);
	}
		
}
