#!/usr/bin/env python
# coding=utf-8
# author: ijumper

import unittest
from libs.pages.home_page import *
from libs.pages.result_page import *
from selenium import webdriver


class TestSearch(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Chrome()

    def testSearchOk(self):
        self.driver.get("https://www.baidu.com")
        HomePage(self.driver).search("selenium")
        ResultPage(self.driver).verify_keyword("selenium1")

    def tearDown(self):
        self.driver.close()




