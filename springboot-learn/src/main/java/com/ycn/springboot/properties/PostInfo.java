package com.ycn.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class PostInfo {
	private String title;
    private String content;
}
