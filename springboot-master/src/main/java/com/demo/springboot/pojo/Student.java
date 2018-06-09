package com.demo.springboot.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 学生数据库实体类
 * @author ycn
 */
@Entity
@Table(name = "t_student")
public class Student {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "姓名不能为空")
	@Column(length = 32)
	private String stuName;

	@NotNull(message = "年龄不能为空")
	@Max(value = 30,message = "年龄不超过30岁")
	@Min(value = 18,message = "最小年龄为18岁")
	@Column(length = 3)
	private Integer stuAge;

    @Email(message = "邮箱格式错误")
    private String email;

    @Past(message = "生日必须为过去时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getStuAge() {
		return stuAge;
	}

	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
