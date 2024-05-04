package com.exchange.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exchange.sys.entity.CollectionTask;
import com.exchange.sys.mapper.CollectionTaskMapper;
import com.exchange.sys.service.CollectionTaskService;
import org.springframework.stereotype.Service;

@Service("CollectionTaskService")
public class CollectionTaskServiceImpl extends ServiceImpl<CollectionTaskMapper, CollectionTask> implements CollectionTaskService {

}
