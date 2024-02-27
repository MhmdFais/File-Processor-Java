package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileProcessorThread implements Runnable {

    private final File file;
    private Map<String, Integer> wordCount;
    private Map<Character, Integer> charFrequency;

    public FileProcessorThread(File file) {
        this.file = file;
        this.wordCount = new HashMap<>();
        this.charFrequency = new HashMap<>();
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processLine(String line) {
        // This method can be further improved to handle specific analysis tasks.
        // Here's a basic example for word count and character frequency.

        // Split the line into words
        String[] words = line.split("\\W+"); // Splits on non-word characters
        for (String word : words) {
            word = word.toLowerCase(); // Consider handling case sensitivity as needed
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Count character frequency
        for (char character : line.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                charFrequency.put(character, charFrequency.getOrDefault(character, 0) + 1);
            }
        }
    }

    public boolean getResults() {
        // This method should return the results obtained from processing the file.
        // The specific format of the results may vary depending on your chosen analysis.
        // Implement logic to retrieve and return results from this thread
        System.out.println("File: " + file.getName());
        System.out.println("Word count: " + wordCount);
        System.out.println("Character frequency: " + charFrequency);
        return true;
    }
}


