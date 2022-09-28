package com.vladik.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class BotConfig {

    @Value("${user}")
    private String USER;
    @Value("${token}")
    private String TOKEN;

    public String getUSER() {
        return USER;
    }

    public String getTOKEN() {
        return TOKEN;
    }
}