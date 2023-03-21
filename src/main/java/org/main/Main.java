package org.main;

import org.google.drive.GetContentList;
import org.google.drive.Login;

public class Main {
    public static void main(String[] args) {
        GetContentList.getContentList(Login.getAccessToken());
    }
}