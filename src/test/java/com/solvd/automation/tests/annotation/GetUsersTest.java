package com.solvd.automation.tests.annotation;

import com.solvd.automation.api.GetUserMethods;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class GetUsersTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "api-automation")
    public void testGetAllUsers() {
        GetUserMethods api = new GetUserMethods();
        api.callAPIExpectSuccess();
        api.validateResponse();
        // api.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }
}

