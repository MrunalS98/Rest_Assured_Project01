package com.MrunalSolanki.PATCH_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Test_06 {
    //RequestSpecification r;
    //Response response;
    //ValidatableResponse vr;

    @Description("Verify Positive PATCH Request")
    @Test
    public void test_PATCH(){

        String token = "e71ab6282df6e77";
        String bookingid = "1491";

        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Mrunal\",\n" +
                "    \"lastname\" : \"Hello\"\n" +
                "}";

        System.out.println(" ----    Part 1 ---- ");
        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payloadPatch).log().all();

        Response response = requestSpecification.when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

    }
}
