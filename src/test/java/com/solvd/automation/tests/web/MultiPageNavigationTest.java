package com.solvd.automation.tests.web;

import com.solvd.automation.gui.pages.HomePage;
import com.solvd.automation.gui.pages.MacPage;
import com.solvd.automation.gui.pages.IPhonePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiPageNavigationTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(MultiPageNavigationTest.class);

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testNavigateToMacPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        if (homePage.getMacLink().isElementPresent()) {
            LOGGER.info("Mac link is present, clicking...");
            homePage.clickMacLink();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            MacPage macPage = new MacPage(getDriver());
            Assert.assertTrue(macPage.isPageOpened(), "Mac page should be opened");

            String macPageTitle = macPage.getPageTitle();
            LOGGER.info("Mac page title from page object: '{}'", macPageTitle);
            Assert.assertNotNull(macPageTitle, "Mac page title should not be null");
            Assert.assertFalse(macPageTitle.isEmpty(), "Mac page title should not be empty");

            String macUrl = getDriver().getCurrentUrl();
            Assert.assertTrue(macUrl.contains("mac") || macUrl.contains("Mac"),
                "URL should contain 'mac'. Actual URL: " + macUrl);

            boolean isHeaderDisplayed = macPage.getHeader().isHeaderDisplayed();
            Assert.assertTrue(isHeaderDisplayed, "Header should be displayed on Mac page");

            boolean isFooterDisplayed = macPage.getFooter().isFooterDisplayed();
            Assert.assertTrue(isFooterDisplayed, "Footer should be displayed on Mac page");
        } else {
            LOGGER.warn("Mac link is not present, skipping navigation test");
        }
    }

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testNavigateToIPhonePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        if (homePage.getIphoneLink().isElementPresent()) {
            homePage.clickIphoneLink();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            IPhonePage iphonePage = new IPhonePage(getDriver());
            Assert.assertTrue(iphonePage.isPageOpened(), "iPhone page should be opened");

            String iphonePageTitle = iphonePage.getPageTitle();
            LOGGER.info("iPhone page title from page object: '{}'", iphonePageTitle);
            Assert.assertNotNull(iphonePageTitle, "iPhone page title should not be null");
            Assert.assertFalse(iphonePageTitle.isEmpty(), "iPhone page title should not be empty");

            String iphoneUrl = getDriver().getCurrentUrl();
            Assert.assertTrue(iphoneUrl.contains("iphone") || iphoneUrl.contains("iPhone"),
                "URL should contain 'iphone'. Actual URL: " + iphoneUrl);

            boolean isHeaderDisplayed = iphonePage.getHeader().isHeaderDisplayed();
            Assert.assertTrue(isHeaderDisplayed, "Header should be displayed on iPhone page");

            boolean isFooterDisplayed = iphonePage.getFooter().isFooterDisplayed();
            Assert.assertTrue(isFooterDisplayed, "Footer should be displayed on iPhone page");

            if (iphonePage.getIphone17ProLink().isElementPresent()) {
                LOGGER.info("iPhone 17 Pro link is present and clickable: {}", 
                    iphonePage.getIphone17ProLink().isClickable());
                
                String currentUrlBeforeClick = getDriver().getCurrentUrl();
                iphonePage.getIphone17ProLink().click();
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                String currentUrlAfterClick = getDriver().getCurrentUrl();
                LOGGER.info("URL before click: {}", currentUrlBeforeClick);
                LOGGER.info("URL after click: {}", currentUrlAfterClick);
                
                Assert.assertNotEquals(currentUrlAfterClick, currentUrlBeforeClick, 
                    "URL should change after clicking iPhone 17 Pro link");
                Assert.assertTrue(currentUrlAfterClick.contains("iphone-17-pro"), 
                    "URL should contain 'iphone-17-pro'. Actual URL: " + currentUrlAfterClick);
            } else {
                LOGGER.warn("iPhone 17 Pro link is not present on iPhone page");
            }
        } else {
            LOGGER.warn("iPhone link is not present, skipping navigation test");
        }
    }
}
