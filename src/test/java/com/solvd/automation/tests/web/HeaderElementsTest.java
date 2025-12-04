package com.solvd.automation.tests.web;

import com.solvd.automation.gui.components.Header;
import com.solvd.automation.gui.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HeaderElementsTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testHeaderElementsUsingComponent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        Header header = homePage.getHeader();

        Assert.assertTrue(header.isHeaderDisplayed(),
                "Header should be displayed on the page");

        Assert.assertTrue(header.isLogoDisplayed(),
                "Logo should be displayed");

        if (header.getAppleLogo().isElementPresent()) {
            Assert.assertTrue(header.getAppleLogo().isClickable(),
                    "Apple logo should be clickable");
        }

        List<ExtendedWebElement> navigationLinks = header.getNavigationLinks();
        Assert.assertFalse(navigationLinks.isEmpty(),
                "Header should contain navigation links. Found: " + navigationLinks.size());

        long clickableLinksCount = navigationLinks.stream()
                .filter(link -> link.isElementPresent() && link.isClickable())
                .count();

        Assert.assertTrue(clickableLinksCount > 0,
                "At least one navigation link should be clickable. Found: " + clickableLinksCount);
    }
}

