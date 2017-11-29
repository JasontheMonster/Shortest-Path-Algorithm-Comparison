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
        #create prioirty queue
        #Q<-makePQ()
        priorityQ = []
        #set distance from source to all the node as infinity
        #for each node u that is not s do: insert(Q,(u,infinity))
        dist = {x: float("inf") for x in self.graph.bag}
        #set distance to source to be 0
        #insert(Q,(s,0))
        dist[source] = 0
        #push all the nodes to priority queue and set the parent of them as None
        for node in self.graph.bag:
            heappush(priorityQ, (dist[node], node))
            path[node] = None
        #use visisted to keep track of nodes we visited 
        #X<-emptyset
        visited = []
        #create a path tree to resturn in the end
        path = {}
        
       

        
        #while queue is not empty
        #for i = 1 to |V| do
        while priorityQ:
            #extract node with minimum distance value
            #(v, dist(s, v)) = extractMin(Q)
            d, node = heappop(priorityQ)
            #add this node to visited set
            #X = X U {v}
            visited.append(node)
            #loop through neighbors of the current node
            #for each u in Adj(v) do
            for neighbor, weight in self.graph.adjacent[node]:
                #if neighbor has not been visited
                if neighbor not in visited: 
                    #relax the edge 
                    #decreaseKey(Q,(u,min(dist(s,u),dist(s,v)+l(v,u))))
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

        


        

