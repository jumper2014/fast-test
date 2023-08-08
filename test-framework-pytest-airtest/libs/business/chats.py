#!/usr/bin/env python
# coding=utf-8
# author: ijumper


from libs.pages.page import *
from airtest.core.api import *
from libs.utils.path import TEMPLATE_PATH


def send_msg_to(name, msg):
    chats_page.click_name(name)
    dialog_page.text_input.click()
    text(msg)
    touch(Template(TEMPLATE_PATH + "/button/tpl_dialog_send_btn.png", record_pos=(0.390, 0.110), resolution=(1080, 2340)))
    # dialog_page.btn_send.click()
    dialog_page.btn_back.click()


if __name__ == '__main__':
    pass