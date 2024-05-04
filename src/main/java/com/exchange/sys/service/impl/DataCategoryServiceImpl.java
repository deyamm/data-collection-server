package com.exchange.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exchange.sys.entity.DataCategory;
import com.exchange.sys.mapper.DataCategoryMapper;
import com.exchange.sys.service.DataCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("DataCategoryService")
public class DataCategoryServiceImpl extends ServiceImpl<DataCategoryMapper, DataCategory> implements DataCategoryService {

    @Override
    public JSONObject createDataCategoryTree() {
        JSONObject dataCategoryTree = new JSONObject();
        // DataCategory rootNode = this.baseMapper.selectOne(new LambdaQueryWrapper<>().eq(DataCategory::getNodeType, 0));
        // List<DataCategory> dataCategoryList = this.list();

        return null;
    }
}
