package com.exchange.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exchange.sys.entity.ApiParam;
import com.exchange.sys.entity.PageVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiParamService extends IService<ApiParam> {

    public List<ApiParam> queryApiParamById(String apiId);

    public int saveOrUpdateApiParams(PageVo<ApiParam> apiParams);

}
