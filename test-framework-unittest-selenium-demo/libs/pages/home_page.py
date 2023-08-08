#!/usr/bin/env python
# author: ijumper
# page object and function for search page

from libs.pages.base_page_object import BasePage
from libs.pagefactory.pagefactory_support import callable_find_by as find_by


class HomePage(BasePage):

    # page object definition
    search_box = find_by(id_="kw")
    search_button = find_by(id_='su')

    # test steps
    def search(self, keywords):
        self.search_box().clear()
        self.search_box().send_keys(keywords)
        self.search_button().click()
