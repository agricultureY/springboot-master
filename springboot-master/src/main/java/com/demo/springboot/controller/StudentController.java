package com.demo.springboot.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springboot.pojo.Student;
import com.demo.springboot.service.StudentService;

/**
 * student 控制器
 * @author ycn
 */
@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private StudentService studentService;
	
	@RequestMapping("/findPageStudent.do")
	public ModelAndView findPageStudent(@RequestParam(name="pageNum",required=false) Integer pageNum,
			@RequestParam(name="pageSize",required=false) Integer pageSize) throws Exception {
		if(StringUtils.isEmpty(pageNum) || pageNum <= 0)
			pageNum = 1;
		if(StringUtils.isEmpty(pageSize) || pageSize <= 0)
			pageSize = 10;
		ModelAndView mav = new ModelAndView();
		Page<Student> students = studentService.getAllStudent(pageNum, pageSize);
		mav.addObject("students", students.getContent());//获取当前页的list
		mav.addObject("number", students.getNumber());//获取总数量
		mav.addObject("numberOfElements", students.getNumberOfElements());//获取当前页的数量
		mav.addObject("size", students.getSize());//
		mav.addObject("totalElements", students.getTotalElements());//元素的总数
		mav.addObject("totalPage", students.getTotalPages());//总页数
		mav.setViewName("StudentIndex");
		return mav;
	}
	
	/**
	 * 保存学生信息
	 * @param student
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/saveStudent.do")
	public String saveStudent(@Valid Student student,BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			String msg = bindingResult.getFieldError().getDefaultMessage();
			return "{flag:false,msg:'"+msg+"'}";
		}else {			
			studentService.saveStudent(student);
			return "{flag:true}";
		}
	}
	
	/**
	 * 通过ID查询学生信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/getStudentById.do")
	public ModelAndView getStudentById(@RequestParam(name="id",required=true) Integer id) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", studentService.getOneStudent(id));
		mav.setViewName("StudentUpdate");
		return mav;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteStudent.do")
	public String deleteStudent(@RequestParam(name="id",required=true) Integer id) throws Exception {
		studentService.deleteStudent(id);
		return "forward:/student/findPageStudent.do";
	}
}
