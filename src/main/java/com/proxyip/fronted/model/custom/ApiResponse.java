package com.proxyip.fronted.model.custom;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {

    public static String success(Object data, String message) {
        Gson gson = new Gson();
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", 0);
        returnMap.put("data", data);
        returnMap.put("msg", message);
        return gson.toJson(returnMap);
    }

    public static String success(Object data) {
        return success(data, "");
    }

    public static String success() {
        return success(null, "");
    }

    public static String error(Object data, String message) {
        Gson gson = new Gson();
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", 1);
        returnMap.put("data", data);
        returnMap.put("msg", message);
        return gson.toJson(returnMap);
    }

    public static String error(String message) {
        return error(null, message);
    }
}
