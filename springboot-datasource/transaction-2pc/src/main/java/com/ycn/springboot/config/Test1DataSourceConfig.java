package com.ycn.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * test1数据源配置
 * @author ycn
 * @package com.ycn.springboot.config
 * @ClassName Test1DataSourceConfig
 * @Date 2018/6/19 14:33
 */
//@Configuration
//@MapperScan(basePackages = {"com.ycn.springboot.test1"}, sqlSessionFactoryRef = "test1SqlSessionFactory")
public class Test1DataSourceConfig {
    /**
     * test1DataSource数据库配置
     * @return

    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }*/

    /**
     * 注入test1SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception

    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
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

    @Bean(name = "test1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

    /**
     * 注入testSqlSessionTemplate
     * @param sqlSessionFactory
     * @return

    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }*/
}
