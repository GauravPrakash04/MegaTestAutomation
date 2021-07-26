package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseDriver;

public class SyncMegaDesktopAppPage extends BaseDriver {
	
	private WebDriver driver= BaseDriver.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	private By linux = By.xpath("//div[@class=\"bottom-page nav-buttons-bl contrast dark\"]/a[@data-os=\"linux\"]/span[text()=\" Linux \"]");
	private By distroDropDown = By.xpath("//div[text()=\"Download the MEGA Desktop App for your platform\"]/following-sibling::div[@class=\"megaapp-linux-box-container\"]/div/div[@class=\"megaapp-linux-container\"]/div[@class=\"megaapp-linux-info linux-txt\"]/following-sibling::div[@class=\"megaapp-inputs-wrap\"]/div/span");
	private By topIconMenu =By.xpath("//i[@class=\"top-icon menu sprite-fm-mono icon-side-menu\"]");
	private By platforms = By.xpath("//i[@class=\"sprite-fm-mono icon-platforms\"]/following-sibling::span[text()=\"Platforms\"]");
	private By megaDesktopApp = By.xpath("//div[@class=\"top-menu-item submenu-item expanded\"]/following-sibling::div/div[text()=\"MEGA Desktop App\"]");
	private By archLinux = By.xpath("//span[text()=\"Arch Linux\"]");
	private By download = By.xpath("//button[text()=\" Download \"]");
	
	
	
	public void navigateToSyncPage() throws InterruptedException {
		driver.findElement(topIconMenu).click();
		Thread.sleep(2000);
		driver.findElement(platforms).click();
		Thread.sleep(2000);
		driver.findElement(megaDesktopApp).click();
		Thread.sleep(2000);
		
		
		
	}
	public void linuxDesktopAppOption () throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(linux));
		driver.findElement(linux).click();
		Thread.sleep(3000);
		
	}
	
	public void VerifylinuxDistroDownloadable () throws InterruptedException {
		
		driver.findElement(distroDropDown).click();
		Thread.sleep(2000);
		driver.findElement(archLinux).click();
		Thread.sleep(2000);
		
		for (int i=1;i<=34;i++) {
			
			
			String a = "//div[@data-client-id=";
			String b = "\""+i+"\"";		
			String d= "]";
			
			String dataClientId =a+b+d;
			
			
			
			
			
			
		driver.findElement(distroDropDown).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(dataClientId)).click();
		Thread.sleep(2000);
		boolean enable= driver.findElement(download).isEnabled();
		System.out.println("---Dowload button is enabled---" + enable);
		assertTrue(enable);
		System.out.println("---Assertion complete---");
		System.out.println("Value of xPath : "+dataClientId);
		System.out.println("Value of dataClientId : "+i);
		}
	}

}
