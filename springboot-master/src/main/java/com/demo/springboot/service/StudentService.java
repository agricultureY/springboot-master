package com.demo.springboot.service;
/**
 * student 接口
 * @author ycn
 */

import org.springframework.data.domain.Page;

import com.demo.springboot.pojo.Student;

public interface StudentService {

	/**
	 * 分页查询所有学生
	 * @return
	 * @throws Exception
	 */
	public Page<Student> getAllStudent(Integer pageNum,Integer pageSize) throws Exception;
	
	/**
	 * 通过ID查询学生信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Student getOneStudent(Integer id) throws Exception;
	
	/**
	 * 保存学生信息，如果不存在该学生则新增，否则修改
	 * @param student
	 * @throws Exception
	 */
	public void saveStudent(Student student) throws Exception;
	
	/**
	 * 删除学生
	 * @param id
	 * @throws Exception
	 */
	public void deleteStudent(Integer id) throws Exception;
}
