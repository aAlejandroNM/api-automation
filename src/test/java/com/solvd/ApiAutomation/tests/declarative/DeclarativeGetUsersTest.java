package com.solvd.ApiAutomation.tests.declarative;

import com.solvd.ApiAutomation.api.declarative.IUserApi;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class DeclarativeGetUsersTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "api-automation")
    public void testGetAllUsersDeclarative() {
        IUserApi userTemplate = TemplateFactory.prepareTemplate(IUserApi.class);
        var apiMethod = userTemplate.getUsers();
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.callAPIExpectSuccess();
        apiMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey() + "$");
    }
}

