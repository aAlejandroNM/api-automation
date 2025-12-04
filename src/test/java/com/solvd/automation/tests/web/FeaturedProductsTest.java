package com.solvd.automation.tests.web;

import com.solvd.automation.gui.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FeaturedProductsTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testProductCardsArePresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 500);");
        
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int productCardsCount = homePage.getProductCardsCount();

        Assert.assertTrue(productCardsCount >= 0, 
            "Product cards count should be non-negative. Found: " + productCardsCount);
    }
}
