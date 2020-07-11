package backgroundCheck.utils;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 * Main purpose is to return Capabilities (configurations based on selected Browser to launch, cookies, etc...)
 * e.g chrome, firefox, ie, android device, ios device...etc
 * 
 * @author Rodrigo Moran
 */
public class TestBase {

  protected static URL gridHubUrl = null;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    SuiteConfiguration config = new SuiteConfiguration();
    /*
     * Read from src/test/resources/application.properties 
     * Browser to use
     * WebDriver to instantiate
     */
    System.setProperty(config.getCapabilities().getCapability("driverName").toString()
    		,	config.getCapabilities().getCapability("driverPath").toString());
    baseUrl = config.getProperty("site.url");
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
    capabilities = config.getCapabilities();
  }

  @BeforeMethod
  public void initWebDriver(ITestContext context) {
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    context.setAttribute("WebDriver", driver);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
}
