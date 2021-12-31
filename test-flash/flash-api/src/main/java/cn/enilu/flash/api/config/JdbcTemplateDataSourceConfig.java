package cn.enilu.flash.api.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateDataSourceConfig {
//    // 在MultiDataSourceConfig的基础上
//    //JdbcTemplate主数据源ds1数据源
//    @Primary
//    @Bean(name = "ds1JdbcTemplate")
//    public JdbcTemplate ds1JdbcTemplate(@Qualifier("ds1DataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    //JdbcTemplate第二个ds2数据源
//    @Bean(name = "ds2JdbcTemplate")
//    public JdbcTemplate ds2JdbcTemplate(@Qualifier("ds2DataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

}
