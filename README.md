# Algorithms and Data Structures

Based on The Algorithm Design Manual by Steven S. Skiena.
Based on https://www.programiz.com/
Based on https://www.geeksforgeeks.org/

## Data Structures

### Contiguous (arrays) and Linked Data Structures 

Arrays: Constant-time access given the index, Space efficiency and Memory locality.

Linked Lists: Overflow on linked structures can never occur, Insertions and deletions are simpler and With large records, moving pointers is easier and faster than moving the items themselves.

### Stacks and Queues 

LIFO vs FIFO. Stacks and queues can be effectively implemented using either arrays or linked lists.

### Dictionaries 

Comparing implementations: n - the number of elements currently in the array

| |Array Unsorted|Array Sorted|Linked List Singly unsorted|Linked List Double unsorted|Linked List Singly sorted|Linked List Double sorted|
|----|----|----|----|----|----|----|
|Search(L, k)|O(n)|O(log n)|O(n)|O(n)|O(n)|O(n)|
|Insert(L, x)|O(1)|O(n)|O(1)|O(1)|O(n)|O(n)|
|Delete(L, x)|O(1)|O(n)|O(n)|O(1)|O(n)|O(1)|
|Successor(L, x)|O(n)|O(1)|O(n)|O(n)|O(1)|O(1)|
|Predecessor(L, x)|O(n)|O(1)|O(n)|O(n)|O(n)|O(1)|	
|Minimum(L)|O(n)|O(1)|O(n)|O(n)|O(1)|O(1)|
|Maximum(L)|O(n)|O(1)|O(n)|O(n)|O(1)|O(1)|

### Binary Search Trees (Balanced search trees):

- Search runs in O(h) time, where h denotes the height of the tree.
- Traversal runs in O(n) time, where n denotes the number of nodes in the tree.
- Insertion: Allocating the node and linking it in to the tree is a constant-time operation after the search has been performed in O(h) time.
- Deletion: Every deletion requires the cost of at most two search operations, each taking O(h) time where h is the height of the tree, plus a constant amount of pointer manipulation.

### Priority Queues

### Hashing

Use the value of our hash function (maps keys to integers) as an index into an array, and store our item at that position.
	
Collision resolution: Chaining vs open addressing.

Hash table with chaining (m buckets and n elements):

| |Expected|Worst case|
|----|----|----|
|Search(L, k)|O(n/m)|O(n)|
|Insert(L, x)|O(1)|O(1)|
|Delete(L, x)|O(1)|O(1)|
|Successor(L, x)|O(n+m)|O(n+m)|
|Predecessor(L, x)|O(n+m)|O(n+m)|		
|Minimum(L)|O(n+m)|O(n+m)|
|Maximum(L)|O(n+m)|O(n+m)|
