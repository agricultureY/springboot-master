package com.ycn.springboot.database.durid;

import com.ycn.springboot.database.mybatis.DbContextHolder;
import com.ycn.springboot.database.mybatis.ReadWriteSplitRoutingDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

/**
 * mybatis配置类
 * 
 * @Package: com.ycn.springboot.database.durid
 * @author: ycn
 * @date: 2018年6月17日 下午11:31:57
 */
@Configuration
@AutoConfigureAfter(value = {DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {

	private static Log logger = LogFactory.getLog(MybatisConfiguration.class);
	
	@Resource(name = "masterDataSource")
	private DataSource masterDataSource;
	@Resource(name = "slaveDataSource")
	private DataSource slaveDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        logger.info("-------------------- 重载父类 sqlSessionFactory init ---------------------");
        return super.sqlSessionFactory(roundRobinDataSourceProxy());
    }
    
	public AbstractRoutingDataSource roundRobinDataSourceProxy() {
		ReadWriteSplitRoutingDataSource readWriteSplitRoutingDataSource = new ReadWriteSplitRoutingDataSource();
		Map<Object, Object> targetDataSource = new ClassLoaderRepository.SoftHashMap();
		targetDataSource.put(DbContextHolder.DbType.MASTER, masterDataSource);
		targetDataSource.put(DbContextHolder.DbType.SLAVE, slaveDataSource);
		readWriteSplitRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
		readWriteSplitRoutingDataSource.setTargetDataSources(targetDataSource);
		return readWriteSplitRoutingDataSource;
	}
	
}
