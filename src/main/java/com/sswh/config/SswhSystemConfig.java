package com.sswh.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.beans.PropertyVetoException;

/**
 * @author nuanfeng
 * @date 2020/8/27 23:51
 */
@Configuration
@ComponentScan(basePackages = "com.sswh")
@Import({ThreadPoolConfig.class})
public class SswhSystemConfig {
    /**
     * 连接池的配置
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sswh?useUnicode=true&amp;characterEncoding=UTF-8&amp;useSSL=false");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        return comboPooledDataSource;
    }

    /**
     * 数据源事务的配置
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(ComboPooledDataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    /**
     * 视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver iResolver = new InternalResourceViewResolver();
        iResolver.setPrefix("/WEB-INF/pages/");
        iResolver.setSuffix(".jsp");
        return iResolver;
    }


}
