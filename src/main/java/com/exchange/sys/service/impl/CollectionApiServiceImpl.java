package com.exchange.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exchange.sys.entity.ApiParam;
import com.exchange.sys.entity.CollectionApi;
import com.exchange.sys.entity.PageVo;
import com.exchange.sys.mapper.CollectionApiMapper;
import com.exchange.sys.service.ApiParamService;
import com.exchange.sys.service.CollectionApiService;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("CollectApiService")
public class CollectionApiServiceImpl extends ServiceImpl<CollectionApiMapper, CollectionApi> implements CollectionApiService {
    @Resource
    private CollectionApiMapper collectionApiMapper;

    @Resource
    private ApiParamService apiParamService;

    @Override
    public int addApi(CollectionApi api) {
        collectionApiMapper.insert(api);
        String apiId = api.getId();
        api.getRequestParams().forEach(item -> {
            item.setApiId(apiId);
        });
        api.getResponseParams().forEach(item -> {
            item.setApiId(apiId);
        });
        apiParamService.saveOrUpdateBatch(api.getRequestParams());
        apiParamService.saveOrUpdateBatch(api.getResponseParams());
        return 1;
    }

    public IPage selectApi(PageVo pageVo, Wrapper wrapper) {
        List<CollectionApi> collectionApiList = collectionApiMapper.selectList(wrapper);
        //
        pageVo.setRecords(collectionApiList
                .stream()
                .skip((pageVo.getCurrent() - 1) * pageVo.getSize())
                .limit(pageVo.getSize())
                .collect(Collectors.toList()));
        pageVo.setTotal(collectionApiList.size());
        System.out.println(pageVo);
        //
        pageVo.getRecords().forEach(e -> {
            List<ApiParam> params = apiParamService.queryApiParamById(((CollectionApi) e).getId());
            ((CollectionApi) e).setRequestParams(new ArrayList<>());
            ((CollectionApi) e).setResponseParams(new ArrayList<>());
            params.forEach(param -> {
                if (param.getPosition() == 0) {
                    ((CollectionApi) e).getRequestParams().add(param);
                } else {
                    ((CollectionApi) e).getResponseParams().add(param);
                }
            });
        });
        return pageVo;
    }

    @Override
    public IPage queryApi(PageVo pageVo) {
        LambdaQueryWrapper<CollectionApi> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isNullOrEmpty(pageVo.getSearch()), CollectionApi::getName, pageVo.getSearch());
        wrapper.orderBy(true, true, CollectionApi::getCreateTime);
        return this.selectApi(pageVo, wrapper);
    }

    @Override
    public IPage queryApiByName(String apiName) {
        LambdaQueryWrapper<CollectionApi> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(CollectionApi::getName, apiName);
        PageVo pageVo = new PageVo();
        pageVo.setCurrent(1);
        pageVo.setSize(10);
        return selectApi(pageVo, wrapper);
    }

    @Override
    public CollectionApi selectOne(CollectionApi api) {
        LambdaQueryWrapper<CollectionApi> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(!StringUtils.isNullOrEmpty(api.getName()), CollectionApi::getName, api.getName());
        return collectionApiMapper.selectOne(lambdaQueryWrapper);
    }

    @Override
    public int deleteApi(CollectionApi api) {
        collectionApiMapper.deleteById(api.getId());
        apiParamService.remove(new LambdaQueryWrapper<ApiParam>()
                .eq(!StringUtils.isNullOrEmpty(api.getId()), ApiParam::getApiId, api.getId()));
        return 1;
    }

    @Override
    public int updateApi(CollectionApi api) {
        collectionApiMapper.updateById(api);
        apiParamService.saveOrUpdateBatch(api.getRequestParams());
        apiParamService.saveOrUpdateBatch(api.getResponseParams());
        return 1;
    }


}
