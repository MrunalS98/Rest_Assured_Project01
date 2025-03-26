package com.MrunalSolanki.ex01_RA_Basics;

import io.restassured.RestAssured;

public class API_Test_01 {
    public static void main(String[] args) {

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/4")

                .when()
                .get()

                .then()
                .log().all().statusCode(200);
    }
}
