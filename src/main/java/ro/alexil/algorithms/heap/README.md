# Top K Elements Pattern

## Overview
The Top K Elements pattern is a technique for efficiently finding K specific elements from a dataset, commonly used for 
finding largest, smallest, or most/least frequent elements in unsorted collections.

## Efficiency
- Traditional sorting approach: O(nlog(n)) + O(k)
- Top K pattern approach: O(nlog(k))

## Implementation Using Heaps
A heap is ideal for tracking K smallest/largest elements:
- Use max heap for finding smallest elements
- Use min heap for finding largest elements

## Algorithm Steps
1. Initialize Heap
    - Insert first K elements into the heap
    - Use min heap for largest elements
    - Use max heap for smallest elements

2. Process Remaining Elements
    - For min heap: Replace top element if current element is larger
    - For max heap: Replace top element if current element is smaller

## Time Complexity
- Heap operations: O(log(k))
- Processing n elements: O(nlog(k))
- More efficient than full sorting when k < n


## Problems 

- [Kth Largest element in a strea](./a01/README.md)
- [Reorganize String](./a02/README.md)
