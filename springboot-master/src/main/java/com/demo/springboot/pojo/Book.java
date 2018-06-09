package com.demo.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据库实体类
 * @author ycn
 */
@Entity
@Table(name = "t_book")
public class Book {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100)
	private String bookName;
	
	@Column(length = 32)
	private String bookAuthor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
}
