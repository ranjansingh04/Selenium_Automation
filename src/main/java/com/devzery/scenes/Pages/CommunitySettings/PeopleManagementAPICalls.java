package com.devzery.scenes.Pages.CommunitySettings;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PeopleManagementAPICalls {
    public static String jwtToken;

    static String loginBody = """
            {"user": {
                    "email": "mt9209@avalonmeta.com",
                    "password": "pass1234"
                }}""";

    public static void APIAuthentication() {
        Response responseLogin = given()
                .header("Content-type", "application/json")
                .queryParam("community_id", 287)
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

    public static String getUserIDFromUsername(String userName) {
        APIAuthentication();
        Response response =
                given()
                        .headers(
                                "Authorization", "Bearer " + jwtToken,
                                "Content-Type", ContentType.JSON,
                                "Accept", ContentType.JSON)
                        .queryParam("community_id", 287)
                        .queryParam("next_page_id", "")
                        .when()
                        .get("https://scenes-channels-staging.avalonmeta.com/api/v4/user_community_roles/people_list")
                        .then()
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();
        String responseMsg = response.asString();
        JsonPath jsonPath = new JsonPath(responseMsg);
        System.out.println(responseMsg);
        int communityUsersArraySize = jsonPath.getInt("data.community_users.data.size()");
        System.out.println(jsonPath.getString("data.community_users.data"));
        String userId = null;
        for (int i = 0; i < communityUsersArraySize; i++) {
            String tempUserName = jsonPath.getString("data.community_users.data[" + i + "].user.username");
            System.out.println(tempUserName);
            if (tempUserName.equals(userName)) {
                userId = jsonPath.getString("data.community_users.data[" + i + "].user_id");
                break;
            }
        }
        return userId;
    }

    public static void removeRoleFromUserUsingUserID(String userName) {
        APIAuthentication();
        String userID = getUserIDFromUsername(userName);
        System.out.println(userID);
        if(userID != null) {
            given()
                    .headers(
                            "Authorization", "Bearer " + jwtToken,
                            "Content-Type", ContentType.JSON,
                            "Accept", ContentType.JSON)
                    .queryParam("community_id", 287)
                    .queryParam("user_id", userID)
                    .when()
                    .delete("https://scenes-channels-staging.avalonmeta.com/api/v4/community_roles/1989/user_community_roles/remove")
                    .then()
                    .assertThat()
                    .statusCode(204);
        }
    }
}
