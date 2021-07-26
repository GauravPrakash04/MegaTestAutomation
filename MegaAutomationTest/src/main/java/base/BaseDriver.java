package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	
	public static WebDriver driver;
	
	
	//public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
	 
	
	public WebDriver initialiseDriver (String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			//threadLocal.set(new ChromeDriver());
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			ChromeOptions handlingSSL = new ChromeOptions();

			handlingSSL.setAcceptInsecureCerts(true);

			driver = new ChromeDriver(handlingSSL);

			handlingSSL.setExperimentalOption("useAutomationExtension", false);
			handlingSSL.addArguments("--disable-extensions");
			handlingSSL.addArguments("--no-sandbox");
			handlingSSL.addArguments("--ignore-certificate-errors");
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			//threadLocal.set(new FirefoxDriver());
			
		}
		else {
			System.out.println("Please enter a correct browser name");
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}
	

}
