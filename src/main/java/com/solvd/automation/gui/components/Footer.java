package com.solvd.automation.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer extends AbstractUIObject {
    @FindBy(xpath = "//footer")
    private ExtendedWebElement footerContainer;

    @FindBy(xpath = "//a[contains(@class, 'ac-gf-footer-legal-link')]")
    private List<ExtendedWebElement> footerLinks;

    @FindBy(xpath = "//div[contains(@class, 'ac-gf-footer-legal-copyright')]")
    private ExtendedWebElement footerText;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isFooterDisplayed() {
        return footerContainer.isElementPresent();
    }

    public String getFooterText() {
        return footerText.getText();
    }

    public void scrollToFooter() {
        footerContainer.scrollTo();
    }

    public List<ExtendedWebElement> getFooterLinks() {
        return footerLinks;
    }
}

