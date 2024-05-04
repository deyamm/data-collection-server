package com.exchange.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exchange.sys.entity.ApiParam;
import com.exchange.sys.entity.PageVo;
import com.exchange.sys.mapper.ApiParamMapper;
import com.exchange.sys.service.ApiParamService;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ApiParamService")
public class ApiParamServiceImpl extends ServiceImpl<ApiParamMapper, ApiParam> implements ApiParamService {
    @Resource
    ApiParamMapper apiParamMapper;

    @Override
    public List<ApiParam> queryApiParamById(String apiId) {
        LambdaQueryWrapper<ApiParam> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(!StringUtils.isNullOrEmpty(apiId), ApiParam::getApiId, apiId)
                .orderBy(true, true, ApiParam::getSortNum);
        List<ApiParam> apiParams = apiParamMapper.selectList(lambdaQueryWrapper);
        System.out.println(apiParams);
        return apiParams;
    }

    @Override
    public int saveOrUpdateApiParams(PageVo<ApiParam> apiParams) {
        List<ApiParam> apiParamList = apiParams.getRecords();
        System.out.println(apiParamList);
        this.saveOrUpdateBatch(apiParamList);
        return 0;
    }
}
