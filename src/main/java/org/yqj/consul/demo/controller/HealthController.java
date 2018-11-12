package org.yqj.consul.demo.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/11/16
 * Email: qijunyao@xiaohongshu.com
 */
@RestController
@Slf4j
@Data
public class HealthController {

    private static final String SUCCESS = "success";

    @Value("${username}")
    public String username;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/acturator/health")
    public String home() {
        return "Hello world";
    }

    @RequestMapping("test")
    public String gainAllInstance(){
        log.info("get all service is: {}", discoveryClient.getServices());
        return SUCCESS;
    }

    @RequestMapping("username")
    public String gainUsername(){
        return username;
    }
}
