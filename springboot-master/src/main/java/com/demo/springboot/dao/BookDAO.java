package com.demo.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.pojo.Book;

/**
 * book  数据库接口
 * @author ycn
 */
public interface BookDAO extends JpaRepository<Book, Integer> {

}
