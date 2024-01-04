# Algorithms and Data Structures

This repository contains assignments and exercises focused on various aspects of algorithms and data structures. Below are the details of each assignment and their respective exercises.
## Contents
- [Assignment 1](#assignment-1)
- [Assignment 2](#assignment-2)
- [Assignment 3](#assignment-3)

## Assignment 1

### Exercise 1: Building a Hash Table (65 points)
**Objective:** To implement hash tables using chaining and open addressing, and compare their performance with multiplication and linear probing methods.
- **Tasks:**
  - Implement `probe` in `Open_Addressing` and `chain` in `Chaining` for hashing.
  - Develop `insertKey` method for both classes to insert a key and count collisions.
  - Create `removeKey` method in `Open_Addressing` for key removal and collision counting.
- **Submission:** Source files `Chaining.java` and `Open_Addressing.java`.
- **Notes:** Focus on collision handling and efficiency. Avoid using built-in Java hash tables.

### Exercise 2: Building a Disjoint Set (40 points)
**Objective:** Implement a disjoint set data structure with efficient union and find operations.
- **Tasks:**
  - Implement union by rank and path compression techniques.
  - Complete `find(int i)` and `union(int i, int j)` methods in `DisjointSets.java`.
- **Submission:** `DisjointSets.java`.

### Exercise 3: Vacuuming Ideas (Legos) (95 points)
**Objective:** Devise an algorithm to determine the maximum number of unique Lego pieces that can be vacuumed in order, starting from any room.
- **Tasks:**
  - Compute the maximum number of unique Lego sizes in a contiguous segment.
  - Account for constraints like Lego piece size (up to 10^9) and total number (up to one million).
- **Submission:** Implement the solution in `elements(int[] sizes)` function within `A1_Q3.java`.

## Assignment 2

### Exercise 1: Complete Search (30 points)
**Objective:** Create an algorithm to calculate the maximum score difference in a Lego-based board game.
- **Tasks:**
  - Implement the `game_recursion` function in `A2_Q1.java`.
  - The function should take a 2-D array representing a board and return the maximum score difference, adhering to the provided game rules.
- **Submission:** `A2_Q1.java`.

### Exercise 2: Dynamic Programming and Greedy Algorithm (20 points + 5 bonus points)
**Objective:** Evaluate if a greedy algorithm always provides an optimal solution for a specific coin system.
- **Tasks:**
  - Implement solutions using both dynamic programming and a greedy approach.
  - Determine the smallest value where the two approaches differ, or return −1 if they always coincide.
- **Submission:** `A2_Q2.java`, including the `change` function.

### Exercise 3: Greedy Algorithm for Homework Planning (20 points)
**Objective:** Develop a greedy algorithm to maximize the total weight of completed assignments.
- **Tasks:**
  - Organize homework assignments based on deadlines and weights.
  - Produce a homework plan indicating which assignments to complete in each time slot.
- **Submission:** Code in `HW_Sched.java`.

### Exercise 4: Divide and Conquer (30 points)
**Objective:** Calculate the minimum number of swaps needed to organize passengers in a line by priority.
- **Tasks:**
  - Implement the `swaps` function in `A2_Q4.java`.
  - The function should take an array of unique integers representing passenger priorities and return the minimum number of swaps, respecting arrival time and priority.
- **Submission:** `A2_Q4.java`.

## Assignment 3

### Exercise 1: Graph Algorithms (35 points)
**Objective:** Design an algorithm to find the minimum number of buildings Spider-Man must visit to escape a grid-based city within a given time.
- **Tasks:**
  - Implement the `find_exit` function in the provided Java template, considering movement rules and restrictions.
  - The function should take the time `t` and a `String[][] board` as parameters.
- **Submission:** Modified Java template.

### Exercise 2: Graph Algorithms (35 points)
**Objective:** Create an algorithm to calculate the total number of simpler Lego modules required to build complex ones.
- **Tasks:**
  - Complete the `num_pieces` function in the provided Java template.
  - The function receives an array `pieces` and a 2-D array `instructions` detailing module dependencies.
- **Submission:** Specified Java file.

### Exercise 3: Flow Network (30 points)
**Objective:** Implement the Ford-Fulkerson algorithm to calculate the Maximum Flow of a directed weighted graph.
- **Tasks:**
  - Complete the `fordfulkerson` and `pathDFS` methods in `FordFulkerson.java`.
  - The `pathDFS` method should find a path using Depth First Search (DFS) between source and destination nodes.
- **Submission:** `FordFulkerson.java` with the completed methods.
