package com.solvd.automation.tests.mobile;

import com.solvd.automation.mobile.common.AccountPageBase;
import com.solvd.automation.mobile.common.HomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YouTubeTests implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LogManager.getLogger(YouTubeTests.class);

    @Test(priority = 1)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "videos-load-homepage", value = {"mobile", "youtube", "homepage"})
    public void testVideosLoadOnHomePage() {
        LOGGER.info("=== Test 1: Verify videos load on home page ===");
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        
        Assert.assertTrue(homePage.isPageOpened(), "YouTube application did not load correctly");
        
        LOGGER.info("Scrolling down to find videos");
        swipeUp(20000);
        
        long videoCount = homePage.getVideoList().stream()
            .filter(video -> video.isElementPresent())
            .count();
        
        LOGGER.info("Videos found: {}", videoCount);
        Assert.assertTrue(videoCount > 2, 
            String.format("Failed to find more than 2 videos. Found: %d", videoCount));
        
        boolean videoListPresent = homePage.isVideoListDisplayed();
        LOGGER.info("Video list present: {}", videoListPresent);
        Assert.assertTrue(videoListPresent, "Video list is not present on home page");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "subscribe-to-channel", value = {"mobile", "youtube", "subscription"})
    public void testSubscribeToChannel() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        
        Assert.assertTrue(homePage.isPageOpened(), "The YouTube app did not load correctly.");
        
        boolean videoFound = homePage.getVideoList().stream()
            .filter(video -> video.isElementPresent())
            .findFirst()
            .map(video -> {
                swipeUp(10000);
                video.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return homePage.getSubscribeButton().isElementPresent();
            })
            .orElse(false);
        
        Assert.assertTrue(videoFound, "The subscribe button was not found after clicking on a video.");
    }

    @Test(priority = 3)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "shorts-section-exists", value = {"mobile", "youtube", "shorts"})
    public void testShortsSectionExists() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        
        Assert.assertTrue(homePage.isPageOpened(), "The YouTube app did not load correctly.");
        Assert.assertTrue(homePage.getShortsButton().isElementPresent(), "The Shorts button is not present.");
        
        homePage.clickShortsButton();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Assert.assertTrue(homePage.getShortsVideo().isElementPresent(), 
            "No Shorts video was found after clicking the button.");
    }

    @Test(priority = 4)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "navigation-bar", value = {"mobile", "youtube", "navigation"})
    public void testNavigationBar() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        Assert.assertTrue(homePage.isPageOpened(), "La aplicación de YouTube no se cargó correctamente");

        Assert.assertTrue(homePage.getHomeButton().isElementPresent(), "El botón Home no está presente");
        Assert.assertTrue(homePage.getHomeButton().isClickable(), "El botón Home no es clickeable");

        Assert.assertTrue(homePage.getShortsButton().isElementPresent(), "El botón Shorts no está presente");
        Assert.assertTrue(homePage.getShortsButton().isClickable(), "El botón Shorts no es clickeable");

        Assert.assertTrue(homePage.getSubscriptionsButton().isElementPresent(), "El botón Subscriptions no está presente");
        Assert.assertTrue(homePage.getSubscriptionsButton().isClickable(), "El botón Subscriptions no es clickeable");

        Assert.assertTrue(homePage.getAccountButton().isElementPresent(), "El botón Account no está presente");
        Assert.assertTrue(homePage.getAccountButton().isClickable(), "El botón Account no es clickeable");
        
        LOGGER.info("Test 4 completado: Todos los elementos de la barra de navegación verificados correctamente");
    }

    @Test(priority = 5)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "category-buttons-home", value = {"mobile", "youtube", "categories"})
    public void testCategoryButtonsOnHome() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "YouTube application did not load correctly");

        homePage.clickHomeButton();
        Assert.assertTrue( homePage.getYoutubeHomeLogo().isElementPresent(), "The YouTube logo is not present on the Home page.");
        
        int validButtonsCount = 0;

        if (homePage.getAllButton().isElementPresent()) {
            validButtonsCount++;
            LOGGER.info("All button is present and clickable");
        } else {
            LOGGER.warn("All button is not present or not clickable");
        }

        swipe(homePage.getMusicButton(), homePage.getFilterContainer(), Direction.LEFT, 1, 1000);
        if (homePage.getMusicButton().isElementPresent() && homePage.getMusicButton().isClickable()) {
            validButtonsCount++;
            LOGGER.info("Music button is present and clickable");
        } else {
            LOGGER.warn("Music button is not present or not clickable");
        }

        swipe(homePage.getPlaylistsButton(), homePage.getFilterContainer(), Direction.LEFT, 1, 1000);
        if (homePage.getPlaylistsButton().isElementPresent() && homePage.getPlaylistsButton().isClickable()) {
            validButtonsCount++;
            LOGGER.info("Playlists button is present and clickable");
        } else {
            LOGGER.warn("Playlists button is not present or not clickable");
        }

        swipe(homePage.getLiveButton(), homePage.getFilterContainer(), Direction.LEFT, 1, 1000);
        if (homePage.getLiveButton().isElementPresent() && homePage.getLiveButton().isClickable()) {
            validButtonsCount++;
            LOGGER.info("Live button is present and clickable");
        } else {
            LOGGER.warn("Live button is not present or not clickable");
        }

        swipe(homePage.getPodcastButton(), homePage.getFilterContainer(), Direction.LEFT, 1, 1000);
        if (homePage.getPodcastButton().isElementPresent() && homePage.getPodcastButton().isClickable()) {
            validButtonsCount++;
            LOGGER.info("Podcast button is present and clickable");
        } else {
            LOGGER.warn("Podcast button is not present or not clickable");
        }
        
        LOGGER.info("Total valid category buttons found: {}", validButtonsCount);
        Assert.assertTrue(validButtonsCount >= 2, 
            String.format("Less than 2 valid category buttons were found. Found: %d", validButtonsCount));
    }

    @Test(priority = 6)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "search-functionality", value = {"mobile", "youtube", "search"})
    public void testSearchFunctionality() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "The YouTube app did not load correctly.");

        Assert.assertTrue(homePage.getSearchButton().isElementPresent(), "The search button is not present.");
        Assert.assertTrue(homePage.getSearchButton().isClickable(), "The search button is not clickable.");
        homePage.clickSearchButton();
        Assert.assertTrue(homePage.getSearchBar().isElementPresent(), "The search bar is not present after clicking.");
        String searchText = "test automation";
        homePage.getSearchBar().type(searchText);
        homePage.getSearchOption().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.warn("Interruption during waiting: {}", e.getMessage());
        }
        

        String searchBarText = homePage.getSearchBar().getText();
        LOGGER.info("Text found in the search bar: {}", searchBarText);
        

        boolean textMatches = searchBarText != null && 
            (searchBarText.contains(searchText));
        Assert.assertTrue(textMatches, 
            String.format("The text in the search bar does not match. Expected: '%s', Found: '%s'",
                searchText, searchBarText));
    }

    @Test(priority = 7)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "video-playback", value = {"mobile", "youtube", "playback"})
    public void testVideoPlayback() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        Assert.assertTrue(homePage.isPageOpened(), "The YouTube app did not load correctly.");
        homePage.clickHomeButton();
        Assert.assertTrue( homePage.getYoutubeHomeLogo().isElementPresent(), "The YouTube logo is not present on the Home page.");
        Assert.assertTrue(homePage.isVideoListDisplayed(), "There are no videos available on the home page.");
        swipeUp(6000);
        homePage.getVideoList().get(2).click(2000);
        Assert.assertTrue( homePage.getVideoPlayer().isElementPresent(), "The video player is not present after clicking");
    }

    @Test(priority = 8)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "connect-to-tv", value = {"mobile", "youtube", "connect"})
    public void testConnectToTV() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        
        Assert.assertTrue(homePage.isPageOpened(), "YouTube application did not load correctly");
        Assert.assertTrue(homePage.getSelectDeviceButton().isElementPresent(), "Select device button is not present");
        
        homePage.getSelectDeviceButton().click();
        
        Assert.assertTrue(homePage.getSelectDeviceText().isElementPresent(), "Select device text is not displayed after clicking the button");
        Assert.assertTrue(homePage.getSelectDeviceText().getText().contains("Select a device"), "Select device text does not contain 'Select device'");

    }

    @Test(priority = 9)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "user-not-logged", value = {"mobile", "youtube", "authentication"})
    public void testUserIsNotLogged() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "YouTube application did not load correctly");
        
        homePage.navigateToAccount();
        
        AccountPageBase accountPage = initPage(getDriver(), AccountPageBase.class);
        Assert.assertTrue(accountPage.getSignInButton().isElementPresent(), "Sign in button is not present");
        Assert.assertTrue(accountPage.getSignInButton().getText().contains("Sign in"), "Sign in button text does not contain 'Sign in'");
    }

    @Test(priority = 10)
    @MethodOwner(owner = "mobile-automation")
    @TestLabel(name = "navigation-between-sections", value = {"mobile", "youtube", "navigation"})
    public void testNavigationBetweenSections() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "The YouTube app did not load correctly.");

        homePage.clickHomeButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "The Home page did not display correctly.");

        homePage.navigateToShorts();
        Assert.assertTrue(homePage.isShortsSectionDisplayed(), "The Shorts section did not display correctly.");

        homePage.navigateToSubscriptions();
        Assert.assertTrue(homePage.getSubscriptionsButton().isElementPresent(), "Could not navigate to Subscriptions");

        Assert.assertTrue(homePage.getAccountButton().isElementPresent(), "Unable to navigate to the account");

        homePage.clickHomeButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Unable to return to the Home page");
        Assert.assertTrue( homePage.getYoutubeHomeLogo().isElementPresent(), "The YouTube logo is not present on the Home page.");

    }
}

