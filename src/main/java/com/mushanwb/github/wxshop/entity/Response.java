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

    public Response() {

    }

    private Response(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

}
