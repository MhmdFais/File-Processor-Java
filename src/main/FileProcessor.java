package main;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileProcessor {
    private final String directoryPath;
    private final ExecutorService executor;
    private final ArrayList<FileProcessorThread> threads;

    public FileProcessor(String directoryPath) {
        this.directoryPath = directoryPath;
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // Use available processors
        this.threads = new ArrayList<>();
    }

    public void processFiles() {
        File dir = new File(directoryPath);
        if (!dir.isDirectory()) {
            System.out.println("Invalid directory path!");
            return;
        }

        // Identify text files
        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                FileProcessorThread thread = new FileProcessorThread(file);
                threads.add(thread);
                executor.submit(thread); // Submit each thread to the executor
            }
        }

        // Wait for all threads to finish
        try {
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print processing results (implement this based on your chosen analysis)
        printProcessingResults();
    }

    private void printProcessingResults() {
        // This method should iterate through the 'threads' list and print the results
        // obtained from each FileProcessorThread object. The specific format of the
        // results may vary depending on your chosen analysis.
        for (FileProcessorThread thread : threads) {
            // Implement logic to retrieve and print results from each thread
            System.out.println(thread.getResults()); // Replace with your implementation
        }
    }
}
