## 项目简介

`fast-test` 是一个开箱即用的自动化测试工具项目，帮你快速构建自己的自动化测试框架，自动化测试工具，自动化测试平台。

## 开发环境

- **JDK 1.8 +**
- **Maven 3 +**
- **IntelliJ IDEA Community 2021.2.2 +** 
- **Visual Studio Code 1.63.2 +**

## 主要功能

### 各 Module 介绍

| Module 名称                                                  | Module 介绍                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [test-flash](./test-flash)                         | 基于web-flash的测试工具平台                                |
| [fast-test-framework](./fast-test-framework)       | 各种自动化测试框架                                |
| [aut-server](./aut-server)                         | AUT被测应用, 提供各类被测服务                                |

### 开发计划及进度

#### 测试工具示例
- 测试文件生成
    - 生成指定格式的txt文件(批量文件) - 完成
- 文件传输
    - 上传文件到web服务器 - 完成
    - 从web服务器下载文件到本地 - 完成
    - 上传文件到远程应用服务器
- 数据库操作
    - 数据的增删改查 - 完成
    - 数据导出成Excel
    - 执行指定的SQL - 完成
- 测试用例
    - 测试用例转换，XMind到Excel 
    - 测试用例转换, 百度脑图km到Excel - 完成
- 远程控制
    - 触发远程服务器上程序执行
- 对比工具
    - Json格式化工具页面

#### 测试框架示例
- RPC接口测试 - 完成
- 集成Allure测试报告
- 常见测试相关库使用示例
  - AssertJ - 完成
  - HttpClient - 完成
  - OkHttp - 完成
  - RestAssured - 完成
  - RestTemplate - 完成
- 常见Java库使用示例
  - Quartz - 完成
  - Ehcache - 完成
  - 读取yaml文件 - 完成

### 感谢
- [感谢web-flash提供管理后台功能支持](https://github.com/enilu/web-flash)

### License
[Apache License, Version 2.0](https://opensource.org/licenses/Apache-2.0)

Copyright (c) 2021 旺福