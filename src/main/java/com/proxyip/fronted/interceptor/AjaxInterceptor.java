package com.proxyip.fronted.interceptor;

import com.proxyip.fronted.model.custom.ApiResponse;
import com.proxyip.fronted.model.custom.Token;
import com.proxyip.fronted.utils.Utils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class AjaxInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(!Token.isValid(request.getParameter("token"), Utils.getIp(request), request.getParameter("pre-token"))) {
            try {
                response.setHeader("Content-Type", "application/json;charset=UTF-8");
                response.getWriter().println(ApiResponse.error("Token 已失效请刷新页面"));
                response.flushBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
}
