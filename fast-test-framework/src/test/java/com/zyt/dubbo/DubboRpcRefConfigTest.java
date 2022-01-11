package com.zyt.dubbo;

import com.zyt.App;
import com.zyt.dubbo.api.model.User;
import com.zyt.dubbo.api.service.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class DubboRpcRefConfigTest {

    @Test
    public void getUser() {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("UserService");
        // 连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<UserService>();
        referenceConfig.setApplication(application);
        referenceConfig.setRegistry(registryConfig); // 多个注册中心可以用setRegistries()
        referenceConfig.setInterface(UserService.class);

        DubboBootstrap bootstrap = DubboBootstrap.getInstance().application(application).registry(registryConfig);
        bootstrap.reference(referenceConfig);
        bootstrap.start();
        User user = bootstrap.getCache().get(referenceConfig).findUserById(1);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getTel());
    }
}
