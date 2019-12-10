package com.proxyip.fronted.utils;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static boolean isAjax(HttpServletRequest request){
        return  (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }
}
