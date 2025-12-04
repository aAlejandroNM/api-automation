package com.solvd.automation.tests.restassured;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredDeleteUserTest implements IAbstractTest {

    private String baseUrl;

    @BeforeClass
    public void setup() {
        baseUrl = Configuration.getRequired("api_url");
    }

    @Test
    @MethodOwner(owner = "api-automation")
    public void testDeleteUserRestAssured() {
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .when()
                .delete("/users/1")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
    }
}

