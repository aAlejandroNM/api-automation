package com.solvd.automation.mobile.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AccountPageBase extends AbstractPage implements IMobileUtils {

    public AccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getSignInButton();
}
