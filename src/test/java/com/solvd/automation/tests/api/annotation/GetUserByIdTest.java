package com.solvd.automation.tests.api.annotation;

import com.solvd.automation.api.GetUserByIdMethod;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class GetUserByIdTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "api-automation")
    public void testGetUserById() {
        GetUserByIdMethod api = new GetUserByIdMethod("1");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}

