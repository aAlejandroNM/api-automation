package com.solvd.automation.tests.annotation;

import com.solvd.automation.api.PostUserMethod;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class PostUserTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "api-automation")
    public void testCreateUser() {
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}

