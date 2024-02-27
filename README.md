# Multithreaded File Processor in Java

This project implements a Java program that utilizes multithreading to process text files concurrently. It takes a directory path as user input, identifies files within the directory, and spawns separate threads to analyze each file.

## Features:

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
* Java I/O API
* Java Concurrency Utilities