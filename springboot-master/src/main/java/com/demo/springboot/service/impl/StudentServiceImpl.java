package com.demo.springboot.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.springboot.dao.StudentDAO;
import com.demo.springboot.pojo.Student;
import com.demo.springboot.service.StudentService;
/**
 * student接口实现
 * @author ycn
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentDAO studentDao;
	
	/**
	 * 构建分页信息
	 * @param pageNum -- 第几页
	 * @param pageSize -- 一页数据量
	 * @return
	 */
	private PageRequest buildPageRequest(Integer pageNum,Integer pageSize) {
		return new PageRequest(pageNum - 1, pageSize);
	}
	
	@Override
	public Page<Student> getAllStudent(Integer pageNum,Integer pageSize) throws Exception {
		return studentDao.findAll(buildPageRequest(pageNum,pageSize));
	}

	@Override
	public Student getOneStudent(Integer id) throws Exception {
		return studentDao.findOne(id);
	}

	@Override
	public void saveStudent(Student student) throws Exception {
		if(null != student)
			studentDao.save(student);
		else
			throw new Exception("学生为空");
	}

	@Override
	public void deleteStudent(Integer id) throws Exception {
		studentDao.delete(id);
	}

}
