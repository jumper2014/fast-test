# 前言
- test-flash是一个测试工具平台，可以帮助测试人员从页面上简化测试执行过程

## 目录说明
- flash-api 后台api服务
- flash-vue-admin 基于vuejs的前端代码目录
- flash-core 基础模块，包括工具类，dao，service，bean等内容

## 技术选型
- 核心框架：Spring Boot
- 数据库层：Spring data jpa
- 数据库连接池：Druid
- 缓存：Ehcache
- 前端：基于Vue.js的Element

## 包含的功能
test-flash包含了成熟的后台管理功能
- 部门管理
- 用户管理
- 角色管理
- 菜单管理：配置菜单功能
- 权限分配：为指定的角色配置特定的功能菜单
- 参数管理：维护系统参数，并缓存系统参数提供高效的读取
- 数据字典管理：配置维护数据字典
- 定时任务管理：编写、配置、执行定时任务
- 业务日志：通过注解的方式记录用户操作日志，并提供日志查询功能
- 登录日志：查看用户登录登出日志
- cms内容管理，配合flash-vue-h5提供了手机端内容展示系统
- 消息管理：配置消息模板，发送短信，邮件消息
- 工作流：流程定义，发起申请，待办任务


## 使用
- 克隆本项目
- 导入idea
- 创建数据库：web-flash
     ```sql
        CREATE DATABASE IF NOT EXISTS webflash DEFAULT CHARSET utf8 COLLATE utf8_general_ci; 
        CREATE USER 'webflash'@'%' IDENTIFIED BY 'webflash190602@ABC';
        GRANT ALL privileges ON webflash.* TO 'webflash'@'%';
        flush privileges;
        ```    
- 在开发环境中配置了系统启动后自动创建数据库和初始化数据，所以不需要开发人员手动初始化数据库
- 确保开发工具下载了lombok插件
- 修改flash-api中数据库连接配置
- 启动flash-api，访问http://localhost:8082/swagger-ui.html ， 保证api服务启动成功
- 进入flash-vue-admin目录
    - 运行 npm install --registry=https://registry.npm.taobao.org
    - 运行npm run dev
    - 启动成功后访问 http://localhost:9528 ,登录，用户名密码:admin/admin     


