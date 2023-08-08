#!/usr/bin/env python
# coding=utf-8
# author: ijumper

from libs.pages.base_page_object import BasePage
from libs.pagefactory.pagefactory_support import callable_find_by as find_by
import unittest
import time

class ResultPage(BasePage):

    # page object definition
    search_box = find_by(id_="kw")

    # test steps
    def verify_keyword(self, keyword):
        time.sleep(2)
        assert self.search_box().get_attribute('value') == keyword
