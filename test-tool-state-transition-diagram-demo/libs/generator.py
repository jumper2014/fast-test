#!/usr/bin/env python
# coding=utf-8
# author: ijumper

import os
from libs.path import *


class Generator(object):
    def __init__(self, graph, tries=10):
        self.graph = graph
        self.tries = tries

    def generate(self):
        steps_set = set()
        for i in range(self.tries):
            print("Start generate case round {0}".format(i+1))
            steps = list()
            graphml = "{0}/{1}/{1}.graphml".format(GRAPHS_PATH, self.graph)
            jar = "{0}/graphwalker-cli-3.4.2.jar".format(TOOLS_PATH)
            result = "{0}/{1}/{1}.txt".format(GRAPHS_PATH, self.graph)
            os.system('java -jar {0} offline -m {1} "random(edge_coverage(50))" > {2}'.format(jar, graphml, result))
            with open(result, "r") as f:
                for line in f.readlines():
                    line = line.strip()
                    _, step = line.split(":")
                    step = step.replace('"', '')
                    step = step.replace('}', '')
                    print("Case step is: {0}".format(step))
                    steps.append(step)
            steps_set.add(tuple(steps))

        print("*" * 30)
        print("Total generate {0} test case for graph {1}".format(len(steps_set), self.graph))
        print("*" * 30)
        cases = list(steps_set)
        for i in range(len(steps_set)):
            case_file = "{0}/{1}/{1}_case_{2}.txt".format(GRAPHS_PATH, self.graph, i+1)
            with open(case_file, "w") as f:
                print("-" * 5 + " case {0} ".format(i+1) + "-" * 5)
                case = cases[i]
                for step in case:
                    f.write(step+"\r")
                    print(step)