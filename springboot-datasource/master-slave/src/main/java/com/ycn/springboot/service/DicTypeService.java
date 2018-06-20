package com.ycn.springboot.service;

import com.ycn.springboot.model.DicType;

import java.util.List;

/**
 * @author ycn
 * @package com.ycn.springboot.service
 * @ClassName DicTypeService
 * @Date 2018/6/18 14:56
 */
public interface DicTypeService {

    /**
     * 查询所有
     * @param dicType
     * @return
     */
    List<DicType> getAllDicType(DicType dicType);

    /**
     * 新增
     * @return
     */
    Boolean addDicType();
}
