package com.proxyip.fronted.controller;

import com.proxyip.fronted.model.custom.ApiResponse;
import com.proxyip.fronted.service.index.ProxyServiceI;
import com.proxyip.fronted.service.model.ServiceModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ProxyServiceI proxyService;

    public ApiController(ProxyServiceI proxyService) {
        this.proxyService = proxyService;
    }

    @PostMapping("index")
    public String index(HttpServletRequest request) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        ServiceModel serviceModel = proxyService.getList(page, limit);
        if(serviceModel.isSuccess()) {
            return ApiResponse.success(serviceModel.getData(), proxyService.count());
        }else{
            return ApiResponse.error(serviceModel.getMessage());
        }
    }

    @PostMapping("search")
    public String search(HttpServletRequest request) {
        String page = request.getParameter("page");
        String keyword = request.getParameter("keyword");
        String limit = request.getParameter("limit");
        ServiceModel serviceModel = proxyService.search(keyword, page, limit);
        if(serviceModel.isSuccess()) {
            return ApiResponse.success(serviceModel.getData(), proxyService.countByKeyword(keyword));
        }else{
            return ApiResponse.error(serviceModel.getMessage());
        }
    }



}
