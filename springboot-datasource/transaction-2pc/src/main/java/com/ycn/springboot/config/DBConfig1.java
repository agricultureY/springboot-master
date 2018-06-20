package com.ycn.springboot.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.ycn.springboot.config.properties.DBProperties;
import com.ycn.springboot.config.properties.DBProperties1;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author ycn
 * @package com.ycn.springboot.config
 * @ClassName DBConfig1
 * @Date 2018/6/20 8:57
 */
@Configuration
@MapperScan(basePackages = {"com.ycn.springboot.test1"}, sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DBConfig1 {
    // 配置数据源
    @Bean(name = "test1DataSource")
    public DataSource testDataSource(DBProperties1 dbProperties) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbProperties.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbProperties.getPassword());
        mysqlXaDataSource.setUser(dbProperties.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test1DataSource");

        xaDataSource.setMinPoolSize(dbProperties.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbProperties.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbProperties.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbProperties.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dbProperties.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbProperties.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbProperties.getMaxIdleTime());
        xaDataSource.setTestQuery(dbProperties.getTestQuery());
        return xaDataSource;
    }

    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
