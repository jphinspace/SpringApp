package com.example.webapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rate.limit")
public class RateLimitProperties {
    private int capacity = 30;
    private int time = 1;

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
}
