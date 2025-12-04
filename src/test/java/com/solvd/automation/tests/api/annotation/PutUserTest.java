package com.solvd.automation.tests.api.annotation;

import com.solvd.automation.api.PutUserMethod;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class PutUserTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "api-automation")
    public void testUpdateUser() {
        PutUserMethod api = new PutUserMethod("1");
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}

