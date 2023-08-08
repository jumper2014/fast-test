#!/usr/bin/env python
# author: ijumper
# base page class

from selenium.webdriver.common.action_chains import ActionChains
import time


class BasePage(object):
    def __init__(self, driver, base_url='http://www.baidu.com'):
        self._driver = driver
        self.base_url = base_url
        self.timeout = 30

    # def find_element(self, *loc):
    #     return self.browser.find_element(*loc)

    def visit(self, url):
        self._driver.get(url)

    def hover(self, element):
        ActionChains(self._driver).move_to_element(element).perform()
        # I don't like this but hover is sensitive and needs some sleep time
        time.sleep(5)

    @staticmethod
    def method_missing(what):
        print("No %s here!" % what)
