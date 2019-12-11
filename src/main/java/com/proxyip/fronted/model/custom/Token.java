package com.proxyip.fronted.model.custom;

import com.google.gson.Gson;
import com.proxyip.fronted.utils.AES;
import com.proxyip.fronted.utils.Utils;
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

    private String preToken;

    private boolean isFirst;

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

    public String getPreToken() {
        return preToken;
    }

    public void setPreToken(String preToken) {
        this.preToken = preToken;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    /**
     * 生成请求token
     * @param ip
     * @return
     */
    public static String toToken(String ip, String tokenStr) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 3);
        Token token = new Token();
        token.setIp(ip);
        token.setExpireDate(nowTime.getTime());
        if(StringUtils.isEmpty(tokenStr)) {
            token.setFirst(true);
        }else{
            token.setPreToken(tokenStr);
            token.setFirst(false);
        }
        Gson gson = Utils.getGson();
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
    public static boolean isValid(String token, String ip, String preToken) {
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
            if(tokenModel.isFirst) {
                return tokenModel.getExpireDate().after(new Date())
                        && ip.equals(tokenModel.getIp());
            }else{
                return tokenModel.getExpireDate().after(new Date())
                        && ip.equals(tokenModel.getIp())
                        && preToken.equals(tokenModel.getPreToken());
            }

        }catch (Exception e) {
            return false;
        }
    }

}
