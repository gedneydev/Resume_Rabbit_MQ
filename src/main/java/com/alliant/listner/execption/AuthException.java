package com.alliant.listner.execption;

public class AuthException extends RuntimeException {

    public AuthException(){
        super("Authentication Exception please try again");
    }
}
