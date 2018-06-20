package com.ycn.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.ycn.springboot.database.mybatis.ReadOnlyConnection;
import com.ycn.springboot.mapper.DicTypeMapper;
import com.ycn.springboot.model.DicType;
import com.ycn.springboot.service.DicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ycn
 * @package com.ycn.springboot.service.impl
 * @ClassName DicTypeServiceImpl
 * @Date 2018/6/18 14:58
 */
@Service
public class DicTypeServiceImpl implements DicTypeService {

    @Autowired
    private DicTypeMapper dicTypeMapper;

    @Override
    @ReadOnlyConnection
    public List<DicType> getAllDicType(DicType dicType) {
//        dicTypeMapper.insert(new DicType("asdqwe", "测试", 1));
        if (dicType.getPage() != null && dicType.getRows() != null)
            PageHelper.startPage(dicType.getPage(), dicType.getRows());
        return dicTypeMapper.selectAll();
    }

    @Override
    public Boolean addDicType() {
        return dicTypeMapper.insert(new DicType("asdqwe", "测试", 1))>0?true:false;
    }

}
