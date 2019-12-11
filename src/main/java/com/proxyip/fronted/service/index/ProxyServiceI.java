package com.proxyip.fronted.service.index;

import com.proxyip.fronted.model.ProxyExtends;
import com.proxyip.fronted.service.model.ServiceModel;

import java.util.List;

public interface ProxyServiceI {

    ServiceModel<List<ProxyExtends>> getList(String page, String limit);

    int count();

}
