#!/usr/bin/env python
# coding=utf-8
# author: ijumper

import unittest
from suites.search.test_search import *

if __name__ == "__main__":
    suite = unittest.TestSuite()
    suite.addTest(TestSearch('testSearchOk'))
    runner = unittest.TextTestRunner()
    runner.run(suite)