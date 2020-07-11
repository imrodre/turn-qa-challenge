package backgroundCheck.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import backgroundCheck.pages.ConfirmationPage;

/**
 * It helps to perform common WebElements actions
 * 
 * @author Rodrigo Moran
 */
public class ElementUtils {

	WaitHelper wait = new WaitHelper();

	/**
	 * Type text into input element
	 * @param driver
	 * @param inputElement
	 * @param value
	 */
	public void inputText(WebDriver driver, WebElement inputElement, String value) {
		focusElement(driver, inputElement);
		inputElement.sendKeys(value);
	}

	/**
	 * Select option from dropdown based on data-value attribute
	 * @param driver
	 * @param dropDownElement
	 * @param index
	 * @throws InterruptedException
	 */
	public void selectValueFromDropdownMenu(WebDriver driver, WebElement dropDownElement, String index)
			throws InterruptedException {
		Thread.sleep(500);
		dropDownElement.click();
		Thread.sleep(500);
		WebElement option = dropDownElement.findElement(By.xpath("//li[@data-value='" + index + "']"));
		focusElement(driver, option);
		option.click();
	}

	/**
	 * It helps WebDriver to get WebElement visible to interact with it
	 * @param driver
	 * @param element
	 */
	public void focusElement(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Check check box
	 * @param driver
	 * @param checkBox
	 */
	public void checkBox(WebDriver driver, WebElement checkBox) {
		focusElement(driver, checkBox);
		if (checkBox.isSelected())
			return;
		checkBox.click();
	}

	/**
	 * Uncheck check box
	 * @param driver
	 * @param checkBox
	 */
	public void uncheckBox(WebDriver driver, WebElement checkBox) {
		focusElement(driver, checkBox);
		if (!checkBox.isSelected())
			return;
		checkBox.click();
	}

	/**
	 * Clicks element if enabled and visible
	 * @param driver
	 * @param element
	 */
	public void clickElement(WebDriver driver, WebElement element) {
		focusElement(driver, element);
		if (!element.isEnabled())
			return;
		element.click();
	}

	/**
	 * Verifies element is present in DOM
	 * @param driver
	 * @param element
	 * @return
	 */
	public boolean isElementPresent(WebDriver driver, WebElement element) {
		try {
			wait.elementToBeVisible(driver, element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Verifies if ConfirmationPage is normal view or alternative view 
	 * @param driver
	 * @param confirmationPage
	 * @return
	 */
	public boolean isAlternativeConfirmationPage(WebDriver driver, ConfirmationPage confirmationPage) {
		try {
			new WaitHelper().waitUntilFound(driver, confirmationPage.firstNameValue);
			return false;
		} catch (TimeoutException e) {
			return true;
		}
	}
}
