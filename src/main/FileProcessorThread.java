package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileProcessorThread implements Runnable {

    private final File file;
    private final Map<String, Integer> wordCount;
    private final Map<Character, Integer> charCount;
    private int totalWordCount = 0;

    public FileProcessorThread(File file) {
        this.file = file;
        this.wordCount = new HashMap<>();
        this.charCount = new HashMap<>();
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while processing file: " + e.getMessage());
        }
    }

    private void processLine(String line) {
        // basic method for word count, no.of words and character frequency.

        // Split the line into words
        String[] words = line.split("\\W+"); // Splits on non-word characters
        for (String word : words) {
            word = word.toLowerCase(); // Convert to lowercase
            totalWordCount += 1;
            //if character is available in the map, then increment the value by 1
            //else add the character to the map with value 1 (default (0) + 1 = 1)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Count character frequency
        for (char character : line.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                //if character is available in the map, then increment the value by 1
                //else add the character to the map with value 1 (default (0) + 1 = 1)
                charCount.put(character, charCount.getOrDefault(character, 0) + 1);
            }
        }

    }

    public void getResults() {
        System.out.println("--------------------------------------");
        System.out.println("File: " + file.getName());
        System.out.println();
        System.out.println("Total no.of words: " + totalWordCount);
        System.out.println();
        System.out.println("Word count: " + wordCount);
        System.out.println();
        System.out.println("Character frequency: " + charCount);
        System.out.println("--------------------------------------");
    }

    // getter method for wordCount
    public Map<String, Integer> getWordCount() {
        return wordCount;
    }

    // getter method for charCount
    public Map<Character, Integer> getCharCount() {
        return charCount;
    }

    // getter method for totalWordCount
    public int getTotalWordCount() {
        return totalWordCount;
    }

    public char[] getFileName() {
        return file.getName().toCharArray();
    }
}


