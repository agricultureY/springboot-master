package com.ycn.springboot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * test数据源配置
 * @author ycn
 * @package com.ycn.springboot.config
 * @ClassName TestDatasourceConfig
 * @Date 2018/6/19 14:18
 */
//@Configuration
//@MapperScan(basePackages = {"com.ycn.springboot.test"}, sqlSessionFactoryRef = "testSqlSessionFactory")
public class TestDataSourceConfig {
    /**
     * testDataSource数据库配置
     * @return

	@Bean(name = "testDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.test")
	@Primary//设为主数据源
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}*/

    /**
     * 注入testSqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception

	@Bean(name = "testSqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		//mybatis写配置文件
//		 bean.setMapperLocations(
//		 new
//		 PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
		return bean.getObject();
	}*/

    /**
     * 开启事务管理
     * @param dataSource
     * @return

    @Bean(name = "testTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

    /**
     * 注入testSqlSessionTemplate
     * @param sqlSessionFactory
     * @return

	@Bean(name = "testSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}*/
}
