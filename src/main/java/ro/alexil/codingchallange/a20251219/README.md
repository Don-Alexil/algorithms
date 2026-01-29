# Reorder List

## Problem Statement

Given the head of a singly linked list, reorder the list as if it were folded on itself.

### Example

If the list is represented as follows:

```
L₀ → L₁ → L₂ → … → Lₙ₋₂ → Lₙ₋₁ → Lₙ
```

Reorder it to:

```
L₀ → Lₙ → L₁ → Lₙ₋₁ → L₂ → Lₙ₋₂ → …
```

### Requirements

- You don't need to modify the values in the list's nodes
- Only the links between nodes need to be changed

## Constraints

- The number of nodes in the list is in the range `[1, 500]`
- `-5000 ≤ Node.value ≤ 5000`
