package com.solvd.automation.gui.pages;

import com.solvd.automation.gui.components.Footer;
import com.solvd.automation.gui.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IPhonePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='globalheader']")
    private Header header;
    
    @FindBy(xpath = "//*[@id='ac-globalfooter']")
    private Footer footer;

    @FindBy(xpath = "//h1[contains(@class, 'PageHeader_title')] | //h1[contains(., 'iPhone')]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//li[contains(@class, 'chapternav-item-iphone-17-pro')]//a")
    private ExtendedWebElement iphone17ProLink;

    public IPhonePage(WebDriver driver) {
        super(driver);
        setPageURL("/iphone/");
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public ExtendedWebElement getIphone17ProLink() {
        return iphone17ProLink;
    }
}

