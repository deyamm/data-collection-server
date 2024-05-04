package com.exchange.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.exchange.sys.entity.ApiParam;
import com.exchange.sys.entity.CollectionApi;
import com.exchange.sys.entity.PageVo;
import com.exchange.sys.service.CollectionApiService;
import com.exchange.sys.utils.ResponseBody;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CollectionApiController {

    @Resource
    CollectionApiService collectApiService;

    @PostMapping("/addApi")
    public ResponseBody<Integer> addApi(@RequestBody CollectionApi api) {
        return ResponseBody.success(collectApiService.addApi(api));
    }

    @PostMapping("/queryApi")
    public ResponseBody<IPage> queryApi(@RequestBody PageVo pageVo){
        // System.out.println("----");
        // System.out.println(res);
        return ResponseBody.success(collectApiService.queryApi(pageVo));
    }

    @PostMapping("/queryOne")
    public ResponseBody<CollectionApi> queryOne(@RequestBody CollectionApi api) {
        return ResponseBody.success(collectApiService.selectOne(api));
    }

    @PostMapping("/deleteApi")
    public ResponseBody<Integer> deleteApi(@RequestBody CollectionApi api) {
        return ResponseBody.success(collectApiService.deleteApi(api));
    }

    @PostMapping("/updateApi")
    public ResponseBody<Integer> updateApi(@RequestBody CollectionApi api) {
        return ResponseBody.success(collectApiService.updateApi(api));
    }

}
