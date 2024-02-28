package gui;

import main.FileProcessor;
import main.FileProcessorThread;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    private JTextField filePathField;
    private JButton submitButton;
    public static JTextArea resultTextArea;

    private String filePath;

    public MainGUI() {
        super("File Processor");

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create components
        //filePathField = new JTextField(20);
        submitButton = new JButton("Select File");
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);

        // Set up layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        //inputPanel.add(new JLabel("File Path:"));
        ///inputPanel.add(filePathField);
        inputPanel.add(submitButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        // Add components to the frame
        add(mainPanel);

        // Add action listener to the submit button
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                filePath = filePathField.getText();
//                FileProcessor fileProcessor = new FileProcessor(filePath);
//                fileProcessor.processFiles();
//            }
//        });

        //file selector button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Choose directories only
                fileChooser.setAcceptAllFileFilterUsed(false); // Don't accept all file types
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    FileProcessor fileProcessor = new FileProcessor(filePath);
                    fileProcessor.processFiles();
                    fileProcessor.processFiles();
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainGUI gui = new MainGUI();
                gui.setVisible(true);
            }
        });
    }
}
