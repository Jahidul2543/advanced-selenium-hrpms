package com.herokuapp.theinternet.homepagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTests extends TestUtilities {

    /**
     * 1. (WelcomePage) Go to KeyPresses Page from welcome page - Click Key Presses link in welcome page
     * 2. (KeyPress) Press the key
     * 3. Get the value
     * 4. Verify - Assert the actual value with expected value
     * 5. The End
     * */
    @Test
    public void pressKeyTest(){
        log.info("Start of the pressKeyTest");
        HomePage homePage = new HomePage(driver, log);
        homePage.openPage();

        //Assert.assertTrue(actualText.equals("You entered: TAB"), "Result is not expected");


    }
}
