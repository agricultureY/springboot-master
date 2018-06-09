package com.ycn.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.ycn.learn")
public class FooProperties {

    private String foo;

    private String databasePlatform;
}
