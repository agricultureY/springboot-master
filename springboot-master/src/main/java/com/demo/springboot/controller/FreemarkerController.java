package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 返回freemarker视图
 * @author ycn
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

	@RequestMapping("/freemarketView.do")
	public ModelAndView setDataToView() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "测试freemarker视图解析");
		mv.setViewName("helloWord");
		return mv;
	}
}
