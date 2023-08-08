#!/usr/bin/env python
# coding=utf-8
# author: ijumper

import time


def wclick(obj, tries=5):
    for i in range(5):
        obj.click()
        time.sleep(0.2)

if __name__ == '__main__':
    pass