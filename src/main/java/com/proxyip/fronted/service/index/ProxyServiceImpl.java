package com.proxyip.fronted.service.index;

import com.proxyip.fronted.dao.ProxyMapper;
import com.proxyip.fronted.model.ProxyExtends;
import com.proxyip.fronted.service.model.ServiceModel;
import com.proxyip.fronted.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProxyServiceImpl implements ProxyServiceI {

    private final ProxyMapper proxyMapper;

    private final static int maxLimit = 15;

    @Autowired
    public ProxyServiceImpl(ProxyMapper proxyMapper) {
        this.proxyMapper = proxyMapper;
    }

    @Override
    public ServiceModel<List<ProxyExtends>> getList(String page, String limit) {
        ServiceModel<List<ProxyExtends>> serviceModel = new ServiceModel<>();
        int pageNum;
        int limitNum;
        try {
            pageNum = Integer.parseInt(page);
            limitNum = Integer.parseInt(limit);
        }catch (NumberFormatException e) {
            return serviceModel.error("页码错误");
        }
        if(limitNum > maxLimit) {
            return serviceModel.error("limit错误");
        }
        int offset = Utils.getOffset(pageNum, limitNum);
        List<ProxyExtends> list = proxyMapper.getList(offset, limitNum);
        return serviceModel.success(list);
    }

    @Override
    public int count() {
        return proxyMapper.count();
    }

    public ServiceModel<List<ProxyExtends>> search(String keyword, String page, String limit) {
        ServiceModel<List<ProxyExtends>> serviceModel = new ServiceModel<>();
        int pageNum;
        int limitNum;
        try {
            pageNum = Integer.parseInt(page);
            limitNum = Integer.parseInt(limit);
        }catch (NumberFormatException e) {
            return serviceModel.error("页码错误");
        }
        if(limitNum > maxLimit) {
            return serviceModel.error("limit错误");
        }
        if(StringUtils.isEmpty(keyword)) {
            keyword = "";
        }
        int offset = Utils.getOffset(pageNum, limitNum);
        List<ProxyExtends> list = proxyMapper.search(offset, limitNum, keyword);
        return serviceModel.success(list);
    }

    @Override
    public int countByKeyword() {
        return 0;
    }



}
