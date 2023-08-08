### 分层的微信App自动化框架
- 分层结构，分为UI元素层，业务操作层，测试用例层
- 测试工具基于网易出品的airtest，支持airtest和poco两种识别方法
- 底层的通用测试框架是pytest
- 目前支持android平台

### 目录结构如下
- libs/pages UI元素层
- libs/business 业务操作层
- libs/utils 工具函数
- suites/send 测试用例层


### 常用命令
- adb logcat -c  清logcat
- adb shell dumpsys window | grep tencent  查看微信包名
- python --capture=no 运行Pytest并且打印日志

### 安装
- pip install pocoui
- pip install -i https://pypi.tuna.tsinghua.edu.cn/simple pocoui

### 注意
- 第一次启动时会安装yosemite 是airtest的输入法
- 还会安装pocoservice:支撑poco操作的app
