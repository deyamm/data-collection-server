package com.exchange.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exchange.sys.entity.ApiParam;
import com.exchange.sys.entity.CollectionApi;
import com.exchange.sys.entity.PageVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionApiService extends IService<CollectionApi> {

    public int addApi(CollectionApi api);

    public IPage queryApi(PageVo pageVo);

    public IPage queryApiByName(String apiName);

    public CollectionApi selectOne(CollectionApi api);

    public int deleteApi(CollectionApi api);

    public int updateApi(CollectionApi api);
}
