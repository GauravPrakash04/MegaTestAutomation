package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseDriver;

public class MegaLandingPage extends BaseDriver {

	private WebDriver driver= BaseDriver.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	private By acceptAllCookies = By.xpath("//span[text()=\"Accept All Cookies\"]");
	private By loginButtonOnLandingPage = By.xpath("//button[@class=\"mega-button branded-red create-account-button\"]/following-sibling::button/span[text()='Log in']");
	
	//public MegaLandingPage(WebDriver driver) {
	//	this.driver = driver;
		
	//}
	
	public void acceptAllCookies() {
		driver.findElement(acceptAllCookies).click();
	}
	
	public void verifyLandingPage() {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonOnLandingPage));
			System.out.println("User is on Mega landing Page and Login button is visible");
		} catch (Exception e) {
			int counter=1;
			if (counter<=5) {
			System.out.println("Login Button not visible on home page. Refreshing the page :"+counter);
			driver.navigate().refresh();
			counter++;
			verifyLandingPage();
			}
		}
	}
	
	public void navigateToUserLogin() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonOnLandingPage));
		driver.findElement(loginButtonOnLandingPage).click();
	}
	
	
	
}
