package org.google.drive;

import static io.restassured.RestAssured.given;

public class GetContentList {
    public static String getContentList(String accessToken){
        String contentList = given()
                .queryParam("access_token", accessToken)
                .when()
                .get("https://www.googleapis.com/drive/v3/files")
                .asPrettyString()
                ;
        return contentList;
    }


}
