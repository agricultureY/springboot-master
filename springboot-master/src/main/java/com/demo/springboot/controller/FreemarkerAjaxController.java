package com.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 返回ajax json数据格式
 * @author ycn
 */
@RestController
@RequestMapping("/ajax")
public class FreemarkerAjaxController {

	@RequestMapping("/hello.do")
	public String restController() {
		return "{'title':'测试','msg':'@RestController成功'}";
	}
}
