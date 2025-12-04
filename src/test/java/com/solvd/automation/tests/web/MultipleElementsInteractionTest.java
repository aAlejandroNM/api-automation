package com.solvd.automation.tests.web;

import com.solvd.automation.gui.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleElementsInteractionTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(MultipleElementsInteractionTest.class);

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testClickMultipleNavigationLinks() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");
        
        String initialUrl = getDriver().getCurrentUrl();
        
        if (homePage.getMacLink().isElementPresent()) {
            LOGGER.info("Clicking Mac link");
            homePage.clickMacLink();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            String macUrl = getDriver().getCurrentUrl();
            Assert.assertNotEquals(macUrl, initialUrl, 
                "URL should change after clicking Mac link");
        }
        
        homePage.open();
        
        if (homePage.getIpadLink().isElementPresent()) {
            LOGGER.info("Clicking iPad link");
            homePage.clickIpadLink();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            String ipadUrl = getDriver().getCurrentUrl();
            Assert.assertNotEquals(ipadUrl, initialUrl, 
                "URL should change after clicking iPad link");
        }
    }

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testNavigateBetweenSections() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");
        
        String homeUrl = getDriver().getCurrentUrl();
        
        if (homePage.getMacLink().isElementPresent()) {
            LOGGER.info("Navigating to Mac section");
            homePage.clickMacLink();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            String macUrl = getDriver().getCurrentUrl();
            Assert.assertNotEquals(macUrl, homeUrl, 
                "Should navigate to Mac section");
        }
        
        homePage.open();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        if (homePage.getIphoneLink().isElementPresent()) {
            LOGGER.info("Navigating to iPhone section");
            homePage.clickIphoneLink();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            String iphoneUrl = getDriver().getCurrentUrl();
            Assert.assertNotEquals(iphoneUrl, homeUrl, 
                "Should navigate to iPhone section");
        }
    }
}

