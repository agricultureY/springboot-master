package com.ycn.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycn.springboot.exception.MyException;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HelloController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

    @RequestMapping("/runtimeException")
    public String runtimeException() throws RuntimeException {
        throw new RuntimeException("发生错误");
    }

    @RequestMapping("/myException")
    public String MyException() throws MyException {
        throw new MyException("发生错误2");
    }

	@ResponseBody
	@RequestMapping("/helloword")
	public String helloword() {
		return "helloword";
	}

	@RequestMapping("/freemarker")
	public String freemarker(ModelMap map) {
		map.addAttribute("attribute", "freemarker视图解析器页面");
		return "freemarker";
	}

	@RequestMapping("/thymeleaf")
	public String thymeleaf(ModelMap map) {
		map.addAttribute("attribute", "thymeleaf视图解析器页面");
		return "thymeleaf";
	}
}
