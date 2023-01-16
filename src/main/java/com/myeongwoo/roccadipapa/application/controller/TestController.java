package com.myeongwoo.roccadipapa.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String Hello(){
        System.out.println("am i working?");
        return "hello world";
    }
}
