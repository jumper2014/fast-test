package me.zhengjie.utils.fasttest;


import me.zhengjie.constant.fasttest.MySQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MySQLHelper {
    public JdbcTemplate connectDemoDb() {
        return connectDb(MySQL.demoDbUrl);
    }

    public JdbcTemplate connectDb (String dbUrl) {
        DriverManagerDataSource driverManagerDataSource;
        //因为JDBCTemplate是依赖数据库连接池的，所以先构造连接池
        driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(MySQL.driverClassName);
        driverManagerDataSource.setUrl(dbUrl);
        driverManagerDataSource.setUsername(MySQL.dbUsername);
        driverManagerDataSource.setPassword(MySQL.dbPassword);

        JdbcTemplate  jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        return jdbcTemplate;
    }


}
