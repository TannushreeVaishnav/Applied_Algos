# Server-Load-Analysis-Java
Real-world server load analysis using optimized array algorithms in Java,including edge case handling and stability detection

# Overview
 It is a simple Java program that analyzes server CPU usage data.It allows the user to input CPU usage values and then provides insights such as:
- Maximum CPU usage
- Second maximum CPU usage (without sorting)
- Whether the CPU usage trend is stable (non-decreasing)

# Stable Trend
A stable trend means a pattern that doesn’t drop over time.
- CPU usage gradually increasing or staying the same → stable (true)
- CPU usage suddenly falling → not stable (false)
# Compile Program
 javac src/ServerLoadAnalysis.java

 # Run the Program
 java -cp src ServerLoadAnalysis

 # Output
 ![alt text](<Screenshot 2026-02-01 200647.png>)

 # Time and Space Complexity

| Time Complexity | Space Complexity |
|-----------------|------------------|
| O(n)            | O(1)             |

# Purpose
This was written to practice:
- Finding maximum and second maximum values without sorting
- Checking trends in data
- Writing clean and understandable Java code
