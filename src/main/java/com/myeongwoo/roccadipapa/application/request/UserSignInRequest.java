package com.myeongwoo.roccadipapa.application.request;

import lombok.Data;

@Data
public class UserSignInRequest {
    private String username;
    private String password;
}
