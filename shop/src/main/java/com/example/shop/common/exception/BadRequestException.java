package com.example.shop.common.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);  // 부모 클래스 생성자 사용
    }
}
