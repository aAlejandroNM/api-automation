package com.solvd.automation.mobile.android;

import com.solvd.automation.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'play video')]")
    private List<ExtendedWebElement> videoList;

    @FindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Home')]")
    private ExtendedWebElement homeButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Shorts']")
    private ExtendedWebElement shortsButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Subscriptions']")
    private ExtendedWebElement subscriptionsButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='You']")
    private ExtendedWebElement accountButtoon;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.google.android.youtube:id/search_edit_text'] | //android.widget.TextView[@resource-id='com.google.android.youtube:id/search_query']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.google.android.youtube:id/linearLayout'])[1]")
    private ExtendedWebElement searchOption;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'Subscribe')]/android.view.ViewGroup")
    private ExtendedWebElement subscribeButton;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc='filters']")
    private ExtendedWebElement filterContainer;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.youtube:id/chip_cloud_chip_modern_text' and @text='All']")
    private ExtendedWebElement allButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.youtube:id/chip_cloud_chip_modern_text' and @text='Music']")
    private ExtendedWebElement musicButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.youtube:id/chip_cloud_chip_modern_text' and @text='Live']")
    private ExtendedWebElement liveButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.youtube:id/chip_cloud_chip_modern_text' and @text='Playlists']")
    private ExtendedWebElement playlistsButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.youtube:id/chip_cloud_chip_modern_text' and @text='Podcasts']")
    private ExtendedWebElement podcastButton;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'Shorts')]")
    private ExtendedWebElement shortsSection;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.google.android.youtube:id/reel_watch_player']/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
    private ExtendedWebElement shortsVideo;

    @FindBy(id = "com.google.android.youtube:id/watch_while_time_bar_view")
    private ExtendedWebElement videoPlayer;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.google.android.youtube:id/mdx_entry_point_button']")
    private ExtendedWebElement selectDeviceButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.youtube:id/device_picker_section_header_title']")
    private ExtendedWebElement selectDeviceText;

    @FindBy(id = "com.google.android.youtube:id/youtube_logo")
    private ExtendedWebElement youtubeHomeLogo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<ExtendedWebElement> getVideoList() {
        return videoList;
    }
    
    @Override
    public ExtendedWebElement getHomeButton() {
        return homeButton;
    }
    
    @Override
    public ExtendedWebElement getShortsButton() {
        return shortsButton;
    }
    
    @Override
    public ExtendedWebElement getSubscriptionsButton() {
        return subscriptionsButton;
    }
    
    @Override
    public ExtendedWebElement getAccountButton() {
        return accountButtoon;
    }

    @Override
    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }
    
    @Override
    public ExtendedWebElement getSearchBar() {
        return searchBar;
    }

    @Override
    public ExtendedWebElement getSearchOption(){
        return searchOption;
    }
    @Override
    public ExtendedWebElement getSubscribeButton() {
        return subscribeButton;
    }

    @Override
    public ExtendedWebElement getFilterContainer() {
        return filterContainer;
    }

    @Override
    public ExtendedWebElement getAllButton() {
        return allButton;
    }

    @Override
    public ExtendedWebElement getMusicButton() {
        return musicButton;
    }
    
    @Override
    public ExtendedWebElement getLiveButton() {
        return liveButton;
    }
    
    @Override
    public ExtendedWebElement getPlaylistsButton() {
        return playlistsButton;
    }
    
    @Override
    public ExtendedWebElement getPodcastButton() {
        return podcastButton;
    }
    
    @Override
    public ExtendedWebElement getShortsVideo() {
        return shortsVideo;
    }
    
    @Override
    public ExtendedWebElement getVideoPlayer() {
        return videoPlayer;
    }

    @Override
    public ExtendedWebElement getSelectDeviceButton() {
        return selectDeviceButton;
    }

    @Override
    public ExtendedWebElement getSelectDeviceText() {
        return selectDeviceText;
    }

    @Override
    public ExtendedWebElement getYoutubeHomeLogo() {
        return youtubeHomeLogo;
    }

    @Override
    public boolean isHomePageDisplayed() {
        return homeButton.isElementPresent() && !videoList.isEmpty();
    }
    
    @Override
    public boolean isShortsSectionDisplayed() {
        return shortsVideo.isElementPresent();
    }
    
    @Override
    public boolean isVideoListDisplayed() {
        return !videoList.isEmpty() && videoList.get(0).isElementPresent();
    }
}
