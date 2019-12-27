# Algorithms and Data Structures

Based on The Algorithm Design Manual by Steven S. Skiena.
Based on https://www.programiz.com/

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

## Algorithms

### InsertionSort

Places an unsorted element at its suitable place in each iteration.

**Complexity: O(n2)**

### SelectionSort

Selects the smallest element from an unsorted list in each iteration and places that element at the beginning of the unsorted list.

**Complexity: O(n2)**

### BubbleSort

1. Compares the adjacent elements and swaps their positions if they are not in the intended order.
2. After each iteration, the largest element among the unsorted elements is placed at the end.
3. In each iteration, the comparison takes place up to the last unsorted element.

**Complexity: O(n2)**

### HeapSort

1. Builds a max-heap (or min-heap) structure:
	1. Complete binary tree (every level must be completely filled and all the leafs must lean towards the left)
	2. If the index of any element in the array is i, the element in the index 2i+1 will become the left child and element in 2i+2 index will become the right child. Also, the parent of any element at index i is given by the lower bound of (i-1)/2.
	3. All nodes in the tree follow the property that they are greater than their children i.e. the largest element is at the root and both its children are smaller than the root and so on. Such a heap is called a max-heap. If instead all nodes are smaller than their children, it is called a min-heap.

2. Process:
    1. Since the tree satisfies Max-Heap property, then the largest item is stored at the root node.
	2. Remove the root element and put at the end of the array (nth position)
	3. Put the last item of the tree (heap) at the vacant place.
	4. Reduce the size of the heap by 1 and heapify the root element again so that we have highest element at root.
	5. The process is repeated until all the items of the list is sorted.

**Complexity: O(n log n)**	

### MergeSort 
	
1. Divide and Conquer
2. Process:
	1. Sort an array A. A subproblem would be to sort a sub-section of this array starting at index p and ending at index r, denoted as A[p..r].
	2. Divide: If q is the half-way point between p and r, then we can split the subarray A[p..r] into two arrays A[p..q] and A[q+1, r].
	3. Conquer: In the conquer step, we try to sort both the subarrays A[p..q] and A[q+1, r]. If we haven't yet reached the base case, we again divide both these subarrays and try to sort them.
	4. Combine: When the conquer step reaches the base step and we get two sorted subarrays A[p..q] and A[q+1, r] for array A[p..r], we combine the results by creating a sorted array A[p..r] from two sorted subarrays A[p..q] and A[q+1, r]

**Complexity: O(n log n)**

### QuickSort

1. Divide and Conquer
2. Process:
	1. Divide: The array is divided into subparts taking pivot as the partitioning point. The elements smaller than the pivot are placed to the left of the pivot and the elements greater than the pivot are placed to the right.
	2. Conquer: The left and the right subparts are again partitioned using the by selecting pivot elements for them. This can be achieved by recursively passing the subparts into the algorithm.
	3. Combine: This step does not play a significant role in quicksort. The array is already sorted at the end of the conquer step.

**Complexity: O(n log n) - Worst O(n2)**

### BucketSort

1. Sorts the elements by first dividing the elements into several groups called buckets.
    - The elements inside each bucket are sorted using any of the suitable sorting algorithms or recursively calling the same algorithm.
2. The process of bucket sort can be understood as scatter-gather approach.
    - The elements are first scattered into buckets then the elements of buckets are sorted. Finally, the elements are gathered in order.

**Complexity: Average O(n) - Worst O(n2)**

### ShellSort

1. Generalized version of insertion sort.
2. Elements at a specific interval are sorted. The interval between the elements is gradually decreased based on the sequence used.
3. Original sequence: N/2 , N/4 , …, 1

Eg: ```13 14 94 33 82 25 59 94 65 23 45 27 73 25 39 10```

If we start with gap 5 we have:
```
 13 14 94 33 82
 25 59 94 65 23
 45 27 73 25 39
 10
```

Every column is ordered and we get:
```
 10 14 73 25 23
 13 27 94 33 39
 25 59 94 65 82
 45
```

Then the gap is reduced and we do the same until the gap is 1 (simple InsertionSort but with plenty of items in its final position).

**Complexity: Average O(n log n) - Worst O(n2)**

### CountingSort

Sorts the elements of an array by counting the number of occurrences of each unique element in the array. 
The count is stored in an auxiliary array and the sorting is done by mapping the count as an index of the auxiliary array.

### RadixSort

1. sorts the elements by first grouping the individual digits of same place value. 
2. Then, sort the elements according to their increasing/decreasing order.

Eg: 
- Suppose, we have an array of 8 elements. 
- First, we will sort elements based on the value of the unit place. 
- Then, we will sort elements based on the value of the tenth place. 
- This process goes on until the last significant place.