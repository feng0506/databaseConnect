package com.example.demo0719.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration//配置的注解
@MapperScan(basePackages = {"com.example.demo0719.sqlite.dao"}, sqlSessionTemplateRef = "testSqlSessionTemplate")
public class MybatisDbSqliteConfig {
    // 配置数据源,Primary是主数据源，就是tomcat启动先走的数据库
    @Primary
    @Bean(name = "testDataSource")
    public DataSource testDataSource(DBSqliteConfig testConfig) throws SQLException {

        SQLiteDataSource sqLiteDataSource=new SQLiteDataSource();
        sqLiteDataSource.setUrl(testConfig.getUrl());
        sqLiteDataSource.setDatabaseName("testDataSource");



/*        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource();
        xaDataSource.setUniqueResourceName("testDataSource");*/

        return sqLiteDataSource;
    }

    @Bean(name = "testSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "testSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
