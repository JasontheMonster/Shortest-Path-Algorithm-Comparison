from GraphAPI import Graph
from networkx.algorithms.shortest_paths import *
import networkx as nx 
import time 


class Bellman_Ford(object):

    def __init__(self, graph):
        self.graph = graph
        self.dist = {}
        self.path = {}
    def solver(self, source):
        for node in self.graph.bag:
            self.dist[node] = float("inf")
            self.path[node] = None
        self.dist[source] = 0

        for i in range(1, len(self.graph.bag)):
            for node in self.graph.bag:
                for neighbor, weight in self.graph.adjacent[node]:
                    if self.dist[neighbor] > self.dist[node] + weight:
                        self.dist[neighbor] = self.dist[node] + weight
                        self.path[neighbor] = node

        for node in self.graph.bag:
            for neighbor, weight in self.graph.adjacent[node]:
                if self.dist[node] + weight < self.dist[neighbor]:
                    print "Graph has negative cycle"
                    self.dist = {}
                    self.path = {}

'''for testing 

if __name__ == "__main__":
    graph = Graph()

    graph.addNode(1)
    graph.addNode(2)
    graph.addNode(3)
    graph.addNode(4)
    graph.addNode(5)
    graph.addNode(6)

    graph.addWeightedEdge(1, 2, 7)
    graph.addWeightedEdge(1, 3, 9)
    graph.addWeightedEdge(1, 6, 14)
    graph.addWeightedEdge(2, 3, 10)
    graph.addWeightedEdge(2, 4, 15)
    graph.addWeightedEdge(3, 4, 11)
    graph.addWeightedEdge(3, 6, 2)
    graph.addWeightedEdge(4, 5, 6)
    graph.addWeightedEdge(6, 5, 9)


    G = nx.DiGraph()
    for i in range(6):
        G.add_node(i+1)

    G.add_edge(1, 2, weight = 7)
    G.add_edge(1, 3, weight = 9)
    G.add_edge(1, 6, weight = 14)
    G.add_edge(2, 3, weight = 10)
    G.add_edge(2, 4, weight = 15)
    G.add_edge(3, 4, weight = 11)
    G.add_edge(3, 6, weight = 2)
    G.add_edge(4, 5, weight = 6)
    G.add_edge(6, 5, weight = 9)

    
    answer_time = time.time()
    path = nx.single_source_bellman_ford_path_length(G, 1)

    print time.time() - answer_time
    print path

    my_time = time.time()
    solution = Bellman_Ford(graph)

    solution.solver(1)
    print time.time() - my_time
    print solution.dist
    print solution.path 

    '''
