package com.devzery.scenes.Pages.CommunitySettings;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OnboardingAPICalls {
        public static String jwtToken;

        static String loginBody = """
                {"user": {
                        "email": "mt9209@avalonmeta.com",
                        "password": "pass1234"
                    }}""";

        public static void APIAuthentication() {
            Response responseLogin = given()
                    .header("Content-type", "application/json")
                    .queryParam("community_id",287)
                    .and()
                    .body(loginBody)
                    .when()
                    .post("https://scenes-ruby-staging.avalonmeta.com/api/v4/login")
                    .then()
                    .extract().response();
            String LoginresponseMsg = responseLogin.asString();
            JsonPath LoginjsonPath = new JsonPath(LoginresponseMsg);
            jwtToken = LoginjsonPath.getString("token");
            System.out.println(jwtToken);
        }

        public static List<Object> getApplicationFormQuestionsResponse() {
            APIAuthentication();
            Response response =
                    given()
                            .headers(
                                    "Authorization", "Bearer "+jwtToken,
                                    "Content-Type", ContentType.JSON,
                                    "Accept", ContentType.JSON)
                            .queryParam("community_id",287)
                            .when()
                            .get("https://scenes-ruby-staging.avalonmeta.com/api/v4/onboarding_steps")
                            .then()
                            .contentType(ContentType.JSON)
                            .extract()
                            .response();
            String responseMsg = response.asString();
            JsonPath jsonPath = new JsonPath(responseMsg);
            List<Object> applicationFormQuestionList = jsonPath.getList("data");
            System.out.println(applicationFormQuestionList);
            return applicationFormQuestionList;
        }
    }
