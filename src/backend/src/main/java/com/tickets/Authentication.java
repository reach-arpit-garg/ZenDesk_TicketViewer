package com.tickets;

class Authentication {
    String userId = "<User email address>";
    String password = "<User password>";
    String authStr;

    Authentication(){
        authStr = userId+":"+password;
    }
}
