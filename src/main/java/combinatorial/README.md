# Algorithms and Data Structures

Based on The Algorithm Design Manual by Steven S. Skiena.
Based on https://www.programiz.com/
Based on https://www.geeksforgeeks.org/

## Combinatorial Search

### Backtracking

Backtracking is an algorithmic-technique for solving problems recursively by trying to build a solution incrementally, 
one piece at a time, removing those solutions that fail to satisfy the constraints of the problem at any point of time 
(by time, here, is referred to the time elapsed till reaching any level of the search tree).

Given an instance of any computational problem _P_ and data _D_ corresponding to the instance, all the constraints that need to be satisfied in order to solve the problem are represented by _C_. 

A backtracking algorithm will then work as follows:

The Algorithm begins to build up a solution, starting with an empty solution set _S_. **S = {}**

1. Add to _S_ the first move that is still left (All possible moves are added to _S_ one by one). This now creates a new sub-tree _s_ in the search tree of the algorithm.
2. Check if _S+s_ satisfies each of the constraints in _C_.
    - If Yes, then the sub-tree _s_ is “eligible” to add more “children”.
    - Else, the entire sub-tree _s_ is useless, so recurs back to step 1 using argument _S_.
3. In the event of “eligibility” of the newly formed sub-tree _s_, recurs back to step 1, using argument _S+s_.
4. If the check for _S+s_ returns that it is a solution for the entire data _D_. Output and terminate the program. 
    - If not, then return that no solution is possible with the current _s_ and hence discard it.
    
## Dynamic Programming

Dynamic Programming is mainly an optimization over plain recursion. Wherever we see a recursive solution that has repeated calls for same inputs, 
we can optimize it using Dynamic Programming. The idea is to simply store the results of subproblems, so that we do not have to re-compute them 
when needed later. This simple optimization reduces time complexities from exponential to polynomial.