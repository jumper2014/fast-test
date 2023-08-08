#!/usr/bin/env python
# coding=utf-8
# author: ijumper
# 获得当前目录结构,创建目录结构


import inspect
import os
import sys


def get_root_path():
    file_path = os.path.abspath(inspect.getfile(sys.modules[__name__]))
    parent_path = os.path.dirname(file_path)
    root_path = os.path.dirname(parent_path)
    return root_path


# const for path
ROOT_PATH = get_root_path()
GRAPHS_PATH = ROOT_PATH + "/graphs"
RESULTS_PATH = ROOT_PATH + "/results"
TOOLS_PATH = ROOT_PATH + "/tools"

