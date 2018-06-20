package com.ycn.springboot.model;

import com.ycn.springboot.database.BaseEntity;

import javax.persistence.Table;

/**
 *  实体类
 *
 * @author ycn
 * @package com.ycn.springboot.model
 * @ClassName DicType
 * @Date 2018/6/18 14:25
 */
@Table(name = "dic_type")
public class DicType extends BaseEntity {
    String code;

    String name;

    Integer status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DicType() { }

    public DicType(String code, String name, Integer status) {
        this.code = code;
        this.name = name;
        this.status = status;
    }
}
