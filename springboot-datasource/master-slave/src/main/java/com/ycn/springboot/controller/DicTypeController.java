package com.ycn.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.ycn.springboot.model.DicType;
import com.ycn.springboot.service.DicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ycn
 * @package com.ycn.springboot.controller
 * @ClassName DicTypeController
 * @Date 2018/6/18 16:23
 */
@RestController
@RequestMapping(value = "/dicType")
public class DicTypeController {

    @Autowired
    private DicTypeService dicTypeService;

    @RequestMapping("/getAllDicType")
    public PageInfo<DicType> getAllDicType(DicType dicType){
        return new PageInfo<>(dicTypeService.getAllDicType(dicType));
    }

    @RequestMapping("/addDicType")
    public Boolean addDicType() {
        return dicTypeService.addDicType();
    }
}
