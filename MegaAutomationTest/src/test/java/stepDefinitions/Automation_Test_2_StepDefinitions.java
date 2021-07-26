package stepDefinitions;


import base.BaseDriver;
import io.cucumber.java.en.*;
import pages.MegaLandingPage;
import pages.SyncMegaDesktopAppPage;
import pages.UserLoginPage;

public class Automation_Test_2_StepDefinitions {
	
	SyncMegaDesktopAppPage syncDesktopApp = new SyncMegaDesktopAppPage();
	MegaLandingPage megaLandingPage = new MegaLandingPage();
	
	@Given("User launches https\\/\\/www.mega.nz\\/sync url in the browser")
	public void user_launches_mega_sync_page() throws InterruptedException {
		BaseDriver.getDriver().get("https://www.mega.nz");
		System.out.println("----Mega app is launched----");
		Thread.sleep(10000);
		megaLandingPage.acceptAllCookies();
		System.out.println("----Cookies Accepted----");
		Thread.sleep(8000);
		syncDesktopApp.navigateToSyncPage();
	    
	    
	}

	@When("User clicks on Linux option")
	public void user_clicks_on_Linux_option() throws InterruptedException {
		syncDesktopApp.linuxDesktopAppOption();
		
	    
	}



	@Then("All the distros are downloadable")
	public void all_the_distros_are_downloadable() throws InterruptedException {
		syncDesktopApp.VerifylinuxDistroDownloadable();

	}

	
}
