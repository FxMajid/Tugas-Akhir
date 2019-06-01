package com.example.tugasakhir.Model;

public class LoginRespons {
    private boolean success;
    private String message;

    public LoginRespons (boolean success, String message){
    this.success    = success ;
    this.message    = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
