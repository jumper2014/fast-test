package cn.enilu.flash.api.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/*
Spring boot提供了AbstractRoutingDataSource 根据用户定义的规则选择当前的数据源，
这样我们可以在执行查询之前，设置使用的数据源。实现可动态路由的数据源，在每次数据库查询操作前执行。
 */
public class DynamicDatasource  extends AbstractRoutingDataSource {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    DynamicDatasource(Map<String, DataSource> dataSourceMap) {
        super();
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.putAll(dataSourceMap);
        super.setTargetDataSources(dsMap);
        super.setDefaultTargetDataSource(dataSourceMap.get("webflash"));
    }

    // 它的抽象方法 determineCurrentLookupKey() 决定使用哪个数据源
    @Override
    protected Object determineCurrentLookupKey() {
        return threadLocal.get();
    }

    public static void setCurrentDatasource(String datasourceName) {
        threadLocal.set(datasourceName);
    }

    public static void restoreDatasource() {
        threadLocal.set("webflash");
    }
}
