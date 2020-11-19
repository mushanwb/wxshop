package com.mushanwb.github.wxshop.entity;

public class WxShopException extends RuntimeException {

    public static class NotAuthorizedForShopException extends RuntimeException {
        public NotAuthorizedForShopException(String message) {
            super(message);
        }
    }

    public static class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
