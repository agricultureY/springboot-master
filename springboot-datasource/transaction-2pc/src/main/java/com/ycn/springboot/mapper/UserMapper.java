package com.ycn.springboot.mapper;

import com.ycn.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ycn
 * @package com.ycn.springboot.mapper
 * @ClassName UserMapper
 * @Date 2018/6/19 17:40
 */
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, SEX, AGE) VALUES(#{name}, #{sex}, #{age})")
    int insert(@Param("name") String name, @Param("sex") String sex, @Param("age") Integer age);
}
