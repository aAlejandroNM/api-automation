package com.solvd.automation.mobile.android;

import com.solvd.automation.mobile.common.AccountPageBase;
import com.solvd.automation.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountPageBase.class)
public class AccountPage extends AccountPageBase {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.google.android.youtube:id/button']")
    private ExtendedWebElement signInButton;



    @Override
    public ExtendedWebElement getSignInButton() {
        return signInButton;
    }
}
