package com.proxyip.fronted.dao;

import com.proxyip.fronted.model.Proxy;
import com.proxyip.fronted.model.ProxyExtends;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProxyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Proxy record);

    int insertSelective(Proxy record);

    Proxy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Proxy record);

    int updateByPrimaryKey(Proxy record);

    List<ProxyExtends> getList(@Param("offset") int offset, @Param("limit") int limit);

    int count();
}