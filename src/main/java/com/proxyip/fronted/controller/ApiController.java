package com.proxyip.fronted.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        return "aaaaaaa";
    }



}
