package org.google.drive;

import static io.restassured.RestAssured.given;

public class Delete {
    public static void deleteFileByID(String accessToken, String fileId) {
        given()
                .queryParam("access_token", accessToken)
                .when()
                .delete("https://www.googleapis.com/drive/v3/files/" + fileId)
        ;
    }
}
