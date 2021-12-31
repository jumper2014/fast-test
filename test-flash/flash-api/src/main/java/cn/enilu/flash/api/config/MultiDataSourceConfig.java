package cn.enilu.flash.api.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MultiDataSourceConfig {

//    // 注意要用如下的配置：cust.datasource.test1.url
//    // 不要用cust.datasource.test1.jdbc-url
//
//    //主数据源配置 ds1数据源
//    @Primary
//    @Bean(name = "ds1DataSourceProperties")
//    @ConfigurationProperties(prefix = "cust.datasource.test1")
//    public DataSourceProperties ds1DataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    //主数据源 ds1数据源
//    @Primary
//    @Bean(name = "ds1DataSource")
//    public DataSource ds1DataSource(@Qualifier("ds1DataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    //第二个ds2数据源配置
//    @Bean(name = "ds2DataSourceProperties")
//    @ConfigurationProperties(prefix = "cust.datasource.test2")
//    public DataSourceProperties ds2DataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    //第二个ds2数据源
//    @Bean("ds2DataSource")
//    public DataSource ds2DataSource(@Qualifier("ds2DataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }

}
