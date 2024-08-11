package base;

import constants.ContentTypes;
import enums.StatusCode;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response postRequest(String uri, String path, HashMap<String, String> formParams, StatusCode statusCode) {
        return given()
                .baseUri(uri)
                .basePath(path)
                .formParams(formParams)
                .contentType(ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED + "; charset=UTF-8")
                .when().post()
                .then()
                .statusCode(statusCode.code)
                .extract().response();
    }

    public static Response postRawTextRequest(String uri, String path, String body, StatusCode statusCode) {
        return given()
                .baseUri(uri)
                .basePath(path)
                .body(body)
                .contentType(ContentTypes.TEXT_PLAIN + "; charset=UTF-8")
                .when().post()
                .then().statusCode(statusCode.code)
                .extract().response();
    }

    public static Response getRequest(String uri, String path, HashMap<String, String> params) {
        return given()
                .baseUri(uri)
                .basePath(path)
                .queryParams(params)
                .when().get()
                .then().extract().response();
    }

    public static Response putRequest(String uri, String path, HashMap<String, String> formParams, StatusCode statusCode) {
        return given()
                .baseUri(uri)
                .basePath(path)
                .formParams(formParams)
                .contentType(ContentTypes.TEXT_PLAIN)
                .when().put()
                .then()
                .statusCode(statusCode.code)
                .extract().response();
    }

    public static Response deleteRequest(String uri, String path, HashMap<String, String> params, StatusCode statusCode) {
        return given()
                .baseUri(uri)
                .basePath(path)
                .queryParams(params)
                .contentType(ContentTypes.APPLICATION_JSON)
                .when().delete()
                .then().statusCode(statusCode.code)
                .extract().response();
    }

    public static Response patchRequest(String uri, String path, HashMap<String, String> params, StatusCode statusCode) {
        return given()
                .baseUri(uri)
                .basePath(path)
                .queryParams(params)
                .contentType(ContentTypes.APPLICATION_JSON)
                .when().patch()
                .then().statusCode(statusCode.code)
                .extract().response();
    }
}