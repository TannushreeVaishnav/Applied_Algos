# Mini File System Navigator 

This is a simulation of a basic file system structure, similar to what operating systems use internally.

In real systems like:
- Linux
- Microsoft Windows
- Google Drive

Directories and files are organized in a hierarchical structure (Tree).
This file applies **DFS and BFS traversal techniques** on a tree structure to simulate file system operations.

The goal of this file was to connect Data Structures (Binary Trees / Traversals) with real-world system design concepts instead of solving only textbook problems.

## Objective

- Represent folders and files using a Tree structure
- Implement DFS for recursive traversal
- Implement BFS for level-wise traversal
- Apply traversal algorithms to practical use cases

## Features Implemented

- Create folders
- Add files with size
- List all files using DFS
- Calculate total storage used (DFS)
- Level order directory traversal (BFS)
- Search for a file using BFS

## Concepts Used

- Tree Data Structure
- Depth First Search (DFS)
- Breadth First Search (BFS)
- Recursion
- Queue (LinkedList implementation)
- Object-Oriented Programming (Java)


## Sample Structure

```
Root
 ├── Documents
 │    ├── Resume.pdf (120KB)
 │    └── Notes.txt (50KB)
 └── Photos
       └── 2025
             └── Trip.jpg (300KB)
```

##  Working

### DFS (Depth First Search)

**Used for:**
- Listing all files recursively
- Calculating total size of files inside folders

**Time Complexity:** O(N)

### BFS (Breadth First Search)

**Used for:**
- Printing directory level-by-level
- Searching file efficiently across folders

**Time Complexity:** O(N)
## Output
<img width="1331" height="850" alt="Screenshot 2026-02-27 204852" src="https://github.com/user-attachments/assets/3a12eef6-f23f-44e3-b1d3-250853b45a07" />



## Future Improvements

- Add full file path support (`/Documents/Resume.pdf`)
- Add exception handling
- Convert into REST API version
