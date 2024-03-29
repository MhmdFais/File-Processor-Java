# Multithreading File Processor in Java

This project implements a Java program that utilizes multithreading to process text files concurrently. 
It takes a directory path as user input, identifies files within the directory, 
and spawns separate threads to analyze each file.

## Features:

* GUI: A simple GUI to select the directory and display the results.
* Directory Traversal: Recursively traverses the directory to identify all files for processing.
* Multithreading: Utilizes threads to process files concurrently, potentially improving performance.
* File Processing: Reads content from each file and performs basic analysis (e.g., word count, character frequency).
* Synchronization: Ensures thread-safe access to shared resources through appropriate synchronization mechanisms.
* Error Handling: Catches potential exceptions during file operations and thread execution.
* User Input: Accepts the directory path from the user through the console.
* Summary Output: Displays a summary of processed files and their analysis results.


## Implementation Details:

* Thread Pool: Uses a thread pool to manage a fixed number of worker threads for efficient resource utilization.
* Runnable Interface: Implements the Runnable interface for each file processing task.
* Shared Data Structure: Utilizes a thread-safe data structure (e.g., ConcurrentHashMap) to store processing results and avoid data corruption.


## Technologies Used:

* Java 21
* Java Thread Pool Executor
* Java Swing API
* Java I/O API
* Java Concurrency Utilities

## Usage:

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Run the `MainGUI` class.
4. Enter the directory path when prompted.
5. View the summary on the display.
6. Modify the `FileProcessorThread` class to add more analysis tasks or improve the existing ones.
7. Experiment with different thread pool configurations to observe performance variations.
8. Test the program with different directory structures and file types.
9. Share your feedback and suggestions for improvement. 
10. Contribute to the project by adding new features or fixing existing issues.

Copyright &copy; 2024 Muhammed
