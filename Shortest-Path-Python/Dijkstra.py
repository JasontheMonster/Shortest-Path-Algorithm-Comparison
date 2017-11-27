from GraphAPI import Graph
from heapq import *
from networkx.algorithms import *
import networkx as nx 
import time 

class Dijkstra(object):
    '''Dijkstra solution of shortest path'''

    def __init__(self, graph):
        #initialize the graph input
        self.graph = graph

    def solver(self, source):
        #set distance from source to all the node as infinity
        dist = {x: float("inf") for x in self.graph.bag}
        #set distance to source to be 0
        dist[source] = 0
        #use visisted to keep track of nodes we visited 
        visited = []
        #create prioirty queue
        priorityQ = []
        #create a path tree
        path = {}

        #push all the nodes to priority queue and set the parent of them as None
        for node in self.graph.bag:
            heappush(priorityQ, (dist[node], node))
            path[node] = None

        #while queue is not empty
        while priorityQ:
            #extract node with minimum distance value
            d, node = heappop(priorityQ)
            #add this node to visited set
            visited.append(node)
            #loop through neighbors of the current node
            for neighbor, weight in self.graph.adjacent[node]:
                #if neighbor has not been visited
                if neighbor not in visited: 
                    #relax the edge 
                    if dist[neighbor] > d + weight:
                        dist[neighbor] = d + weight
                        #set the parent of neighbor to be node
                        path[neighbor] = node 
                        #push the neighbor to priority queue, which decrease key
                        heappush(priorityQ, (dist[neighbor], neighbor))
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


    
    solution = Dijkstra(graph)

    dist, path = solution.solver(1)
    print dist
    print path 

'''

        


        

