package com.test.util;

/**
 * @author ：ls05
 * @date ：Created in 2021/1/16 21:27
 */
public class TodoException extends RuntimeException {

    public static final String LOGIN_NAME_ERROR = "Login name error!";
    public static final String LOGIN_PASSWORD_ERROR = "Login password error!";
    public TodoException(String errorMessage) {
        super(errorMessage);
        System.out.println(errorMessage);
    }
}
