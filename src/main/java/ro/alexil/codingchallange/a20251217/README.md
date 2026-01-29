# Problem: Candy

## Statement

You are given an array `ratings`, where `ratings[i]` represents the rating of the *i-th* child standing in a line.

Your task is to distribute candies to each child based on the following rules:

1. Every child must receive **at least one candy**.
2. Children with a **higher rating** must receive **more candies than their immediate neighbors**.

Determine the **minimum total number of candies** you must distribute to satisfy these conditions.

## Constraints

- `1 ≤ ratings.length ≤ 1000`
- `0 ≤ ratings[i] ≤ 1000`
