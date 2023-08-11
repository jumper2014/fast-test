package com.example.utils.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhcacheServiceImpl implements EhcacheService {

    // value的值和ehcache.xml中的配置保持一致
    @Cacheable(value = "HelloWorldCache", key = "#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

    @Cacheable(value = "HelloWorldCache", key = "#key")
    public String getDataFromDB(String key) {
        System.out.println("从数据库中获取数据...");
        return key + ":" + String.valueOf(Math.round(Math.random() * 1000000));
    }

    @CacheEvict(value = "HelloWorldCache", key = "#key")
    public void removeDataAtDB(String key) {
        System.out.println("从数据库中删除数据");
    }

    @CachePut(value = "HelloWorldCache", key = "#key")
    public String refreshData(String key) {
        System.out.println("模拟从数据库中加载数据");
        return key + "::" + String.valueOf(Math.round(Math.random() * 1000000));
    }

    // ------------------------------------------------------------------------
    // 将缓存保存到名称为UserCache中，键为"user:"字符串加上userId值，如 'user:1'
    @Cacheable(value = "UserCache", key = "'user:' + #userId")
    public User findById(String userId) {
        System.out.println("模拟从数据库中查询数据");
        return new User(1, "mengdee");
    }

    // 将缓存保存进UserCache中，并当参数userId的长度小于12时才保存进缓存，默认使用参数值及类型作为缓存的key
    // 保存缓存需要指定key，value， value的数据类型，不指定key默认和参数名一样如："1"
    @Cacheable(value = "UserCache", condition = "#userId.length()<12")
    public boolean isReserved(String userId) {
        System.out.println("UserCache:" + userId);
        return false;
    }

    //清除掉UserCache中某个指定key的缓存
    @CacheEvict(value = "UserCache", key = "'user:' + #userId")
    public void removeUser(String userId) {
        System.out.println("UserCache remove:" + userId);
    }

    //allEntries：true表示清除value中的全部缓存，默认为false
    //清除掉UserCache中全部的缓存
    @CacheEvict(value = "UserCache", allEntries = true)
    public void removeAllUser() {
        System.out.println("UserCache delete all");
    }
}
