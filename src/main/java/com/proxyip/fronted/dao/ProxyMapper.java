package com.proxyip.fronted.dao;

import com.proxyip.fronted.model.Proxy;

public interface ProxyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Proxy record);

    int insertSelective(Proxy record);

    Proxy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Proxy record);

    int updateByPrimaryKey(Proxy record);
}