# Kth Largest Element in a Stream

Try to solve the **Kth Largest Element in a Stream** problem.

---

## Problem Statement

Given an infinite stream of integers (sorted or unsorted) `nums`, design a class to find the **k-th** largest element in the stream.

**Note:** It is the **k-th** largest element in the sorted order, not the **k-th** distinct element.

---

## Class Design

The class should have the following methods and functionality:

1. **`Init(nums, k)`**:
    - Initializes the class with an array of integers `nums` and an integer `k`.

2. **`Add(value)`**:
    - Takes an integer `value`, appends it to the stream, and returns the element representing the **k-th** largest element in the stream.

---

## Constraints

- `1 <= k <= 10^3`
- `0 <= nums.length <= 10^3`
- `-10^3 <= nums[i] <= 10^3`
- `-10^3 <= value <= 10^3`
- At most \( 10^3 \) calls will be made to `Add`.
- It is guaranteed that there will be at least `k` elements in the array when you search for the **k-th** largest element.
