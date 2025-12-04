package com.solvd.automation.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//*[@id='globalnav-list']/li[1]/a | //a[@class='globalnav-link globalnav-link-apple']")
    private ExtendedWebElement appleLogo;

    @FindBy(xpath = "//a[@data-globalnav-item-name='mac']")
    private ExtendedWebElement macLink;

    @FindBy(xpath = "//a[@data-globalnav-item-name='ipad']")
    private ExtendedWebElement ipadLink;

    @FindBy(xpath = "//a[@data-globalnav-item-name='iphone']")
    private ExtendedWebElement iphoneLink;

    @FindBy(xpath = "//a[@data-globalnav-item-name='watch']")
    private ExtendedWebElement watchLink;

    @FindBy(xpath = "//*[@id=\'globalheader\']")
    private ExtendedWebElement headerContainer;

    @FindBy(xpath = "//*[@id=\'globalnav-list\']")
    private List<ExtendedWebElement> navigationLinks;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickMacLink() {
        macLink.click();
    }

    public void clickIpadLink() {
        ipadLink.click();
    }

    public void clickIphoneLink() {
        iphoneLink.click();
    }

    public boolean isLogoDisplayed() {
        return appleLogo.isElementPresent();
    }

    public boolean isHeaderDisplayed() {
        return headerContainer.isElementPresent();
    }

    public ExtendedWebElement getMacLink() {
        return macLink;
    }

    public ExtendedWebElement getIpadLink() {
        return ipadLink;
    }

    public ExtendedWebElement getIphoneLink() {
        return iphoneLink;
    }

    public ExtendedWebElement getWatchLink() {
        return watchLink;
    }

    public ExtendedWebElement getAppleLogo() {
        return appleLogo;
    }

    public List<ExtendedWebElement> getNavigationLinks() {
        return navigationLinks;
    }
}

