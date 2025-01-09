# Hash Maps

## About the pattern 

I'll transform this text into cleaner Markdown format while preserving the mathematical notations and emphasis:

### Hash Map Overview

A **hash map**, also known as a hash table, is a data structure that stores key-value pairs. It provides a way to 
efficiently map keys to values, allowing for quick retrieval of a value associated with a given key. Hash maps achieve 
this efficiency by using a hash function behind the scenes to compute an index (or hash code) for each key. 
This index determines where the corresponding value will be stored in an underlying array.

#### Core Hash Map Methods

- **Insert(key, value)**

    When a key-value pair is inserted into a hash map, the hash function computes an index based on the key. This index 
    is used to determine the location in the hash map where the value will be stored. Because different keys may hash to 
    the same index (collision), hash maps typically include a collision resolution strategy. Common methods include 
    chaining or open addressing. In the average case, inserting a key-value pair takes O(1) time, assuming the hash 
    function distributes keys uniformly across the array. However, in the worst case (when all the keys hash to the same 
    index), insertion can take up to O(n) time, where n is the number of elements in the hash map.


- **Search(key)**

    To retrieve a value from the hash map, the hash function is applied to the key to compute its index. Then, the value 
    stored at that index is returned. In the average case, searching for a value takes O(1) time. In the worst case, it 
    can take up to O(n) time due to resizing and handling collisions.


- **Remove(key)**

    Removing a key-value pair typically involves finding the index based on the key's hash and then removing the value 
    stored at that index. In the average case, removing a key-value pair takes O(1) time. In the worst case, it can 
    take up to O(n) time due to resizing and handling collisions.

# Problems 

- [Isomorphic Strings](./a03/README.md)