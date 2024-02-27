package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Get the directory path from the user
        String directoryPath = getDirectoryPath();

        // Start the file processing
        FileProcessor fileProcessor = new FileProcessor(directoryPath);
        fileProcessor.processFiles();

        System.out.println("Processing complete!");
    }

    public static String getDirectoryPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        return scanner.nextLine();
    }
}