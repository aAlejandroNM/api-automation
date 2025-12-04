package com.solvd.automation.tests.web;

import com.solvd.automation.gui.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InteractiveElementsTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(InteractiveElementsTest.class);

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testButtonsAreClickable() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        int totalElementsChecked = 0;
        int clickableElements = 0;
        
        ExtendedWebElement macLink = homePage.getMacLink();
        totalElementsChecked++;
        if (macLink.isElementPresent() && macLink.isClickable()) {
            clickableElements++;
            LOGGER.info("Mac link is present and clickable");
        }
        
        ExtendedWebElement ipadLink = homePage.getIpadLink();
        totalElementsChecked++;
        if (ipadLink.isElementPresent() && ipadLink.isClickable()) {
            clickableElements++;
            LOGGER.info("iPad link is present and clickable");
        }
        
        ExtendedWebElement iphoneLink = homePage.getIphoneLink();
        totalElementsChecked++;
        if (iphoneLink.isElementPresent() && iphoneLink.isClickable()) {
            clickableElements++;
            LOGGER.info("iPhone link is present and clickable");
        }
        
        ExtendedWebElement watchLink = homePage.getWatchLink();
        totalElementsChecked++;
        if (watchLink.isElementPresent() && watchLink.isClickable()) {
            clickableElements++;
            LOGGER.info("Watch link is present and clickable");
        }
        
        LOGGER.info("Navigation elements check completed. Total checked: {}, Clickable: {}", 
            totalElementsChecked, clickableElements);
        
        Assert.assertTrue(clickableElements > 0, 
            "At least one navigation element should be clickable. Found: " + clickableElements + 
            " out of " + totalElementsChecked + " checked");
    }
}
