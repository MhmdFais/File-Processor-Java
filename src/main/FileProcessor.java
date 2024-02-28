package main;

import gui.MainGUI;
import javax.swing.*;
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
            MainGUI.resultTextArea.setText("Error occurred while waiting for threads to finish: " + e.getMessage());
        }

        // Print processing results
        printProcessingResults();
        //update UI
        updateResultsUI();
    }

    private void updateResultsUI() {
        StringBuilder results = new StringBuilder();

        for (FileProcessorThread thread : threads) {
            int wordCount = thread.getWordCount().size();
            int characterCount = thread.getCharCount().size();

            results.append("File: ").append(thread.getFileName()).append("\n");
            results.append("Word count: ").append(wordCount).append("\n");
            results.append("Character count: ").append(characterCount).append("\n\n");
        }

        MainGUI.resultTextArea.setText(results.toString()); // Update the text area in the UI
    }

    public void printProcessingResults() {
        // This method is to iterate through the 'threads' list and print the results
        for (FileProcessorThread thread : threads) {
            thread.getResults();
        }
    }
}
