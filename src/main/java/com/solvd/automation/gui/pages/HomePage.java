package com.solvd.automation.gui.pages;

import com.solvd.automation.gui.components.Footer;
import com.solvd.automation.gui.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\'globalheader\']")
    private Header header;
    @FindBy(xpath = "//*[@id='ac-globalfooter']")
    private Footer footer;

    @FindBy(xpath = "/html/body/main/section[1]")
    private List<ExtendedWebElement> productCards;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("/");
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public int getProductCardsCount() {
        return productCards.size();
    }

    public void clickMacLink() {
        header.clickMacLink();
    }

    public void clickIpadLink() {
        header.clickIpadLink();
    }

    public void clickIphoneLink() {
        header.clickIphoneLink();
    }


    public boolean isLogoDisplayed() {
        return header.isLogoDisplayed();
    }

    public boolean isHeaderDisplayed() {
        return header.isHeaderDisplayed();
    }

    public boolean isFooterDisplayed() {
        return footer.isFooterDisplayed();
    }

    public void scrollToFooter() {
        footer.scrollToFooter();
    }

    public ExtendedWebElement getMacLink() {
        return header.getMacLink();
    }

    public ExtendedWebElement getIpadLink() {
        return header.getIpadLink();
    }

    public ExtendedWebElement getIphoneLink() {
        return header.getIphoneLink();
    }

    public ExtendedWebElement getWatchLink() {
        return header.getWatchLink();
    }

}
