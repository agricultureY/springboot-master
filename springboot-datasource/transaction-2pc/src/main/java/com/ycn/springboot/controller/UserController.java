package com.ycn.springboot.controller;

import com.ycn.springboot.mapper.UserMapper;
import com.ycn.springboot.test.service.UserServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ycn
 * @package com.ycn.springboot.controller
 * @ClassName UserController
 * @Date 2018/6/19 16:40
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceTest userServiceTest;

    @RequestMapping("/insertUser")
    public String insertUser(String name, String sex, Integer age) {
        userServiceTest.insertTest(name, sex, age);
        return "success";
    }

}
