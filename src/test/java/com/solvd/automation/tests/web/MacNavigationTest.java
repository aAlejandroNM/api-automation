package com.solvd.automation.tests.web;

import com.solvd.automation.gui.pages.HomePage;
import com.solvd.automation.gui.pages.MacPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MacNavigationTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(MacNavigationTest.class);

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testNavigateToMacSection() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        Assert.assertTrue(homePage.getMacLink().isElementPresent(), 
            "Mac link should be present");
        Assert.assertTrue(homePage.getMacLink().isClickable(), 
            "Mac link should be clickable");

        String homeUrl = getDriver().getCurrentUrl();

        homePage.clickMacLink();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String newUrl = getDriver().getCurrentUrl();
        Assert.assertNotEquals(newUrl, homeUrl, 
            "URL should change after clicking Mac link");

        LOGGER.info("New URL: {}", newUrl);

        Assert.assertTrue(newUrl.contains("mac") || newUrl.contains("Mac"),
            "URL should contain 'mac' or 'Mac'. Actual URL: " + newUrl);
    }

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testMacPageElements() {
        MacPage macPage = new MacPage(getDriver());
        macPage.open();
        
        Assert.assertTrue(macPage.isPageOpened(), "Mac page should be opened");
        
        String pageTitle = macPage.getPageTitle();
        LOGGER.info("Page title found: '{}'", pageTitle);
        
        Assert.assertNotNull(pageTitle, "Mac page title should not be null");
        Assert.assertFalse(pageTitle.isEmpty(), "Mac page title should not be empty");
        
        boolean isHeaderDisplayed = macPage.getHeader().isHeaderDisplayed();
        LOGGER.info("Header displayed: {}", isHeaderDisplayed);
        Assert.assertTrue(isHeaderDisplayed, 
            "Header should be displayed on Mac page");
        
        boolean isFooterDisplayed = macPage.getFooter().isFooterDisplayed();
        LOGGER.info("Footer displayed: {}", isFooterDisplayed);

        Assert.assertTrue(isFooterDisplayed, 
            "Footer should be displayed on Mac page");
    }
}

