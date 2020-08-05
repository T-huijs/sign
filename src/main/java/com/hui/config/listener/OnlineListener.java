package com.hui.config.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
@Slf4j
@WebListener
public class OnlineListener implements HttpSessionListener {

    private int count = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count ++;
        log.info("session创建，当前在线人数-{}", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        log.info("session销毁，当前在线人数-{}", count);
    }
}
