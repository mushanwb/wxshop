package com.mushanwb.github.wxshop.entity;

public class Response<T> {
    private T data;

    public static <T> Response<T> of(T data) {
        return new Response<T>(data);
    }

    private Response(T data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

}
