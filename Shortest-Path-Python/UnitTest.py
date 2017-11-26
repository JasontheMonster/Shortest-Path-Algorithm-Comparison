from GraphAPI import Graph
from Dijkstra import Dijkstra
from Bell_Ford import Bellman_Ford

import networkx as nx
import random 
import time
import matplotlib.pyplot as plt
import numpy as np




class UnitTest(object): 


    def __init__(self, n, m, negative = False):
        lowerbound = 0
        size = 100
        self.n = n
        self.m = m
        if negative: 
            lowerbound = -100
            size = 10

        self.test_list =[]

        for i in range(10):
            G = nx.gnm_random_graph(self.n, self.m, directed = True)
            for u, v in G.edges:
                G[u][v]['weight'] = random.uniform(lowerbound, 100)
            self.test_list.append(G)

        self.compare_list = []

        for test in self.test_list:
            g = Graph()
            for u, v in test.edges:
                g.addNode(u)
                g.addNode(v)
                g.addWeightedEdge(u, v, test[u][v]['weight'])
            self.compare_list.append(g)

    '''Testing '''
    #randomly generate 100 complete graph
    def correctness(self):
        boolean = True 
        '''test for correctness'''
        print "testing for correctness of Dijkstra..."
        for answer, my_graph in zip(self.test_list, self.compare_list):
            source = min(answer.nodes())
            length, path = nx.single_source_dijkstra(answer, source , weight = 'weight')
            my_solution = Dijkstra(my_graph)
            dist, path = my_solution.solver(source) 
            
            for k, v in dist.items():
                if v == float("inf"):
                    del dist[k] 
            boolean = boolean and dist == length

        if boolean:
            print "Dijkstra test passed"
        else: 
            print "No"

        print "testing for correctness of BF algorithm ..."
        for answer, my_graph in zip(self.test_list, self.compare_list):
            source = min(answer.nodes())
            length= nx.single_source_bellman_ford_path_length(answer, source , weight = 'weight')
            my_solution = Bellman_Ford(my_graph)
            dist, path = my_solution.solver(source) 
            
            for k, v in dist.items():
                if v == float("inf"):
                    del dist[k] 
            
            boolean = boolean and dist == length

        if boolean:
            print "Bellman_Ford test passed"
        else: 
            print "No"

    def negative(self):
        print "test for negative cycle"

        '''test for correctness'''
        self.count = 0
        for answer, my_graph in zip(self.test_list, self.compare_list):
            source = min(answer.nodes())
            d_solution = Dijkstra(my_graph)
            d_dist, path = d_solution.solver(source) 
            


            b_solution = Bellman_Ford(my_graph) 
            b_dist, path = b_solution.solver(source)

            if d_dist != b_dist:
                self.count+=1


    def performance(self, dijkstra = False, bellman_Ford = False, own = False):
        if dijkstra:
            self.answer_time = 0
            self.my_time =0
            for answer, my_graph in zip(self.test_list, self.compare_list):
                start = time.time()
                source = min(answer.nodes)
                length, path = nx.single_source_dijkstra(answer, source , weight = 'weight')
                self.answer_time += time.time() - start 

                my_start = time.time()
                d_solution = Dijkstra(my_graph)
                d_dist, path = d_solution.solver(source) 
                self.my_time += time.time() - my_start

        if bellman_Ford:
            self.answer_time = 0
            self.my_time =0
            for answer, my_graph in zip(self.test_list, self.compare_list):
                start = time.time()
                source = min(answer.nodes)
                length= nx.single_source_bellman_ford_path_length(answer, source , weight = 'weight')
                self.answer_time += time.time() - start 

                my_start = time.time()
                d_solution = Bellman_Ford(my_graph)
                dist, path = d_solution.solver(source) 
                self.my_time += time.time() - my_start
        if own:
            self.d_time =0
            self.b_time =0
            for answer, my_graph in zip(self.test_list, self.compare_list):
                start = time.time()
                source = min(answer.nodes)
                d_solution = Dijkstra(my_graph)
                d_dist, path = d_solution.solver(source) 
                self.d_time += time.time() - start 

                my_start = time.time()
                d_solution = Bellman_Ford(my_graph)
                dist, path = d_solution.solver(source) 
                self.b_time += time.time() - my_start




if __name__ == "__main__":

    t = []
    b = []
    for n in range(1, 101):
        m = n
        test = UnitTest(n, m)
        test.performance(dijkstra = True)
        t.append(test.my_time)
        b.append(test.answer_time)


    # evenly sampled time at 200ms intervals
    a  = range(1, 101)

    # red dashes, blue squares and green triangles
    plt.plot(a, t, 'r--', a, b, 'bs')
    plt.show()


    test = UnitTest()
    test.performance(dijkstra = True)
    print test.answer_time
    print test.my_time
    print 

    test.performance(bellman_Ford = True)
    print test.answer_time
    print test.my_time
    print 

    test.performance(own = True)
    print test.d_time
    print test.b_time
    print 

    test.correctness()

    testNegative = UnitTest(negative = True)
    testNegative.negative()
    print testNegative.count







