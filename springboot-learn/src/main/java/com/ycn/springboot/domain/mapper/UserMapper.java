package com.ycn.springboot.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ycn.springboot.domain.User;
/**
 * userMapper
 * 
 * @Package: com.ycn.springboot.domain.mapper
 * @author: ycn
 * @date: 2018年5月23日 下午3:03:11
 */
@Mapper
public interface UserMapper {

	@Select("select * from user where name like CONCAT('%', #{name} ,'%')")
	User selectByName(@Param("name") String name);
	
	@Insert("insert into user (name, sex, age) values (#{name}, #{sex}, #{age})")
	Integer addUser(@Param("name") String name, @Param("sex") String sex, @Param("age") Integer age);
	
	@Results(value = {
			@Result(column = "id", property = "id"),
			@Result(column = "name", property = "name"),
			@Result(column = "sex", property = "sex"),
			@Result(column = "age", property = "age")
	})
	@Select("select id,name,sex,age from user")
	List<User> selectUserList();
	
	@Update("update user set age = #{age} where name = #{name}")
	Integer updateAgeByName(@Param("name") String name, @Param("age") Integer age);
	
	@Update("update user set age = #{age},name = #{name},sex = #{sex} where id = #{id}")
	Integer updateUserInfoById(User user);
	
	@Delete("delete from user where id = #{id}")
	Integer deleteUserById(@Param("id") Long id);
}
