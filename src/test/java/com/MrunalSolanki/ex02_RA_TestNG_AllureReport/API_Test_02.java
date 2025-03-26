package com.MrunalSolanki.ex02_RA_TestNG_AllureReport;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Test_02 {

    @Test
    @Description("TC1: Verify that valid bookingId gives 200 Ok")
    public void test_GET_Positive_TC1(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/4")

                .when()
                .get()

                .then()
                .log().all().statusCode(200);
    }

    @Test
    @Description("TC2: Verify that invalid bookingId gives error")
    public void test_GET_Negative_TC2(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/A")

                .when()
                .get()

                .then()
                .log().all().statusCode(200);
    }

    @Test
    @Description("TC3: Verify that invalid bookingId gives 200 Ok")
    public void test_GET_Negative_TC3(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/$")

                .when()
                .get()

                .then()
                .log().all().statusCode(200);
    }
}
