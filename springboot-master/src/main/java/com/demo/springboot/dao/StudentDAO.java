package com.demo.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.pojo.Student;

/**
 * student  数据库接口
 * @author ycn
 */
public interface StudentDAO extends JpaRepository<Student, Integer> {

}
