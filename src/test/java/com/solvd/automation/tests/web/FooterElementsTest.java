package com.solvd.automation.tests.web;

import com.solvd.automation.gui.components.Footer;
import com.solvd.automation.gui.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FooterElementsTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testFooterIsPresentUsingComponent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        
        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        Footer footer = homePage.getFooter();

        footer.scrollToFooter();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Assert.assertTrue(footer.isFooterDisplayed(), 
            "Footer should be displayed after scrolling");

        String footerText = footer.getFooterText();
        Assert.assertNotNull(footerText, "Footer text should not be null");
        Assert.assertFalse(footerText.isEmpty(), "Footer text should not be empty");
    }

    @Test
    @MethodOwner(owner = "ui-automation")
    public void testFooterLinksAreClickableUsingComponent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page should be opened");

        Footer footer = homePage.getFooter();

        footer.scrollToFooter();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<ExtendedWebElement> footerLinks = footer.getFooterLinks();

        Assert.assertFalse(footerLinks.isEmpty(),
                "Footer should contain links. Found: " + footerLinks.size());

        long clickableLinksCount = footerLinks.stream()
                .filter(link -> link.isElementPresent() && link.isClickable())
                .count();

        Assert.assertTrue(clickableLinksCount > 0,
                "At least one footer link should be clickable. Found: " + clickableLinksCount);
    }
}
