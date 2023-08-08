#!/usr/bin/env python
# coding=utf-8
# author: ijumper


from libs.pages.base import *


class ChatsPage(BasePage):
    # 按钮
    btn_search = poco("com.tencent.mm:id/r_")
    btn_open = poco("com.tencent.mm:id/rb")

    # 菜单
    menu_group_chat = poco(text="发起群聊")
    menu_add_friend = poco(text="添加朋友")
    menu_scan = poco(text="扫一扫")
    menu_pay = poco(text="收付款")
    menu_help = poco(text="帮助与反馈")

    # 发起群聊
    def open_group_chat(self):
        self.btn_open.click()
        self.menu_group_chat.click()

    # 添加朋友
    def open_add_friend(self):
        self.btn_open.click()
        self.menu_add_friend.click()

    # 扫一扫
    def open_scan(self):
        self.btn_open.click()
        self.menu_scan.click()

    # 收付款
    def open_pay(self):
        self.btn_open.click()
        self.menu_pay.click()

    # 发送消息
    def click_name(self, name):
        text_name = poco(text=name)
        text_name.click()


