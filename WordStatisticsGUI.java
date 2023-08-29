import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class WordStatisticsGUI extends JFrame {
    private JTextArea textArea;
    private JButton analyzeButton;
    private JTextArea resultArea;

    public WordStatisticsGUI() {
        setTitle("Word Statistics Analyzer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        analyzeButton = new JButton("Analyze");
        resultArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(analyzeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        add(resultArea, BorderLayout.EAST);

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeText();
            }
        });
    }

    private void analyzeText() {
        String inputText = textArea.getText();
        String[] words = splitIntoWords(inputText);
        int totalWordCount = words.length;
        int uniqueWordCount = countUniqueWords(words);
        Map<String, Integer> wordFrequency = calculateWordFrequency(words);

        StringBuilder result = new StringBuilder();
        result.append("Total word count: ").append(totalWordCount).append("\n");
        result.append("Unique word count: ").append(uniqueWordCount).append("\n\n");
        result.append("Word frequencies:\n");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        resultArea.setText(result.toString());
    }

    private String[] splitIntoWords(String text) {
        return text.split("[\\s\\p{Punct}]+");
    }

    private int countUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords.size();
    }

    private Map<String, Integer> calculateWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordStatisticsGUI gui = new WordStatisticsGUI();
                gui.setVisible(true);
            }
        });
    }
}
