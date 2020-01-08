# Algorithms and Data Structures

Based on The Algorithm Design Manual by Steven S. Skiena.
Based on https://www.programiz.com/
Based on https://www.geeksforgeeks.org/

## Graph Data Structure

Collection of nodes that have data and are connected to other nodes.

A graph G = (V, E) consists of a set of vertices V together with a set E of vertex pairs or edges.

The key to solving many algorithmic problems is to think of them in terms of graphs.

**Types**

1. Undirected vs. Directed
2. Weighted vs. Unweighted
3. Simple vs. Non-simple
4. Sparse vs. Dense
5. Cyclic vs. Acyclic

**Representation**

1. *Adjacency Matrix*: 2D array of V x V vertices. Each row and column represent a vertex. 
If the value of any element a[i][j] is 1, it represents that there is an edge connecting vertex i and vertex j.
                     
2. *Adjacency List*: An array of linked list.
The index of the array represents a vertex and each element in its linked list represents the other vertices that form an edge with the vertex.
Adjacency lists are the right data structure for most applications of graphs.

## Graph Traversal Algorithms

Recursive algorithms for searching all the vertices of a graph or tree data structure.

### BFS (Breadth First Traversal/Search)

1. Start by putting any one of the graph's vertices at the back of a **queue**.
2. Take the front item of the queue and add it to the visited list.
3. Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the back of the queue.
4. Keep repeating steps 2 and 3 until the queue is empty.

### DFS (Depth First Traversal/Search)

1. Start by putting any one of the graph's vertices on top of a **stack**.
2. Take the top item of the stack and add it to the visited list.
3. Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the top of stack.
4. Keep repeating steps 2 and 3 until the stack is empty.

## Spanning Tree

Sub-graph of an undirected (edges do not point in any direction ie bidirectional) and a connected (there is always a path from a vertex to any other vertex) graph, which includes all the vertices of the graph having a minimum possible number of edges. 

If a vertex is missed, then it is not a spanning tree.

The edges may or may not have weights assigned to them.

**Minimum Spanning Tree**

Spanning tree in which the sum of the weight of the edges is as minimum as possible.

## Minimum Spanning Tree (MST) Algorithms

### Prim's Algorithm

Greedy algorithm which finds the local optimum in the hopes of finding a global optimum.

1. Initialize the minimum spanning tree with a vertex chosen at random.
2. Find all the edges that connect the tree to new vertices, find the minimum and add it to the tree
3. Keep repeating step 2 until we get a minimum spanning tree

### Kruskal's Algorithm

Greedy algorithm which finds the local optimum in the hopes of finding a global optimum.

1. Sort all the edges from low weight to high
2. Take the edge with the lowest weight and add it to the spanning tree. If adding the edge created a cycle, then reject this edge.
    - Uses Union Find to detect a cycle.
    - When the 2 vertices of an edge have the same root in the Union Find structure, they form a cycle.
3. Keep adding edges until we reach all vertices.

#### Disjoint Set (Union Find) - Detect Cycle

Data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.

|Set Index (nodes)|Parent|
|----|----|
|0|0|
|1|0|
|2|0|
|3|1|
|4|2|
|5|3|

1. Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.
    - Path Compression: Every time a node is visited, it can be changed to have the root as parent.
2. Union: Join two subsets into a single subset.
    - Union by Rank: The idea is to always attach the smaller depth tree under the root of the deeper tree.
    
## Dijkstra's Algorithm

Finds the shortest path between any two vertices of a graph. 
Differs from minimum spanning tree because the shortest distance between two vertices might not include all the vertices of the graph.

1. Start with a weighted graph.
2. Choose a starting vertex and assign infinity path values to all other vertices.
3. Update the path length (to the source vertex from which minimum path is calculated) for all the adjacent vertices if the existing length on the vertex is NOT less.
4. Avoid updating path lengths of already visited vertices.
5. After each iteration, the unvisited vertex with least patch length is picked.
6. Repeat until all the vertices have been visited.

## Floyd-Warshall Algorithm

- Finds the shortest path between all the pairs of vertices in a weighted graph. 
- Works for both the directed and undirected weighted graphs. 
- Does not work for the graphs with negative cycles (where the sum of the edges in a cycle is negative).

From: https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm

1. Prior to the first recursion of the outer loop, labeled k = 0 above, the only known paths correspond to the single edges in the graph.
2. At k = 1, paths that go through the vertex 1 are found. 
3. At k = 2, paths going through the vertices {1,2} are found. 
4. At k = 3, paths going through the vertices {1,2,3} are found. 
5. Finally, at k = 4, all shortest paths are found.

## Bellman Ford's Algorithm

Similar to Dijkstra's algorithm but it can work with graphs in which edges can have negative weights.

1. Initialize distances from source to all vertices as infinite and distance to source itself as 0.
2. Calculate shortest distances. 
    1. Go through all edges and add distances based on weight.
    2. First iteration might not be able to add distances to all vertices as only origin is initialised to 0.
    3. Repeat for |V|-1 times where |V| is the number of vertices in given graph.

After processing all edges |V|-1 times, the shortest paths will be in place.