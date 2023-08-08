#!/usr/bin/env python
# coding=utf-8
# author: ijumper

from poco.drivers.android.uiautomation import AndroidUiautomationPoco
poco = AndroidUiautomationPoco(force_restart=False)


class BasePage(object):
    # tab页
    tab_chats = poco(text="微信")
    tab_contacts = poco(text="通讯录")
    tab_discover = poco(text="发现")
    tab_me = poco(text="我")

    # 切换tab操作
    def switch2chats(self):
        self.tab_chats.click()

    def switch2contacts(self):
        self.tab_contacts.click()

    def switch2discover(self):
        self.tab_discover.click()

    def switch2me(self):
        self.tab_me.click()


if __name__ == '__main__':
    pass