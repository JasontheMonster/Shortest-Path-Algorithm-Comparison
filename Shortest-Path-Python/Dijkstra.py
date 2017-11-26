from GraphAPI import Graph
from heapq import *
from networkx.algorithms import *
import networkx as nx 
import time 
class Dijkstra(object):


    def __init__(self, graph):
        self.graph = graph

    def solver(self, source):
        dist = {x: float("inf") for x in self.graph.bag}
        dist[source] = 0
        visted = []
        priorityQ = []
        path = {}
        for node in self.graph.bag:
            heappush(priorityQ, (dist[node], node))
            path[node] = None

        while priorityQ:
            d, node = heappop(priorityQ)
            visted.append(node)
            for neighbor, weight in self.graph.adjacent[node]:
                if neighbor not in visted: 
                    if dist[neighbor] > d + weight:
                        dist[neighbor] = d + weight
                        path[neighbor] = node 
                        heappush(priorityQ, (dist[neighbor], neighbor))
        return dist, path  


if __name__ == "__main__":

    graph = Graph()

    graph.addNode(1)
    graph.addNode(2)
    graph.addNode(3)


    graph.addWeightedEdge(1, 2, 5)
    graph.addWeightedEdge(2, 3, -10)
    graph.addWeightedEdge(1, 3, 2)


    
    solution = Dijkstra(graph)

    dist, path = solution.solver(1)
    print dist
    print path 


        


        

