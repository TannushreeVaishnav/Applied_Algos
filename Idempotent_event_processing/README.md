# Idempotent Event Processing in Payment Systems

# Overview
In real-world payment systems, the same transaction event can be received multiple times due to network errors, timeouts or temporary failures.  
If duplicate events are processed again, it can lead to issues like **double charging** or **incorrect transaction states**.

This project is a **simple simulation** of how payment systems handle such duplicate events using the concept of **idempotent processing**.  
The goal is to apply a **core Data Structures & Algorithms (DSA) concept — in-place deduplication —** to a realistic backend scenario.

---

# Problem Statement
Given a list of transaction IDs received by a payment system:
- Transaction IDs may contain duplicates  
- Input is assumed to be **sorted**  
- Each transaction should be processed **only once**  
- Extra memory usage should be minimized  

---

# Approach
- Use **in-place array processing** to remove duplicate transaction IDs  
- Maintain an index pointing to the last unique transaction  
- Compare each incoming transaction with the previous unique one  
- Process only unique transactions  

This avoids extra data structures like `HashSet`, keeping the solution memory-efficient.

---

# How to compile and Run the program
- javac src/PaymentEventProcessor.java
- java -cp src PaymentEventProcessor

---

# Output
Screenshort of output- ![alt text](<Screenshot 2026-02-02 230100.png>)
Output Video - <video controls src="Payment Event Processor - Made with Clipchamp.mp4" title="Title"></video>

# Complexity Analysis
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)  

---

# What Does *Idempotent* Mean?
The term **idempotent** comes from mathematics and computer science.  
An operation is *idempotent* if applying it multiple times has the **same effect as applying it once**.

**Examples in systems:**
- In payments: processing `TXN123` multiple times → handled only once.  
- In HTTP: methods like **GET, PUT, DELETE** are idempotent (same result no matter how many times they are called).  
This property is critical in backend systems where failures and retries are inevitable.

---

# Note
This is a learning-focused project and does not represent a complete payment system.
It demonstrates the core idea of handling duplicate efficiently.

---

