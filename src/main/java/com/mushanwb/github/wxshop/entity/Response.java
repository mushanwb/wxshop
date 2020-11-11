package com.mushanwb.github.wxshop.entity;

public class Response<T> {
    private String message;
    private T data;

    public static <T> Response<T> of(T data) {
        return new Response<T>(data, null);
    }

    public static <T> Response<T> of(T data, String message) {
        return new Response<T>(data, message);
    }

    private Response(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

}
