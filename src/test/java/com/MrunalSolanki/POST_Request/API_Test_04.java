package com.MrunalSolanki.POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Test_04 {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify Positive POST Request")
    @Test
    public void test_Positive_POST_TC1() {
        // URL, Method, Payload/ body / headers
        // Auth?

        String payload =  "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println(" ----    Part 1 ---- ");
        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");

        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        System.out.println(" ----    Part 2 ---- ");
        // Making HTTP Request -> Part 2
        response = r.when().log().all().post();


        System.out.println(" ----    Part 3 ---- ");
        // Verification Part -> Part 3
        vr = response.then().log().all();
        vr.statusCode(200);

    }

}
