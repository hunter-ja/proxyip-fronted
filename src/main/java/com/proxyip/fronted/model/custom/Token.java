package com.proxyip.fronted.model.custom;

import com.google.gson.Gson;
import com.proxyip.fronted.utils.AES;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Token {

    private String ip;

    private Date expireDate;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * 生成请求token
     * @param ip
     * @return
     */
    public static String toToken(String ip) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, 30);
        Token token = new Token();
        token.setIp(ip);
        token.setExpireDate(nowTime.getTime());
        Gson gson = new Gson();
        try {
            return URLEncoder.encode(Objects.requireNonNull(AES.encryptBase64(gson.toJson(token))), "utf8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * 判断token是否有效
     * @param token
     * @return
     */
    public static boolean isValid(String token, String ip) {
        try {
            if(StringUtils.isEmpty(token)) {
                return false;
            }
            token = URLDecoder.decode(token, "utf8");
            String json = AES.decryptBase64(token);
            if(StringUtils.isEmpty(json)) {
                return false;
            }
            Gson gson = new Gson();
            Token tokenModel = gson.fromJson(json, Token.class);
            if(tokenModel == null) {
                return false;
            }
            return tokenModel.getExpireDate().after(new Date()) && ip.equals(tokenModel.getIp());
        }catch (Exception e) {
            return false;
        }
    }

}
