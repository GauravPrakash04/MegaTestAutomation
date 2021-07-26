package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseDriver;

public class UserLoginPage extends BaseDriver {

	private WebDriver driver= BaseDriver.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	private By userName = By.xpath("//input[@id=\"login-name2\"]");
	private By password = By.xpath("//input[@id=\"login-password2\"]");
	private By userLoginButton = By.xpath("//button[@class=\"mega-button positive login-button large right\"]/span[text()=\"Log in\"]");
	
	public void userLogin() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		driver.findElement(userName).click();
		driver.findElement(userName).sendKeys("gov.prk@gmail.com");
		Thread.sleep(1000);
		driver.findElement(userName).click();
		driver.findElement(password).sendKeys("MegaTestAutomation@001");
		Thread.sleep(1000);
		driver.findElement(userLoginButton).click();
		Thread.sleep(1000);
		System.out.println("User has clicked login");
				
		
	}
	
}
