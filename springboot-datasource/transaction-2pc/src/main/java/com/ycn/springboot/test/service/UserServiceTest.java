package com.ycn.springboot.test.service;

import com.ycn.springboot.test.dao.UserMapperTest;
import com.ycn.springboot.test1.dao.UserMapperTest1;
import com.ycn.springboot.test1.service.UserServiceTest1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ycn
 * @package com.ycn.springboot.test.service
 * @ClassName UserServiceTest
 * @Date 2018/6/19 15:02
 */
@Service
@Transactional
public class UserServiceTest {

    @Autowired
    private UserMapperTest userMapperTest;
    @Autowired
    private UserMapperTest1 userMapperTest1;
    @Autowired
    private UserServiceTest1 userServiceTest1;

    public Boolean insertTest(String name, String sex, Integer age) {
        userMapperTest.insertUser(name, sex, age);
//        userServiceTest1.insertTest1(name, sex, age);
        userMapperTest1.insertUser(name, sex, age);
        System.out.println(1/0);
        return true;
    }
}
