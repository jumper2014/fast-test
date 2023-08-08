#!/usr/bin/env python
# coding=utf-8
# author: ijumper

import time
import pytest

from airtest.core.api import *
from libs.pages.page import *
from libs.utils.path import *
from libs.const.app import *


def setup_function():
    # 自动初始化设备
    auto_setup(__file__)
    stop_app(wechat_package)


def teardown_function():
    stop_app(wechat_package)


def test_start_app():
    android_device = connect_device('Android://')
    devs = device()
    print(devs)
    print(devs.list_app(third_only=True))

    # start the app
    start_launch_time = time.time()
    start_app(wechat_package, activity=None)
    # poco.wait_stable()
    # time.sleep(5)

    chats_page.btn_open.wait_for_appearance()

    snapshot(SNAPSHOTS_PATH+"/wechat.png")

    if chats_page.btn_add.exists():
        print("start wechat succeed.")
    else:
        print("start wechat failed, quit.")
        return

    chats_page.switch2contacts()
    chats_page.switch2discover()
    chats_page.switch2me()
    chats_page.switch2chats()