package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.pages.SecureAreaPage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.HomePage;

public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
		// open main page
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage();
		takeScreenshot("WelcomePage opened");

		// Click on Form Authentication link
		LoginPage loginPage = homePage.clickFormAuthenticationLink();
		takeScreenshot("LoginPage opened");
		
		// Add new cookie
		Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
		loginPage.setCookie(ck);
		
		// execute log in
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
		takeScreenshot("SecureAreaPage opened");
		
		// Get cookies
		String username = secureAreaPage.getCookie("username");
		log.info("Username cookie: " + username);
		String session = secureAreaPage.getCookie("rack.session");
		log.info("Session cookie: " + session);
		
		
		// Verifications
		// New page url is expected
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
