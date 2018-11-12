package org.yqj.consul.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/11/17
 * Email: qijunyao@xiaohongshu.com
 */
@RestController
@Slf4j
public class ServiceInfoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("services")
    public List<String> gainUsername(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("consul-demo1");
        return serviceInstances.stream().map(s->String.format("%s-%s", s.getHost(), s.getPort())).collect(Collectors.toList());
    }
}
