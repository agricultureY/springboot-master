package com.ycn.springboot.database;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 该接口不能被扫描
 * 
 * @Package: com.ycn.springboot.database
 * @author: ycn
 * @date: 2018年6月17日 上午10:41:13
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
