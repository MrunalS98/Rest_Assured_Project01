package com.MrunalSolanki.GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Test_03 {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    @Description("Verify Positive GET Request")
    public void test_Positive_GET_TC1(){
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/4");

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }

    @Test
    @Description("Verify Positive GET Request")
    public void test_Negative_GET_TC2(){
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-4");

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }

    @Test
    @Description("Verify Positive GET Request")
    public void test_Negative_GET_TC3(){
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/$");

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }
}
