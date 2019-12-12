package com.proxyip.fronted.model.custom;

import com.google.gson.Gson;
import com.proxyip.fronted.utils.Utils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ApiResponse {

    public static String success(Object data, String message, int count) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Gson gson = Utils.getGson();
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("token", Token.toToken(Utils.getIp(request), request.getParameter("token")));
        returnMap.put("code", 0);
        returnMap.put("data", data);
        returnMap.put("count", count);
        returnMap.put("msg", message);
        return gson.toJson(returnMap);
    }

    public static String success(Object data, int count) {
        return success(data, "", count);
    }

    public static String success(Object data) {
        return success(data, "", 0);
    }

    public static String success() {
        return success(null, "", 0);
    }

    public static String error(Object data, String message) {
        Gson gson = Utils.getGson();
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("data", data);
        returnMap.put("code", 1);
        returnMap.put("msg", message);
        return gson.toJson(returnMap);
    }

    public static String error(String message) {
        return error(null, message);
    }
}
