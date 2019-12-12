package com.proxyip.fronted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
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

    @RequestMapping("/new")
    public ModelAndView newList(ModelAndView modelAndView) {
        modelAndView.addObject("nav", "new");
        modelAndView.setViewName("index/new");
        return modelAndView;
    }

    @RequestMapping("/available")
    public ModelAndView available(ModelAndView modelAndView) {
        modelAndView.addObject("nav", "available");
        modelAndView.setViewName("index/available");
        return modelAndView;
    }

}
