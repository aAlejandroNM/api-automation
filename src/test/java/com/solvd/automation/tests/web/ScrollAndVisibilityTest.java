package com.solvd.automation.tests.web;

import com.solvd.automation.gui.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollAndVisibilityTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testScrollToFooter() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        homePage.scrollToFooter();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Assert.assertTrue(homePage.isFooterDisplayed(), 
            "Footer should be displayed after scrolling");
    }

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testScrollAndVerifyElementVisibility() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        Assert.assertTrue(homePage.isHeaderDisplayed(), 
            "Header should be visible on page load");

        homePage.scrollToFooter();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Assert.assertTrue(homePage.isFooterDisplayed(), 
            "Footer should be visible after scrolling");

        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0);");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Assert.assertTrue(homePage.isHeaderDisplayed(), 
            "Header should be visible after scrolling back to top");
    }
}

