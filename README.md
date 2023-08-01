## 项目介绍
`fast-test` 是自动化测试工具集合，帮你快速构建自己的自动化测试框架/工具/平台。


## 主要功能
### 工具介绍
| 名称                                                  | 描述                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [eladmin](./eladmin)                         | 基于eladmin的测试工具平台-后端                                |
| [eladmin-web](./eladmin-web)                         | 基于eladmin的测试工具平台-前端                                |
| [test-flash](./test-flash)                         | 基于web-flash的测试工具平台                                |
| [test-framework-testng-selenium-demo](./test-framework-testng-selenium-demo)       | 基于Testng+Selenium+PageObject的测试框架                             |
| [test-framework-allure-grpc-demo](./test-framework-allure-grpc-demo)       | 基于JUnit+Allure+Grpc的测试框架                             |
| [test-framework-junit-cucumber-demo](./test-framework-junit-cucumber-demo)       | 基于JUnit+Cucumber并且支持中文feature文件的测试框架                             |
| [test-framework-http-api-moco-demo](./test-framework-http-api-moco-demo)       | 基于JUnit/Testng的HTTP API测试框架, AUT使用MOCO                             |
| [test-framework-testng-cucumber-ui-demo](./test-framework-testng-cucumber-ui-demo)       | Testng+Cucumber+Selenium/Appium的UI测试框架                             |
| [aut-server](./aut-server)                         | AUT被测应用, 提供各类被测服务                                |
| [resource.md](./resource.md)                         | 环境资源指南文档                              |

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
- [感谢eladmin提供测试平台的管理后台功能支持](https://github.com/elunez/eladmin)
- [感谢web-flash提供测试平台的管理后台功能支持](https://github.com/enilu/web-flash)

### License
[Apache License, Version 2.0](https://opensource.org/licenses/Apache-2.0)

Copyright (c) 2021 ijumper