package com.solvd.automation.tests.restassured;

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

public class RestAssuredPostUserTest implements IAbstractTest {

    private String baseUrl;

    @BeforeClass
    public void setup() {
        baseUrl = Configuration.getRequired("api_url");
    }

    @Test
    @MethodOwner(owner = "api-automation")
    public void testCreateUserRestAssured() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", "John Doe");
        userData.put("username", "johndoe");
        userData.put("email", "john.doe@example.com");

        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 201, "Status code should be 201");
        Assert.assertNotNull(response.getBody(), "Response body should not be null");
        Assert.assertEquals(response.jsonPath().getString("name"), "John Doe", "Name should match");
        Assert.assertEquals(response.jsonPath().getString("email"), "john.doe@example.com", "Email should match");
    }
}

