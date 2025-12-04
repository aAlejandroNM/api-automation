package com.solvd.automation.tests.api.restassured;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RestAssuredPatchUserTest implements IAbstractTest {

    private String baseUrl;

    @BeforeClass
    public void setup() {
        baseUrl = Configuration.getRequired("api_url");
    }

    @Test
    @MethodOwner(owner = "api-automation")
    public void testPatchUserRestAssured() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", "Updated Name");
        userData.put("email", "updated@example.com");

        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .patch("/users/1")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertNotNull(response.getBody(), "Response body should not be null");
        Assert.assertEquals(response.jsonPath().getString("name"), "Updated Name", "Name should be updated");
        Assert.assertEquals(response.jsonPath().getString("email"), "updated@example.com", "Email should be updated");
    }
}

