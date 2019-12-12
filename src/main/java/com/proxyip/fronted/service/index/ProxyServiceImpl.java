package com.proxyip.fronted.service.index;

import com.proxyip.fronted.dao.ProxyMapper;
import com.proxyip.fronted.model.ProxyExtends;
import com.proxyip.fronted.service.model.ServiceModel;
import com.proxyip.fronted.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProxyServiceImpl implements ProxyServiceI {

    private final ProxyMapper proxyMapper;

    private final static int maxLimit = 15;

    @Autowired
    public ProxyServiceImpl(ProxyMapper proxyMapper) {
        this.proxyMapper = proxyMapper;
    }

    @Override
    public ServiceModel<List<ProxyExtends>> getList(String page, String limit, String desc) {
        ServiceModel<List<ProxyExtends>> serviceModel = new ServiceModel<>();
        int offset;
        int limitNum;
        try {
            Map<String, Integer> map = paramsVerification(page, limit);
            limitNum = map.get("limitNum");
            offset = map.get("offset");
        }catch (IllegalArgumentException e) {
            return serviceModel.error(e.getMessage());
        }
        List<ProxyExtends> list;
        if(StringUtils.isEmpty(desc)) {
            desc = "default";
        }
        switch (desc) {
            case "new" : list = proxyMapper.getNew(offset, limitNum);break;
            case "available" : list = proxyMapper.getAvailable(offset, limitNum);break;
            default: list = proxyMapper.getList(offset, limitNum);
        }
        return serviceModel.success(list);
    }

    @Override
    public int count() {
        return proxyMapper.count();
    }

    public ServiceModel<List<ProxyExtends>> search(String keyword, String page, String limit) {
        ServiceModel<List<ProxyExtends>> serviceModel = new ServiceModel<>();
        int offset;
        int limitNum;
        try {
            Map<String, Integer> map = paramsVerification(page, limit);
            offset = map.get("offset");
            limitNum = map.get("limitNum");
        }catch (IllegalArgumentException e) {
            return serviceModel.error(e.getMessage());
        }
        if(StringUtils.isEmpty(keyword)) {
            keyword = "";
        }
        List<ProxyExtends> list = proxyMapper.search(offset, limitNum, keyword);
        return serviceModel.success(list);
    }

    @Override
    public int countByKeyword(String keyword) {
        if(StringUtils.isEmpty(keyword)) {
            keyword = "";
        }
        return proxyMapper.countByKeyword(keyword);
    }

    private Map<String, Integer> paramsVerification(String page, String limit) {
        Map<String, Integer> returnMap = new HashMap<>();
        int pageNum;
        int limitNum;
        try {
            pageNum = Integer.parseInt(page);
            limitNum = Integer.parseInt(limit);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("页码错误");
        }
        if(limitNum > maxLimit) {
            throw new IllegalArgumentException("limit错误");
        }
        int offset = Utils.getOffset(pageNum, limitNum);
        returnMap.put("offset", offset);
        returnMap.put("limitNum", limitNum);
        return returnMap;
    }

}
