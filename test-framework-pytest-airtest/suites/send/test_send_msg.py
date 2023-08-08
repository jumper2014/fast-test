#!/usr/bin/env python
# coding=utf-8
# author: ijumper

import pytest

from airtest.core.api import *
from libs.pages.page import *
from libs.utils.path import *
from libs.const.app import *
from libs.business.chats import *


def setup_function():
    # 自动初始化设备
    auto_setup(__file__)
    stop_app(wechat_package)


def teardown_function():
    stop_app(wechat_package)


def test_send_msg():
    start_app(wechat_package, activity=None)

    chats_page.btn_open.wait_for_appearance()
    if chats_page.btn_open.exists():
        print("start wechat succeed.")
    else:
        print("start wechat failed, quit.")
        return
    for i in range(5):
        send_msg_to("旺福", "你好")
