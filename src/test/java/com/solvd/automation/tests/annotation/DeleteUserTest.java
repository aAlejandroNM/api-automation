package com.solvd.automation.tests.annotation;

import com.solvd.automation.api.DeleteUserMethod;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class DeleteUserTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "api-automation")
    public void testDeleteUser() {
        DeleteUserMethod api = new DeleteUserMethod("1");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}

