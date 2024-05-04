package com.exchange.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RestControllerTest {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getString() {
        return "restController";
    }

    @GetMapping("/getMapTest")
    public String getMapTest() {
        return "getMapping";
    }

    @GetMapping("/paramTest")
    public String getParams(String param1, String param2) {
        System.out.println(param1);
        System.out.println(param2);
        return "params: " + param1 + " " + param2;
    }

    @GetMapping("/paramTest2")
    public String getParams2(@RequestParam(value = "param1", required = true) String p1) {
        System.out.println(p1);
        return "params: " + p1;
    }

    @PostMapping("/postTest")
    public String postTest(String param1) {
        System.out.println(param1);
        return "postTest: " + param1;
    }
}
