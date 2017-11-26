from GraphAPI import Graph
from networkx.algorithms.shortest_paths import *
import networkx as nx 
import time 


class Bellman_Ford(object):

    def __init__(self, graph):
        self.graph = graph
    def solver(self, source):
        dist = {}
        path = {}
        for node in self.graph.bag:
            dist[node] = float("inf")
            path[node] = None
        dist[source] = 0

        for i in range(1, len(self.graph.bag)):
            for node in self.graph.bag:
                for neighbor, weight in self.graph.adjacent[node]:
                    if dist[neighbor] > dist[node] + weight:
                        dist[neighbor] = dist[node] + weight
                        path[neighbor] = node

        for node in self.graph.bag:
            for neighbor, weight in self.graph.adjacent[node]:
                if dist[node] + weight < dist[neighbor]:
                    print "Graph has negative cycle"
                    return None, None 
        return dist, path
                    

if __name__ == "__main__":
    graph = Graph()

    graph.addNode(1)
    graph.addNode(2)
    graph.addNode(3)


    graph.addWeightedEdge(1, 2, 5)
    graph.addWeightedEdge(2, 3, -10)
    graph.addWeightedEdge(1, 3, 2)


    
    solution = Bellman_Ford(graph)

    dist, path =solution.solver(1)
    print dist
    print path 

