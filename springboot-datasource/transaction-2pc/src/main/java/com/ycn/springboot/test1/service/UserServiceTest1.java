package com.ycn.springboot.test1.service;

import com.ycn.springboot.test1.dao.UserMapperTest1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ycn
 * @package com.ycn.springboot.test1.service
 * @ClassName UserServiceTest1
 * @Date 2018/6/19 16:31
 */
@Service
@Transactional
public class UserServiceTest1 {

    @Autowired
    private UserMapperTest1 userMapperTest1;

    public Boolean insertTest1(String name, String sex, Integer age) {
        userMapperTest1.insertUser(name, sex, age);
        return true;
    }
}
