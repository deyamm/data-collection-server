package com.exchange.sys.controller;

import com.exchange.sys.entity.ApiParam;
import com.exchange.sys.entity.PageVo;
import com.exchange.sys.service.ApiParamService;
import com.exchange.sys.utils.ResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ApiParamController {

    @Resource
    ApiParamService apiParamService;

    @GetMapping("/queryApiParamById")
    public ResponseBody<List<ApiParam>> queryApiParamById(@RequestParam("apiId") String apiId) {
        return ResponseBody.success(apiParamService.queryApiParamById(apiId));
    }

    @PostMapping("/saveApiParams")
    public ResponseBody<Integer> saveApiParams(@RequestBody PageVo<ApiParam> apiParams) {
        return ResponseBody.success(1);
    }
}
