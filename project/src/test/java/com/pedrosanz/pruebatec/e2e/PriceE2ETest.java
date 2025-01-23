package com.pedrosanz.pruebatec.e2e;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PriceE2ETest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void testGetPriceAt10AMOn14thJune() {
        String jsonBody = """
        {
            "applicationDate": "2020-06-14T10:00:00",
            "productId": 35455,
            "brandId": 1
        }
        """;

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .get("/api/v1/prices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", equalTo(1))
                .body("price", equalTo(35.50f))
                .body("startDate", equalTo("2020-06-14T00:00:00"))
                .body("endDate", equalTo("2020-12-31T23:59:59"))
                .body("currency", equalTo("EUR"));
    }

    @Test
    void testGetPriceAt4PMOn14thJune() {
        String jsonBody = """
        {
            "applicationDate": "2020-06-14T16:00:00",
            "productId": 35455,
            "brandId": 1
        }
        """;

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .get("/api/v1/prices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", equalTo(2))
                .body("price", equalTo(25.45f))
                .body("startDate", equalTo("2020-06-14T15:00:00"))
                .body("endDate", equalTo("2020-06-14T18:30:00"))
                .body("currency", equalTo("EUR"));
    }

    @Test
    void testGetPriceAt9PMOn14thJune() {
        String jsonBody = """
        {
            "applicationDate": "2020-06-14T21:00:00",
            "productId": 35455,
            "brandId": 1
        }
        """;

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .get("/api/v1/prices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", equalTo(1))
                .body("price", equalTo(35.50f))
                .body("startDate", equalTo("2020-06-14T00:00:00"))
                .body("endDate", equalTo("2020-12-31T23:59:59"))
                .body("currency", equalTo("EUR"));
    }

    @Test
    void testGetPriceAt10AMOn15thJune() {
        String jsonBody = """
        {
            "applicationDate": "2020-06-15T10:00:00",
            "productId": 35455,
            "brandId": 1
        }
        """;

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .get("/api/v1/prices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", equalTo(3))
                .body("price", equalTo(30.50f))
                .body("startDate", equalTo("2020-06-15T00:00:00"))
                .body("endDate", equalTo("2020-06-15T11:00:00"))
                .body("currency", equalTo("EUR"));
    }

    @Test
    void testGetPriceAt9PMOn16thJune() {
        String jsonBody = """
        {
            "applicationDate": "2020-06-16T21:00:00",
            "productId": 35455,
            "brandId": 1
        }
        """;

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .get("/api/v1/prices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", equalTo(4))
                .body("price", equalTo(38.95f))
                .body("startDate", equalTo("2020-06-15T16:00:00"))
                .body("endDate", equalTo("2020-12-31T23:59:59"))
                .body("currency", equalTo("EUR"));
    }
}
