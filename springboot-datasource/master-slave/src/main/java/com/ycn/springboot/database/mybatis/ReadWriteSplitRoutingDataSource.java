package com.ycn.springboot.database.mybatis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 读写分离数据源
 * 
 * @Package: com.ycn.springboot.database.mybatis
 * @author: ycn
 * @date: 2018年6月17日 上午11:04:05
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DbContextHolder.getDbType();
	}

}
