package com.proxyip.fronted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView test(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.setViewName("index/index");
        return modelAndView;
    }

}
