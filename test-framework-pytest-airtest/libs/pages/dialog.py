#!/usr/bin/env python
# coding=utf-8
# author: ijumper

from libs.pages.base import *

class DialogPage(object):

    btn_back = poco("com.tencent.mm:id/ls")

    text_input = poco("com.tencent.mm:id/aqd")

    btn_send = poco(text="发送")