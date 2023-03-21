package org.google.drive;

import io.restassured.path.json.JsonPath;
import org.tools.Methods;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Login {   //Sigleton?
    public static String getLoginResponse(){
        String clientID = "??????????????";
        String clientSecret = "??????????????";
        ArrayList<String> scope = new ArrayList<String>();
        scope.add("https://www.googleapis.com/auth/drive");
        scope.add("https://www.googleapis.com/auth/drive.file");


        String loginResponse = given().urlEncodingEnabled(false)
                .queryParams("client_id", clientID)
                .queryParams("cliente_secret", clientSecret)
                .queryParams("redirect_uri", "https://accounts.google.com/o/oauth2/auth")
                .queryParams("grant_type", "authorization_code")
                .when()
                .post("https://oauth2.googleapis.com/token")
                .asPrettyString()
                ;

        return loginResponse;
    }

    public static String getAccessToken(){
        String loginResponse = getLoginResponse();
        JsonPath loginResponseJson = Methods.convertToJson(loginResponse);
        String accessToken = Methods.getParameter(loginResponseJson, "access_token");
        return accessToken;
    }
}
