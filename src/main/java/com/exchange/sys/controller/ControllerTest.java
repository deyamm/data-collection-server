package com.exchange.sys.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hh")
@Slf4j
@Tag(name = "test")
public class ControllerTest {

    @RequestMapping("/hello")
    @Operation(tags = "test", summary = "swagger test")
    public String index(ModelMap map) {
        map.addAttribute("name", "test");
        return "test";
    }
}
