package com.music.demo.login.controller;

import com.alibaba.nacos.api.naming.pojo.healthcheck.impl.Http;
import com.music.demo.common.result.HttpResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.Name;

@RestController
@RequestMapping("/api/nacos")
public class NacosController {
    @Value("${spring.datasource.url}")
    private String url;

    @Operation(summary = "获取nacos的url")
    @GetMapping("/nacos")
    public HttpResult<String> getNacos() {
        return HttpResult.success(url);
    }
}
