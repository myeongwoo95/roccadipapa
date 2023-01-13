package com.myeongwoo.roccadipapa.domain.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("해당 사용자가 존재하지 않습니다");
    }
}
