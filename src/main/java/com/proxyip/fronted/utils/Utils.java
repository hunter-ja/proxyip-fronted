package com.proxyip.fronted.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static boolean isAjax(HttpServletRequest request){
        return  (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x - forwarded - for");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy - Client - IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL - Proxy - Client - IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
