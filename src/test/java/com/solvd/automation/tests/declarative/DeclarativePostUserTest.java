package com.solvd.automation.tests.declarative;

import com.solvd.automation.api.declarative.IUserApi;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.Test;

public class DeclarativePostUserTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "api-automation")
    public void testCreateUserDeclarative() {
        IUserApi userTemplate = TemplateFactory.prepareTemplate(IUserApi.class);
        var apiMethod = userTemplate.createUser();
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.setProperties("api/users/user.properties");
        apiMethod.callAPIExpectSuccess();
        apiMethod.validateResponse();
    }
}

