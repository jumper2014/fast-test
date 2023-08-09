## 关于fast-test
- `fast-test`是测试工具的集合，初衷是为了解决重复工作(操作数据库,操作文件等)占用测试人员大量时间精力的问题。通过将人工操作转变为半自动化甚至全自动化，显著改善测试人员的工作环境，从而使其能够充分发挥脑力输出的潜力。  
- `fast-test`还包含各种自动化测试框架的示例，帮助测试人员快速构建自己的自动化测试项目。  
- 欢迎点赞，收藏！ （如需自动化测试相关的项目定制开发，可联系 ijumper@163.com ）

## 工具介绍
| 名称                                                  | 描述                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [fastadmin](./fastadmin)                         | 基于eladmin的测试工具平台后端 - Java                                |
| [fastadmin-web](./fastadmin-web)                         | 基于eladmin的测试工具平台前端 - Vue                             |
| [test-framework-allure-grpc-demo](./test-framework-allure-grpc-demo)       | 基于Java JUnit+Allure+Grpc的接口测试框架                             |
| [test-framework-ddt-selenium-demo](./test-framework-ddt-selenium-demo)       | 基于Java TestNg+Selenium+Excel的UI数据驱动测试框架,测试用例和页面元素用表格管理                             |
| [test-framework-http-api-moco-demo](./test-framework-http-api-moco-demo)       | 基于Java JUnit/TestNg的HTTP接口测试框架, AUT使用MOCO框架生成Mocker                             |
| [test-framework-junit-cucumber-demo](./test-framework-junit-cucumber-demo)       | 基于Java JUnit+Cucumber并且支持中文feature文件的BDD测试框架                             |
| [test-framework-junit-rpc-demo](./test-framework-junit-rpc-demo)       | 基于Java JUnit+Dubbo RPC的接口测试框架                             |
| [test-framework-pytest-airtest-demo](./test-framework-pytest-airtest-demo)       | 基于Python pytest+AirTest的UI测试框架                             |
| [test-framework-testng-cucumber-ui-demo](./test-framework-testng-cucumber-ui-demo)       | 基于Java TestNg+Cucumber+Selenium/Appium的UI测试框架                             |
| [test-framework-testng-selenium-demo](./test-framework-testng-selenium-demo)       | 基于Java TestNg+Selenium+PageObject的UI测试框架                             |
| [test-framework-unittest-selenium-demo](./test-framework-unittest-selenium-demo)       | 基于Python unittest+Selenium+PageObject的UI测试框架                             |
| [test-tool-state-transition-diagram-demo](./test-tool-state-transition-diagram-demo)       | 基于Python 状态转换图自动生成测试用例的工具                             |
| [test-flash](./test-flash)                         | 基于web-flash的测试工具平台 - Java                           |
| [resource.md](./doc/md/resource.md)                         | 环境资源指南文档                              |

## FastAdmin测试平台功能展示
- 平台登录  
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/login.PNG)
- 后台管理  
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/index.PNG)
- 用户管理
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/user.PNG)
- 角色管理
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/role.PNG)
- 部门管理
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/dept.PNG)
- 菜单管理
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/menu.PNG)
- 增删改查示例  
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/curd.PNG)
- 上传百度脑图转Excel下载  
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/km2excel.PNG)
- 数据库操作示例  
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/lockuser.PNG)
- 生成批量文件示例
![alt text](https://github.com/jumper2014/fast-test/blob/main/doc/image/fastadmin/batch.PNG)

#### 测试工具示例
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
- [感谢eladmin提供测试平台的管理功能支持](https://github.com/elunez/eladmin)
- [感谢web-flash提供测试平台的管理功能支持](https://github.com/enilu/web-flash)

### License
[Apache License, Version 2.0](https://opensource.org/licenses/Apache-2.0)

Copyright (c) 2021 ijumper
