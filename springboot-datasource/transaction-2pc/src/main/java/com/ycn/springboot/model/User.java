package com.ycn.springboot.model;

/**
 * @author ycn
 * @package com.ycn.springboot.model
 * @ClassName User
 * @Date 2018/6/19 14:49
 */
public class User {

    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
