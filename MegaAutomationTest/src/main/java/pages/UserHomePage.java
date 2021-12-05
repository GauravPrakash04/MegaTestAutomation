package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseDriver;


public class UserHomePage extends BaseDriver {
	
	private WebDriver driver= BaseDriver.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	
	private By myFileText = By.xpath("//span[text()=\"My Files\"]");
	private By uploadButton = By.xpath("//span[text()=\"Upload…\"]");
	private By fileUpload = By.xpath("//button[@class=\"fm-file-upload dropdown-btn\"]//following-sibling::input[@id=\"fileselect1\"]");
	private By closePopup = By.xpath("//button[@class=\"btn-icon transfer-progress-icon tpw-close close\"]");
	private By taskStatus = By.xpath("//div[@class=\"transfer-task-status\"]");
	private By fileName = By.xpath("//div[@class=\"propreties-dark-txt\"]");
	private By fileSettings = By.xpath("//span[@class=\"block-view-file-type text file\"]//following-sibling::span[@class=\"file-settings-icon\"]/i");
	private By infoOption = By.xpath("//span[text()=\"Info\"]");
	private By closeInfoButton = By.xpath("//div[@class=\"mega-dialog properties-dialog\"]/button/i");
	private By removeOption =By.xpath("//a[@class=\"dropdown-item remove-item\"]/i/following-sibling::span");
	private By yesButtonToRemoveFile = By.xpath("//div[@class=\"mega-dialog dialog-template-message warning\"]/footer/div/div/button[2]/span");
	private By rubbishBin = By.xpath("//button[text()=\"Rubbish Bin \"]");
	private By fileInRubbishBin = By.xpath("//span[@class=\"transfer-filetype-icon text file\"]/following-sibling::span[text()=\"a.txt\"]");
	private By settingsRubbishBin = By.xpath("//td[@class=\"grid-url-field own-data\"]/a/i");
	private By restoreOption = By.xpath("//span[text()=\"Restore\"]");
	
	public boolean VerifyUserHome() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(myFileText));
		String FileText=driver.findElement(myFileText).getText();
		
		if(FileText=="My Files") {
			System.out.println("User is on Home Page");
			return true;
		}
		
			
		return false;
		
	}
	
	public void uploadFileFromSystem() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.findElement(uploadButton).click();
		System.out.println("upload button clicked");
		Thread.sleep(2000);
		driver.findElement(fileUpload).sendKeys("C:\\Gaurav\\a.txt");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(taskStatus));
		Thread.sleep(10000);
		System.out.println("File Uploaded successfully");
		driver.findElement(closePopup).click();

		
	}
	
	public void verifyFile() throws InterruptedException {
		
		try {
			Thread.sleep(4000);
			driver.findElement(fileSettings).click();
			Thread.sleep(2000);
			driver.findElement(infoOption).click();
			Thread.sleep(2000);
			String FileName = driver.findElement(fileName).getText();
			System.out.println("File Name is : "+FileName);	
			Thread.sleep(2000);
			driver.findElement(closeInfoButton).click();
		} catch (Exception e) {
			System.out.println("File deleted or Not Found in Mega App");
			
		}
		
	}
	
	public void deleteFileinMegaApp() throws InterruptedException {
		
		Thread.sleep(8000);
		driver.findElement(fileSettings).click();
		Thread.sleep(2000);
		driver.findElement(removeOption).click();
		Thread.sleep(2000);
		driver.findElement(yesButtonToRemoveFile).click();
		System.out.println("File Deleted");
		Thread.sleep(5000);
	}
	
	public void restoreFile() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(rubbishBin).click();
		Thread.sleep(2000);
		driver.findElement(fileInRubbishBin).click();
		Thread.sleep(2000);
		driver.findElement(settingsRubbishBin).click();
		Thread.sleep(2000);
		driver.findElement(restoreOption).click();
		Thread.sleep(10000);
	
		
	}


	

}
