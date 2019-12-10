package com.proxyip.fronted.interceptor;

import com.proxyip.fronted.model.custom.Token;
import com.proxyip.fronted.utils.Utils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(!Token.isValid(request.getParameter("token"))) {
            try {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.addObject("token", Token.toToken(request.getRemoteAddr()));
        }
    }




}
