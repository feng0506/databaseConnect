package com.example.demo0719.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration//配置的注解
@MapperScan(basePackages = {"com.example.demo0719.mysql.dao"}, sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class MybatisDbMysqlConfig {
    // 配置数据源
    @Bean(name = "test2DataSource")
    public DataSource testDataSource(DBMysqlConfig testConfig) throws SQLException {
       /* MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(testConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(testConfig.getPassword());
        mysqlXaDataSource.setUser(testConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test2DataSource");*/
        //这里是通过查sqlite数据库中表的数据，得到mysql的连接信息

        MysqlDataSource mysqlDataSource=new MysqlDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://"+testConfig.getIp()+":"+testConfig.getPort()+"/"+testConfig.getDataname()+"?characterEncoding=utf8&useSSL=false");
        mysqlDataSource.setUser(testConfig.getUsername());
        mysqlDataSource.setPassword(testConfig.getPassword());
        mysqlDataSource.setDatabaseName("test2DataSource");
        return mysqlDataSource;
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
