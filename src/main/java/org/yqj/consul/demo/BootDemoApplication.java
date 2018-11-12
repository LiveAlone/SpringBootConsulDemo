package org.yqj.consul.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@SpringBootApplication
@Controller
@EnableDiscoveryClient
public class BootDemoApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(BootDemoApplication.class)
                .run(args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String rootPage() throws UnknownHostException{
        return "host is " + InetAddress.getLocalHost().getHostName() + " with ip address " + InetAddress.getLocalHost().getHostAddress();
    }
}
