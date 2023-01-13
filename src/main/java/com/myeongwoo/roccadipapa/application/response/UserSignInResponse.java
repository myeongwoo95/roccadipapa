package com.myeongwoo.roccadipapa.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignInResponse {
    private String accessToken;
}
