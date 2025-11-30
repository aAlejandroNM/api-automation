package com.solvd.ApiAutomation.tests.restassured;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredGetUsersTest implements IAbstractTest {

    private String baseUrl;

    @BeforeClass
    public void setup() {
        baseUrl = Configuration.getRequired("api_url");
    }

    @Test
    @MethodOwner(owner = "api-automation")
    public void testGetAllUsersRestAssured() {
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .when()
                .get("/users")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertNotNull(response.getBody(), "Response body should not be null");
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0, "Should return at least one user");
    }
}

