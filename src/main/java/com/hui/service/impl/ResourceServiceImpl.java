package com.hui.service.impl;

import com.hui.mapper.ResourceMapper;
import com.hui.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {

    private Map<String, List<String>> urlMap = new HashMap<>();

    @Resource
    private  ResourceMapper resourceMapper;


    public Boolean checkRole(String roleId, String url){
        List<String> urlList = urlMap.get(roleId);
        log.info("获取当前角色可访问接口-{}", urlList);
        if(CollectionUtils.isEmpty(urlList)){
            urlList = resourceMapper.queryUrl(roleId);
            log.info("从数据库获取urlList-{}", urlList);
            urlMap.put(roleId, urlList);
        }
        if(!urlList.contains(url)){
            return false;
        }
        return true;
    }

    public List<String> queryUrl(String roleId){
        return resourceMapper.queryUrl(roleId);
    }
}
