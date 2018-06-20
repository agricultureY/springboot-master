package com.ycn.springboot.test1.dao;

import com.ycn.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ycn
 * @package com.ycn.springboot.test1.dao
 * @ClassName UserMapperTest1
 * @Date 2018/6/19 15:10
 */
public interface UserMapperTest1 {

    @Select("select * from users where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into users (name, sex, age) values (#{name}, #{sex}, #{age})")
    int insertUser(@Param("name") String name, @Param("sex") String sex, @Param("age") Integer age);
}
