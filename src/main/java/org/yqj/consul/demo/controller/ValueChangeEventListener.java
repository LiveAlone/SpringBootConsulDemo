package org.yqj.consul.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/11/16
 * Email: qijunyao@xiaohongshu.com
 */
@Component
@Slf4j
public class ValueChangeEventListener {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HealthController healthController;

    public static final String USERNAME = "username";

    @EventListener
    public void handle(EnvironmentChangeEvent event) {

        if (event.getKeys().contains(USERNAME)){
            healthController.setUsername(applicationContext.getEnvironment().getProperty(USERNAME));
        }

    }
}
