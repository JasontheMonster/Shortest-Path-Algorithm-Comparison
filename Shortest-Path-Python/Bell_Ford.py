from GraphAPI import Graph
from networkx.algorithms.shortest_paths import *
import networkx as nx 
import time 

'''Bellman_Ford solution of shortest path'''
class Bellman_Ford(object):


    def __init__(self, graph):
        #initialized graph input
        self.graph = graph
    def solver(self, source):
        dist = {}#create distance list 
        path = {}#create path tree
        for node in self.graph.bag:
            #set all the distance to source to be infinity
            dist[node] = float("inf")
            #set all the nodes' parent to be None
            path[node] = None
        #set diatance to the source to 0
        dist[source] = 0

        #iterating |V| -1 times to relax edges
        for i in range(1, len(self.graph.bag)):
            for node in self.graph.bag:
                for neighbor, weight in self.graph.adjacent[node]:
                    #relax edges and add path tree
                    if dist[neighbor] > dist[node] + weight:
                        dist[neighbor] = dist[node] + weight
                        path[neighbor] = node

        #detecting negative cycle
        for node in self.graph.bag:
            for neighbor, weight in self.graph.adjacent[node]:
                if dist[node] + weight < dist[neighbor]:
                    #if the edge is still failed to be relaxed, there is a negative cycle
                    print "Graph has negative cycle"
                    return None, None 

        return dist, path
                    
'''testing 
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
'''
