package stepDefinitions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import base.BaseDriver;
import io.cucumber.java.en.*;
import pages.MegaLandingPage;
import pages.UserHomePage;
import pages.UserLoginPage;
import util.FileActions;


public class Automation_Test_1_StepDefinitions {
	


	MegaLandingPage megaLandingPage = new MegaLandingPage();
	UserLoginPage userLoginpage = new UserLoginPage();
	UserHomePage userHomePage = new UserHomePage();
	FileActions fileActions = new FileActions();
	
	
	
	@Given("Mega application launched on browser accepting cookies and user is logged into the User FILE Manager page")
	public void mega_web_application_is_launched_on_browser_using_url_https_www_mega_nz_and_user_loggedIn () throws InterruptedException { 
		BaseDriver.getDriver().get("https://www.mega.nz");
		System.out.println("----Mega app is launched----");
		Thread.sleep(10000);
		megaLandingPage.acceptAllCookies();
		System.out.println("----Cookies Accepted----");
		Thread.sleep(8000);
		megaLandingPage.verifyLandingPage();
		System.out.println("----Login Button Visible----");
		megaLandingPage.navigateToUserLogin();
		System.out.println("User is on login page");
		userLoginpage.userLogin();
		userHomePage.VerifyUserHome();
	    
	}
	
	@When("User creates a text file a.text with content \"megatesting\" and uploads it using File Upload")
	public void create_file_and_upload_in_fileManager() throws InterruptedException {
		fileActions.createFile();
		fileActions.writeFile();
		

	    
	    
	}
	
	@Then("User should verify that a.text is successfully uploaded in File Manager")
	public void file_successfully_uploaded_in_File_Manager() throws InterruptedException {
		userHomePage.uploadFileFromSystem();
		userHomePage.verifyFile();
	}
	
	@Given("The text file \"a.text\" with content \"megatesting\" is created and uploaded in File Manager")
	public void file_is_created_and_uploaded_in_file_manager () throws InterruptedException {

		BaseDriver.getDriver().get("https://www.mega.nz");
		System.out.println("----Mega app is launched----");
		Thread.sleep(10000);
		megaLandingPage.acceptAllCookies();
		System.out.println("----Cookies Accepted----");
		Thread.sleep(10000);
		megaLandingPage.verifyLandingPage();
		System.out.println("----Login Button Visible----");
		megaLandingPage.navigateToUserLogin();
		System.out.println("User is on login page");
		userLoginpage.userLogin();
		userHomePage.VerifyUserHome();
		
	}

	@When("User Deletes the\"a.text\" file")
	public void user_deletes_the_file () throws InterruptedException {
		try {
			userHomePage.deleteFileinMegaApp();
		} catch (Exception e) {
			System.out.println("File Not Found in Mega App");
			
		}
	}


	@Then("The \"a.text\" file should get deleted")
	public void file_successfully_deleted_from_File_Manager() throws InterruptedException {
		userHomePage.verifyFile();
	}
	
	@Given("The text file \"a.text\" was deleted from File Manager")
	public void file_was_deleted () throws InterruptedException {
		
		BaseDriver.getDriver().get("https://www.mega.nz");
		System.out.println("----Mega app is launched----");
		Thread.sleep(10000);
		megaLandingPage.acceptAllCookies();
		System.out.println("----Cookies Accepted----");
		Thread.sleep(10000);
		megaLandingPage.verifyLandingPage();
		System.out.println("----Login Button Visible----");
		megaLandingPage.navigateToUserLogin();
		System.out.println("User is on login page");
		userLoginpage.userLogin();
		userHomePage.VerifyUserHome();

	}

	@When("User enters Rubbish Bin and restores file \"a.text\"")
	public void restrore_the_file () throws InterruptedException {
		userHomePage.restoreFile();
	}


	@Then("The \"a.text\" file should get restored to File Manager")
	public void file_restrored_to_File_Manager() throws InterruptedException {
		userHomePage.verifyFile();
	}



	
}
