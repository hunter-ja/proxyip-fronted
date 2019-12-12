package com.proxyip.fronted.interceptor;

import com.proxyip.fronted.model.custom.Token;
import com.proxyip.fronted.utils.Utils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.addObject("token",
                    Token.toToken(Utils.getIp(request), request.getParameter("token")));
        }
    }




}
