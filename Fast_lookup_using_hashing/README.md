# Fast Lookup Using Hashing with Chaining

Hashing is a fundamental DSA concept used extensively in real-world systems
for **fast data access**. In backend applications, large datasets such as
user profiles, session information, or configuration settings require
efficient lookups.  

This repository demonstrates how to apply **hashing** for fast lookups
and introduces **collision handling using separate chaining**.

---

## Problem Scenario

Imagine a system that needs to:
- Retrieve user status based on user ID
- Handle thousands of users efficiently
- Ensure lookup performance does not degrade with scale

A naive approach using lists or arrays would require scanning elements,
resulting in **O(n)** time complexity, which is not acceptable for large datasets.

---

## Why Hashing?

Hashing maps keys (e.g. user IDs) to storage locations (buckets) using
a **hash function**, enabling **constant-time average lookup**.

Even with collisions (two keys mapping to the same bucket), we can maintain
efficient access using **separate chaining**, where each bucket holds a
linked list of entries.

---

## Compiling Java File
javac FastLookupWithChaining.java

## Run the Program
java FastLookupWithChaining

## Output
![alt text](<Screenshot 2026-01-31 223054.png>)

## Hash Table with Separate Chaining (Capacity = 5)

This table shows how user IDs are distributed across buckets using the hash function `key % 5`. Collisions are handled using separate chaining.

|**Bucket Index**|**Chained Entries (User ID → Status)**|
|--------------|-------------------------------------|
| 0            | *(empty)*                          |
| 1            | 101 → ACTIVE → 121 → BLOCKED → 111 → INACTIVE → 131 → ACTIVE → 141 → BLOCKED |
| 2            | 102 → INACTIVE → 112 → ACTIVE       |
| 3            | 103 → ACTIVE → 108 → ACTIVE         |
| 4            | 104 → BLOCKED                       |

- **Hash Function**: `userID % 5`
- **Collision Handling**: Separate chaining using linked lists
- **Longest Chain**: Bucket 1 with 5 entries

## Time and Space Complexity

- **Insertion**: Average O(1), Worst O(n)  
- **Lookup (get)**: Average O(1), Worst O(n)  
- **Building map for n users**: Average O(n), Worst O(n^2)  
- **Single search query**: Average O(1), Worst O(n)  

- **Space Complexity**: O(n + capacity) ≈ O(n)

## Real-World Usage
- Used in authentication systems for instant user status lookups.   
- Enables quick contact/profile retrieval in large databases.   
- Drives product inventory and pricing lookups in e-commerce.  
