# Mini File System Navigator (Java)

This is a simulation of a basic file system structure, similar to what operating systems use internally.

In real systems like:
      - Linux
      - Microsoft Windows
      - Google Drive

Directories and files are organized in a hierarchical structure (Tree).
This project applies **DFS and BFS traversal techniques** on a tree structure to simulate file system operations.

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


## 🧠 Concepts Used

- Tree Data Structure
- Depth First Search (DFS)
- Breadth First Search (BFS)
- Recursion
- Queue (LinkedList implementation)
- Object-Oriented Programming (Java)


## 📂 Sample Structure

```
Root
 ├── Documents
 │    ├── Resume.pdf (120KB)
 │    └── Notes.txt (50KB)
 └── Photos
       └── 2025
```

## ⚙️ How It Works

### 🔎 DFS (Depth First Search)

**Used for:**
- Listing all files recursively
- Calculating total size of files inside folders

**Time Complexity:** O(N)

### 🌐 BFS (Breadth First Search)

**Used for:**
- Printing directory level-by-level
- Searching file efficiently across folders

**Time Complexity:** O(N)


## ▶️ How to Run

1. Clone the repository
2. Open in any Java IDE (IntelliJ / Eclipse / VS Code)
3. Run `FileSystemNavigator.java`
4. Output will be displayed in the console


## 💡 Why I Built This

While learning tree traversal in DSA, I wanted to understand how these concepts are actually used in real systems.

Instead of only solving LeetCode-style problems, this project helped me understand:
- How operating systems manage directories
- How recursion works in real applications
- How traversal algorithms scale in real-world scenarios


## 🚀 Future Improvements

- Add full file path support (`/Documents/Resume.pdf`)
- Implement delete file/folder feature
- Add command-line based interaction
- Add exception handling
- Convert into REST API version


## 📚 Learning Outcome

Through this project, I improved my understanding of:
- Applying DSA concepts to system design
- Writing structured and modular Java code
- Connecting theoretical knowledge with practical implementation