package com.exchange.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exchange.sys.entity.DataCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface DataCategoryService extends IService<DataCategory> {

    public JSONObject createDataCategoryTree();
}
