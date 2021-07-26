package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class AppHooks {

	private BaseDriver baseDriver;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperties() {
		configReader = new ConfigReader();
		prop = configReader.readPropertyFile();
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		baseDriver = new BaseDriver();
		System.out.println("Browser is : "+browserName);
		driver = baseDriver.initialiseDriver(browserName);
	}
		
	@After(order=0)
	public void quitDriver() {
		driver.quit();
	}
	
	@After(order=1)
	public void screenShots(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll("","_");
			byte [] screenShotPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShotPath, "image/jpg", screenshotName);
		}
		
	}
	
	
}
