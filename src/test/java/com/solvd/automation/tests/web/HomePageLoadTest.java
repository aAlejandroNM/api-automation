package com.solvd.automation.tests.web;

import com.solvd.automation.gui.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageLoadTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testHomePageLoads() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("apple.com"), 
            "URL should contain 'apple.com'. Actual URL: " + currentUrl);

        String pageTitle = getDriver().getTitle();
        Assert.assertNotNull(pageTitle, "Page title should not be null");
        Assert.assertFalse(pageTitle.isEmpty(), "Page title should not be empty");

        Assert.assertTrue(homePage.isLogoDisplayed(), "Apple logo should be displayed");
    }
}

