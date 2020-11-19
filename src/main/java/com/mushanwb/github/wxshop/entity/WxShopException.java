package com.mushanwb.github.wxshop.entity;

import org.springframework.http.HttpStatus;

public class WxShopException extends RuntimeException {

    private int statusCode;
    private String message;

    public static WxShopException forbidden(String message) {
        return new WxShopException(HttpStatus.FORBIDDEN.value(), message);
    }

    public static WxShopException notFound(String message) {
        return new WxShopException(HttpStatus.NOT_FOUND.value(), message);
    }

    public WxShopException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
