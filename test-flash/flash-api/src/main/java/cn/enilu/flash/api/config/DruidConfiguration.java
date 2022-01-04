package cn.enilu.flash.api.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;
import java.util.Map;

/**
 * descript
 *
 * @Author enilu
 * @Date 2021/6/6 1:56
 * @Version 1.0
 */

@Configuration
public class DruidConfiguration {
    @Autowired
    private Environment env;
    private final Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // IP白名单
//        servletRegistrationBean.addInitParameter("allow", "*");
        // IP黑名单(共同存在时，deny优先于allow)
//        servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        String user = env.getProperty("spring.datasource.druid.stat-view-servlet.login-username");
        String password =  env.getProperty("spring.datasource.druid.stat-view-servlet.login-password");
        servletRegistrationBean.addInitParameter("loginUsername", user);
        servletRegistrationBean.addInitParameter("loginPassword", password);
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean("webflash")
    @ConfigurationProperties(prefix = "spring.datasource.webflash")
    public DataSource webflash(){
        return new DruidDataSource();
    }

    @Bean("test")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource test(){
        return new DruidDataSource();
    }

    @Bean("crud")
    @ConfigurationProperties(prefix = "spring.datasource.crud")
    public DataSource crud(){
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public DataSource dataSource(@Autowired Map<String, DataSource> datasourceMap) {
        return new DynamicDatasource(datasourceMap);
    }
}
