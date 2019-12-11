package com.proxyip.fronted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView test(ModelAndView modelAndView) {
        modelAndView.addObject("nav", "index");
        modelAndView.setViewName("index/index");
        return modelAndView;
    }

    @RequestMapping("/search")
    public ModelAndView search(ModelAndView modelAndView) {
        modelAndView.addObject("nav", "search");
        modelAndView.setViewName("index/search");
        return modelAndView;
    }

}
