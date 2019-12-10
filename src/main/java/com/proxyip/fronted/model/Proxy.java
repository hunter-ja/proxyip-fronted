package com.proxyip.fronted.model;

import java.util.Date;

public class Proxy {
    private Integer id;

    private String ip;

    private Integer port;

    private String scheme;

    private String source;

    private String area;

    private Date lastCheckTime;

    private Integer disconnetTimes;

    private Integer connectTimes;

    private Date createdAt;

    private String isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme == null ? null : scheme.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Date getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(Date lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    public Integer getDisconnetTimes() {
        return disconnetTimes;
    }

    public void setDisconnetTimes(Integer disconnetTimes) {
        this.disconnetTimes = disconnetTimes;
    }

    public Integer getConnectTimes() {
        return connectTimes;
    }

    public void setConnectTimes(Integer connectTimes) {
        this.connectTimes = connectTimes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }
}