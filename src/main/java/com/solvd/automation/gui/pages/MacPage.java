package com.solvd.automation.gui.pages;

import com.solvd.automation.gui.components.Footer;
import com.solvd.automation.gui.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MacPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\'globalheader\']")
    private Header header;
    @FindBy(xpath = "//*[@id='ac-globalfooter']")
    private Footer footer;

    @FindBy(xpath = "//h1[contains(@class, 'PageHeader_title')] | //h1[contains(., 'Mac')]")
    private ExtendedWebElement pageTitle;

    

    public MacPage(WebDriver driver) {
        super(driver);
        setPageURL("/mac/");
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
}

