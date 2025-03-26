package com.MrunalSolanki.PUT_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class API_Test_05 {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify Positive PUT Request")
    @Test
    public void test_PUT(){

        String token = "cfa6e83afe29259";
        String bookingid = "936";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Mrunal\",\n" +
                "    \"lastname\" : \"Solanki\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        System.out.println(" ----    Part 1 ---- ");
        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.auth().basic("admin","password123");
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();


        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

}

