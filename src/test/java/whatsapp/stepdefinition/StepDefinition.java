package whatsapp.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.*;
import junit.framework.Assert;
import whatsapp.base.BaseClass;

public class StepDefinition extends BaseClass {
	@Given("The user launches Chrome Browser")
	public void theUserLaunchesChromeBrowser() {
		launchBrowser();
	}

	@Given("Login screen of whatsapp web application is displayed")
	public void loginScreenOfWhatsappWebApplicationIsDisplayed() {
		loadUrl("https://web.whatsapp.com/");
	}

	@When("User opens whatsapp web application in a new tab")
	public void userOpensWhatsappWebApplicationInANewTab() {
		openNewTab();
		loadUrl("https://web.whatsapp.com/");
	}

	@When("Switches back to previous tab")
	public void switchesBackToPreviousTab() {
		switchToWindow(0);
	}

	@Then("A popup with the message _Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ should be displayed with _CLOSE_ & _USE HERE_ options")
	public void aPopupWithTheMessage_WhatsappIsOpenInAnotherWindowClick_UseHere_ToUseWhatsAppInThisWindow_ShouldBeDisplayedWith_CLOSE__USEHERE_Options() {
		WebElement popUp = driver.findElement(By.xpath("//div[contains(text(),'WhatsApp is open in another window')]"));
		boolean displayCheck = popUp.isDisplayed();
		if (displayCheck == true) {
			System.out.println("Scenario 01 has passed successfully.");
			System.out.println(popUp.getText());
		} else {
			System.out.println("Scenario 01 Failed. PopUp is not displayed.");
		}
		screenshot();
		Assert.assertTrue("To check whether the pop-up is displayed", displayCheck);
		quitBrowser();
	}

	@Given("A popup with the message _ Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ is displayed")
	public void aPopupWithTheMessage_WhatsappIsOpenInAnotherWindowClick_UseHere_ToUseWhatsAppInThisWindow_AndOptions_CLOSE__USEHERE_IsDisplayed() {
		loadUrl("https://web.whatsapp.com/");
		openNewTab();
		loadUrl("https://web.whatsapp.com/");
		switchToWindow(0);
	}

	@When("User clicks on _USE HERE_ option")
	public void userClicksOn_USEHERE_Option() {
		WebElement buttonUseNow = driver.findElement(By.xpath("(//div[contains(text(),'Use Here')])[2]"));
		buttonClick(buttonUseNow);
	}

	@Then("Login page of whatsapp should get loaded")
	public void loginPageOfWhatsappShouldGetLoaded() {
		WebElement loadedScreen = driver.findElement(By.xpath("//canvas"));
		boolean screenLoad = loadedScreen.isDisplayed();
		Assert.assertTrue("To check whether the screen loads after clicking USE NOW", screenLoad);
	}

	@Then("In the previous tab, popup with message  _Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ should be displayed")
	public void inThePreviousTabPopupWithMessage_WhatsappIsOpenInAnotherWindowClick_UseHere_ToUseWhatsAppInThisWindow_AndOptions_CLOSE__USEHERE_ShouldBeDisplayed() {
		switchToWindow(1);
		WebElement popUp = driver.findElement(By.xpath("//div[contains(text(),'WhatsApp is open in another window')]"));
		boolean displayCheck = popUp.isDisplayed();
		if (displayCheck == true) {
			System.out.println("Scenario 02 has passed successfully.");
		} else {
			System.out.println("Scenario 02 Failed. PopUp is not displayed.");
		}
		screenshot();
		Assert.assertTrue("To check whether the pop-up is displayed", displayCheck);
		quitBrowser();

	}

	@Given("The popup with the message _ Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ is displayed")
	public void thePopupWithTheMessage_WhatsappIsOpenInAnotherWindowClick_UseHere_ToUseWhatsAppInThisWindow_AndOptions_CLOSE__USEHERE_IsDisplayed() {
		loadUrl("https://web.whatsapp.com/");
		openNewTab();
		loadUrl("https://web.whatsapp.com/");
		switchToWindow(0);
	}

	@When("User clicks on _CLOSE_ option")
	public void userClicksOn_CLOSE_Option() {
		WebElement buttonUseNow = driver.findElement(By.xpath("//div[contains(text(),'Close')]"));
		buttonClick(buttonUseNow);
	}

	@Then("Whatsapp.com page should get loaded")
	public void whatsappComPageShouldGetLoaded() {
		String title = driver.getTitle();
		if (!title.equals("web")) {
			System.out.println("Scenario 03 has passed successfully.");
		} else {
			System.out.println("Scenario 03 failed. Whatsapp homepage is not loaded");
		}
		screenshot();
		Assert.assertTrue("To verify that the Whatsapp homepage has loaded when the user clicks on the close button",
				!title.equals("web"));
		quitBrowser();
	}
}
