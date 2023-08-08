#!/usr/bin/env python
# coding=utf-8
# author: ijumper

from libs.generator import *


if __name__ == '__main__':
    graphs = [
        ("ivis", 5),
        ("iviz", 6),
    ]

    for graph in graphs:
        print("="*30)
        print("Generate case for graph {0}".format(graph[0]))
        print("=" * 30)
        generator = Generator(graph[0], graph[1])
        generator.generate()