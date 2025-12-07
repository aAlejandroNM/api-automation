package com.solvd.automation.mobile.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class HomePageBase extends AbstractPage implements IMobileUtils {
    
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<ExtendedWebElement> getVideoList();

    public abstract ExtendedWebElement getHomeButton();
    public abstract ExtendedWebElement getShortsButton();
    public abstract ExtendedWebElement getSubscriptionsButton();
    public abstract ExtendedWebElement getAccountButton();

    public abstract ExtendedWebElement getSearchButton();
    public abstract ExtendedWebElement getSearchBar();

    public abstract ExtendedWebElement getSearchOption();

    public abstract ExtendedWebElement getSubscribeButton();

    public abstract ExtendedWebElement getFilterContainer();

    public abstract ExtendedWebElement getAllButton();

    public abstract ExtendedWebElement getMusicButton();
    
    public abstract ExtendedWebElement getLiveButton();
    
    public abstract ExtendedWebElement getPlaylistsButton();
    
    public abstract ExtendedWebElement getPodcastButton();

    public abstract ExtendedWebElement getShortsVideo();

    public abstract ExtendedWebElement getVideoPlayer();

    public abstract ExtendedWebElement getSelectDeviceButton();
    public abstract ExtendedWebElement getSelectDeviceText();
    public abstract ExtendedWebElement getYoutubeHomeLogo();

    public abstract boolean isHomePageDisplayed();
    public abstract boolean isShortsSectionDisplayed();
    public abstract boolean isVideoListDisplayed();

    public void clickHomeButton() {
        getHomeButton().click();
    }
    
    public void clickShortsButton() {
        getShortsButton().click();
    }
    
    public void clickSubscriptionsButton() {
        getSubscriptionsButton().click();
    }
    
    public void clickAccountButton() {
        getAccountButton().click();
    }
    
    public void clickSearchButton() {
        getSearchButton().click();
    }
    
    public void navigateToShorts() {
        clickShortsButton();
    }
    
    public void navigateToSubscriptions() {
        clickSubscriptionsButton();
    }
    
    public void navigateToAccount() {
        clickAccountButton();
    }

    @Override
    public boolean isPageOpened() {
        try {
            if (getYoutubeHomeLogo().isElementPresent()) {
                return true;
            }

            if (getHomeButton().isElementPresent()) {
                return true;
            }
            if (!getVideoList().isEmpty() && getVideoList().getFirst().isElementPresent()) {
                return true;
            }

            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
